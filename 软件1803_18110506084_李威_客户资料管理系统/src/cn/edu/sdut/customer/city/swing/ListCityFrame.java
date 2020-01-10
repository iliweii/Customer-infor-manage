package cn.edu.sdut.customer.city.swing;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Toolkit;
import java.util.List;
import java.util.Vector;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

import cn.edu.sdut.comm.prorperties.factory.BeanFactory;
import cn.edu.sdut.customer.city.dao.CityDao;
import cn.edu.sdut.customer.city.entity.City;
import cn.edu.sdut.customer.comm.CommonUtils;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.TitledBorder;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.ImageIcon;

public class ListCityFrame extends JFrame {

	private JPanel contentPane;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ListCityFrame frame = new ListCityFrame();
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
	public ListCityFrame() {
		setTitle("城市列表信息");
		setIconImage(Toolkit.getDefaultToolkit().getImage(ListCityFrame.class.getResource("/images/city.png")));
		setBounds(100, 100, 702, 452);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JScrollPane scrollPane = new JScrollPane();
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "\u67E5\u8BE2\u57CE\u5E02\u4FE1\u606F", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new TitledBorder(null, "\u57CE\u5E02\u4FE1\u606F", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addComponent(panel, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 698, Short.MAX_VALUE)
				.addComponent(panel_1, GroupLayout.DEFAULT_SIZE, 698, Short.MAX_VALUE)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 673, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(25, Short.MAX_VALUE))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, 79, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 153, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(panel_1, GroupLayout.DEFAULT_SIZE, 138, Short.MAX_VALUE))
		);
		
		JLabel label = new JLabel("城市编号：");
		
		cityidText = new JTextField();
		cityidText.setEditable(false);
		cityidText.setColumns(10);
		
		JLabel label_1 = new JLabel("城市名称：");
		
		citynameText = new JTextField();
		citynameText.setColumns(10);
		
		JButton btnNewButton = new JButton("修改城市");
		btnNewButton.setIcon(new ImageIcon(ListCityFrame.class.getResource("/images/add.png")));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				updateCity(e);
				
				
			}
		});
		
		JButton btnNewButton_1 = new JButton("删除城市");
		btnNewButton_1.setIcon(new ImageIcon(ListCityFrame.class.getResource("/images/delete.png")));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				deletebutton(arg0);
			}
		});
		GroupLayout gl_panel_1 = new GroupLayout(panel_1);
		gl_panel_1.setHorizontalGroup(
			gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_1.createSequentialGroup()
					.addContainerGap()
					.addComponent(label)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel_1.createSequentialGroup()
							.addComponent(cityidText, GroupLayout.PREFERRED_SIZE, 185, GroupLayout.PREFERRED_SIZE)
							.addGap(66)
							.addComponent(label_1))
						.addComponent(btnNewButton))
					.addGap(18)
					.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
						.addComponent(btnNewButton_1)
						.addComponent(citynameText, GroupLayout.PREFERRED_SIZE, 193, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(30, Short.MAX_VALUE))
		);
		gl_panel_1.setVerticalGroup(
			gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_1.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel_1.createParallelGroup(Alignment.BASELINE)
						.addComponent(label)
						.addComponent(cityidText, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(label_1)
						.addComponent(citynameText, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED, 34, Short.MAX_VALUE)
					.addGroup(gl_panel_1.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnNewButton)
						.addComponent(btnNewButton_1))
					.addContainerGap())
		);
		panel_1.setLayout(gl_panel_1);
		
		JLabel lblNewLabel = new JLabel("城市信息：");
		lblNewLabel.setIcon(new ImageIcon(ListCityFrame.class.getResource("/images/city.png")));
		
		searchCitynameText = new JTextField();
		searchCitynameText.setColumns(10);
		
		JButton searchCityButton = new JButton("查询");
		searchCityButton.setIcon(new ImageIcon(ListCityFrame.class.getResource("/images/search.png")));
		searchCityButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				searchCityButton(arg0);
			}
		});
		
		JButton resetCityButton = new JButton("清空");
		resetCityButton.setIcon(new ImageIcon(ListCityFrame.class.getResource("/images/reset.png")));
		resetCityButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				resetCityButton(arg0);
			}
		});
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(27)
					.addComponent(lblNewLabel)
					.addGap(18)
					.addComponent(searchCitynameText, GroupLayout.PREFERRED_SIZE, 164, GroupLayout.PREFERRED_SIZE)
					.addGap(135)
					.addComponent(searchCityButton)
					.addPreferredGap(ComponentPlacement.RELATED, 42, Short.MAX_VALUE)
					.addComponent(resetCityButton)
					.addGap(25))
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel)
						.addComponent(searchCitynameText, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(searchCityButton)
						.addComponent(resetCityButton))
					.addContainerGap(21, Short.MAX_VALUE))
		);
		panel.setLayout(gl_panel);
		
		table = new JTable();
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent arg0) {
				detailCity(arg0);
			}
		});
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"\u57CE\u5E02\u5E8F\u53F7", "\u57CE\u5E02\u540D\u79F0"
			}
		) {
			boolean[] columnEditables = new boolean[] {
				false, false
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		scrollPane.setViewportView(table);
		contentPane.setLayout(gl_contentPane);
		
		this.setLocationRelativeTo(null);
		DefaultTableCellRenderer r = new DefaultTableCellRenderer();
		r.setHorizontalAlignment(JLabel.CENTER);
		this.table.setDefaultRenderer(Object.class, r);
		//调用getCitys(null)
		this.getCitys(null);
	}
	
	/**
	 * 删除城市按钮
	 * @param arg0
	 */
	protected void deletebutton(ActionEvent arg0) {
		int cityid = Integer.parseInt(this.cityidText.getText());
		int row = dao.deleteCity(cityid);
		if (row >0) {
			JOptionPane.showMessageDialog(this, "删除成功");
		}else {
			JOptionPane.showMessageDialog(this, "删除失败");
		}
		//调用getCitys(null)
		this.getCitys(null);
	}

	/**
	 * 修改一条城市信息
	 * @param e
	 */
	protected void updateCity(ActionEvent e) {
		String temp = this.cityidText.getText();
		if(temp.isEmpty()) {
			JOptionPane.showMessageDialog(this, "班级编号不能为空！");
			return ;
		}
		int cityid = Integer.parseInt(temp);
		String cityname = this.citynameText.getText();
		City city = new City();
		city.setCityid(cityid);
		city.setCityname(cityname);
		int row = dao.updateCity(city);
		if(row > 0) {
			JOptionPane.showMessageDialog(this, "修改成功");
			this.getCitys(null);
		}else {
			JOptionPane.showMessageDialog(this, "修改失败");
		}
	}

	/**
	 * 根据cityid查询城市信息
	 * @param arg0
	 */
	protected void detailCity(MouseEvent arg0) {
		int row = this.table.getSelectedRow();
		int cityid = (Integer)this.table.getValueAt(row, 0);
		City city = dao.queryCityById(cityid);
		this.cityidText.setText(String.valueOf(city.getCityid()));
		this.citynameText.setText(city.getCityname());
		
	}

	/**
	 * 根据条件查询城市列表
	 * @param arg0
	 */
	protected void searchCityButton(ActionEvent arg0) {
		String cityname = this.searchCitynameText.getText();
		City city = new City();
		city.setCityname(cityname);
		this.getCitys(city);
	}

	/*
	   * 重置查询班级的按钮
	 * @param arg0
	 */
	protected void resetCityButton(ActionEvent arg0) {
		//清空查询条件
		this.searchCitynameText.setText("");
		//初始化查询列表
		this.getCitys(null);
	}

	/**
	 * 调用dao的queryAllCity
	 */
	private void getCitys(City city) {
		List<City> list = dao.queryAllCity(city);
		DefaultTableModel model = (DefaultTableModel) this.table.getModel();
		model.setRowCount(0);
		if(list.size() > 0) {
			
			for (City c : list) {
				Vector<Object> vector = new Vector<Object>();
				vector.add(c.getCityid());
				vector.add(c.getCityname());
				model.addRow(vector);
			}
		}else {
			JOptionPane.showMessageDialog(this, "对不起，没有查询到相关记录");
		}
	}
	
	private CityDao dao = BeanFactory.getInstance(CommonUtils.CityInfo.CITYDAO);
	private JTextField searchCitynameText;
	private JTextField cityidText;
	private JTextField citynameText;
}
