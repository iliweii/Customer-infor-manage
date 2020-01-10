package cn.edu.sdut.customer.city.swing;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import cn.edu.sdut.comm.prorperties.factory.BeanFactory;
import cn.edu.sdut.customer.city.dao.CityDao;
import cn.edu.sdut.customer.city.entity.City;
import cn.edu.sdut.customer.comm.CommonUtils;

import java.awt.Toolkit;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AddCityFrame extends JFrame {

	private JPanel contentPane;
	private JTextField citynameText;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddCityFrame frame = new AddCityFrame();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public AddCityFrame() {
		setTitle("新增城市信息");
		setIconImage(Toolkit.getDefaultToolkit().getImage(AddCityFrame.class.getResource("/images/city.png")));
		setBounds(100, 100, 571, 332);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JLabel lblNewLabel = new JLabel("城市名称：");
		
		citynameText = new JTextField();
		citynameText.setColumns(10);
		
		JButton saveCityButton = new JButton("保    存");
		saveCityButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				addButton(e);
			}
		});
		saveCityButton.setIcon(new ImageIcon(AddCityFrame.class.getResource("/images/checked.png")));
		
		JButton resetCityButton = new JButton("重    置");
		resetCityButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				resetButton(arg0);
			}
		});
		resetCityButton.setIcon(new ImageIcon(AddCityFrame.class.getResource("/images/reset.png")));
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(56)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
						.addComponent(lblNewLabel)
						.addComponent(saveCityButton))
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(39)
							.addComponent(citynameText, GroupLayout.PREFERRED_SIZE, 196, GroupLayout.PREFERRED_SIZE)
							.addContainerGap(139, Short.MAX_VALUE))
						.addGroup(Alignment.TRAILING, gl_contentPane.createSequentialGroup()
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(resetCityButton)
							.addGap(74))))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(83)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel)
						.addComponent(citynameText, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED, 90, Short.MAX_VALUE)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(saveCityButton, GroupLayout.PREFERRED_SIZE, 34, GroupLayout.PREFERRED_SIZE)
						.addComponent(resetCityButton))
					.addGap(51))
		);
		contentPane.setLayout(gl_contentPane);
	}

	/**
	 * 新增班级信息
	 * @param e
	 */
	protected void addButton(ActionEvent e) {
		String cityname = this.citynameText.getText();
		if(cityname.isEmpty()) {
			JOptionPane.showMessageDialog(this, "请输入城市名称");
			this.citynameText.requestFocus();
			return ;
		}
		if(cityname.length() > 20) {
			JOptionPane.showMessageDialog(this, "对不起，城市名称不能超过20位！");
			this.citynameText.requestFocus();
			return ;
		}
		City city = new City();
		city.setCityname(cityname);
		int row = cdao.addCity(city);
		if(row > 0) {
			JOptionPane.showMessageDialog(this, "保存城市信息成功");
		}else {
			JOptionPane.showMessageDialog(this, "保存城市信息失败");
		}
	}

	
	private CityDao cdao = BeanFactory.getInstance(CommonUtils.CityInfo.CITYDAO);
	protected void resetButton(ActionEvent arg0) {
		this.citynameText.setText("");
		this.citynameText.requestFocus();
		
	}
}
