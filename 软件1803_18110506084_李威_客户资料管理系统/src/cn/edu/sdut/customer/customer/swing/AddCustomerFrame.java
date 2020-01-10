package cn.edu.sdut.customer.customer.swing;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import cn.edu.sdut.comm.prorperties.factory.BeanFactory;
import cn.edu.sdut.customer.city.dao.CityDao;
import cn.edu.sdut.customer.city.entity.City;
import cn.edu.sdut.customer.comm.CommonUtils;
import cn.edu.sdut.customer.customer.dao.CustomerDao;
import cn.edu.sdut.customer.customer.entity.Customer;
import cn.edu.sdut.customer.user.entity.UserRoles;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import java.awt.Toolkit;
import java.util.List;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JList;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JMenuBar;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JComboBox;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AddCustomerFrame extends JFrame {
	private JTextField usernameText;
	private JTextField userphoneText;
	private JTextField useremailText;
	private JRadioButton menjrb;
	private JRadioButton womenjrb;
	private JComboBox comboBox;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddCustomerFrame frame = new AddCustomerFrame();
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
	public AddCustomerFrame() {
		setTitle("新增客户信息");
		setIconImage(Toolkit.getDefaultToolkit().getImage(AddCustomerFrame.class.getResource("/images/customer.png")));
		setBounds(100, 100, 824, 455);
		
		JLabel lblNewLabel = new JLabel("客户姓名：");
		
		usernameText = new JTextField();
		usernameText.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("客户电话：");
		
		userphoneText = new JTextField();
		userphoneText.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("客户邮箱：");
		
		useremailText = new JTextField();
		useremailText.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("客户等级：");
		
		JLabel lblNewLabel_4 = new JLabel("客户性别：");
		
		menjrb = new JRadioButton("男");
		buttonGroup.add(menjrb);
		menjrb.setSelected(true);
		
		womenjrb = new JRadioButton("女");
		buttonGroup.add(womenjrb);
		
		JLabel lblNewLabel_5 = new JLabel("客户城市：");
		
		JButton btnNewButton = new JButton("保存客户");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				addCoustomerButton(arg0);
			}
		});
		btnNewButton.setIcon(new ImageIcon(AddCustomerFrame.class.getResource("/images/user.png")));
		
		JButton btnNewButton_1 = new JButton("重    置");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				resetButton(arg0);
			}
		});
		btnNewButton_1.setIcon(new ImageIcon(AddCustomerFrame.class.getResource("/images/reset.png")));
		
		comboBox = new JComboBox();
		
		textField = new JTextField();
		textField.setColumns(10);
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(53)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
							.addGroup(groupLayout.createSequentialGroup()
								.addComponent(lblNewLabel_2)
								.addGap(18)
								.addComponent(useremailText))
							.addGroup(groupLayout.createSequentialGroup()
								.addComponent(lblNewLabel)
								.addGap(18)
								.addComponent(usernameText, GroupLayout.PREFERRED_SIZE, 159, GroupLayout.PREFERRED_SIZE)))
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(lblNewLabel_4)
							.addGap(18)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(btnNewButton)
								.addGroup(groupLayout.createSequentialGroup()
									.addComponent(menjrb)
									.addGap(62)
									.addComponent(womenjrb)))))
					.addGap(128)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(lblNewLabel_1)
							.addGap(18)
							.addComponent(userphoneText, GroupLayout.PREFERRED_SIZE, 186, GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(lblNewLabel_3)
							.addGap(18)
							.addComponent(textField, GroupLayout.DEFAULT_SIZE, 186, Short.MAX_VALUE))
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(lblNewLabel_5)
							.addGap(18)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addGroup(groupLayout.createSequentialGroup()
									.addComponent(btnNewButton_1)
									.addPreferredGap(ComponentPlacement.RELATED, 55, Short.MAX_VALUE))
								.addComponent(comboBox, 0, 186, Short.MAX_VALUE))))
					.addGap(94))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(61)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel)
						.addComponent(usernameText, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel_1)
						.addComponent(userphoneText, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(73)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_2)
						.addComponent(useremailText, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel_3)
						.addComponent(textField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(57)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_4)
						.addComponent(menjrb)
						.addComponent(womenjrb)
						.addComponent(lblNewLabel_5)
						.addComponent(comboBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED, 48, Short.MAX_VALUE)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnNewButton)
						.addComponent(btnNewButton_1))
					.addGap(53))
		);
		getContentPane().setLayout(groupLayout);
		this.setLocationRelativeTo(null);
		getCitys(null);
	}
	
	/**
	 * 重置按钮
	 */
	protected void resetButton(ActionEvent arg0) {
		this.textField.setText("");
		this.usernameText.setText("");
		this.userphoneText.setText("");
		this.useremailText.setText("");
	}

	/**
	 * 新增客户
	 * private Integer custid,cityid,cuslevel;
	private String custname,custphone,cuetemail,custgender;
	 */
	protected void addCoustomerButton(ActionEvent arg0) {
		String cityname = (String) this.comboBox.getItemAt(comboBox.getSelectedIndex());
		City city = dao.queryCityByName(cityname);
		int cityid = city.getCityid();
		int cuslevel = Integer.parseInt(this.textField.getText());
		String custname = this.usernameText.getText();
		String custphone = this.userphoneText.getText();
		String cuetmail = this.useremailText.getText();
		String custgender;
		if (this.menjrb.isSelected()) {
			custgender = "男";
		} else {
			custgender = "女";
		}
		Customer cus = new Customer();
		cus.setCityid(cityid);
		cus.setCuslevel(cuslevel);
		cus.setCustname(custname);
		cus.setCustphone(custphone);
		cus.setCuetemail(cuetmail);
		cus.setCustgender(custgender);
		int row = cdao.addCustomer(cus);
		if (row>0) {
			JOptionPane.showMessageDialog(this, "添加成功");
		}else {
			JOptionPane.showMessageDialog(this, "添加失败");
		}
		
	}

	private CityDao dao = BeanFactory.getInstance(CommonUtils.CityInfo.CITYDAO);
	private CustomerDao cdao = BeanFactory.getInstance(CommonUtils.CustomerInof.CUSTOMERDAO);
	/**
	 * 获得城市信息，填充到城市下拉列表
	 */
	private void getCitys(String type) {
		List<City> list = dao.queryCityToCustomer();
		for (City city : list) {
			if("search".equals(type)) {
				City c = new City();
				c.setCityname("--请选择--");
				//查询条件的下拉列表
			}else{
				//修改客户信息的下拉列表
				this.comboBox.addItem(city.getCityname());
			}
		}
	}
	
	
	
	
	
	
	
	
	
}
