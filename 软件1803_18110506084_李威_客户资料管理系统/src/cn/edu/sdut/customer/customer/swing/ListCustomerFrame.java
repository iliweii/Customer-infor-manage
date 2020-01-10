package cn.edu.sdut.customer.customer.swing;

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
import cn.edu.sdut.customer.customer.dao.CustomerDao;
import cn.edu.sdut.customer.customer.entity.Customer;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.TitledBorder;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import javax.swing.JComboBox;
import javax.swing.ImageIcon;

public class ListCustomerFrame extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private JRadioButton menjrbn,womenjrb;
	private JComboBox cityidJrb;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ListCustomerFrame frame = new ListCustomerFrame();
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
	public ListCustomerFrame() {
		setTitle("客户列表");
		setIconImage(Toolkit.getDefaultToolkit().getImage(ListCustomerFrame.class.getResource("/images/customer.png")));
		setBounds(100, 100, 985, 642);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JScrollPane scrollPane = new JScrollPane();
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "\u67E5\u8BE2\u5BA2\u6237\u4FE1\u606F", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new TitledBorder(null, "\u4FEE\u6539\u5BA2\u6237\u4FE1\u606F", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 943, Short.MAX_VALUE)
						.addComponent(panel_1, GroupLayout.DEFAULT_SIZE, 943, Short.MAX_VALUE)
						.addComponent(panel, GroupLayout.DEFAULT_SIZE, 957, Short.MAX_VALUE))
					.addContainerGap())
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(24)
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, 143, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 181, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(panel_1, GroupLayout.DEFAULT_SIZE, 212, Short.MAX_VALUE))
		);
		
		JLabel label_1 = new JLabel("客户编号：");
		
		custidText = new JTextField();
		custidText.setEditable(false);
		custidText.setColumns(10);
		
		JLabel label_2 = new JLabel("客户名称：");
		
		custnameText = new JTextField();
		custnameText.setColumns(10);
		
		JLabel label_3 = new JLabel("客户电话：");
		
		custphoneText = new JTextField();
		custphoneText.setColumns(10);
		
		JLabel label_4 = new JLabel("客户邮箱：");
		
		cuetemailText = new JTextField();
		cuetemailText.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("性别 ：");
		
		JLabel lblNewLabel_1 = new JLabel("城市：");
		
		JLabel label_5 = new JLabel("客户等级：");
		
		cuslevelText = new JTextField();
		cuslevelText.setColumns(10);
		
		JButton gainameButton = new JButton("修改信息");
		gainameButton.setIcon(new ImageIcon(ListCustomerFrame.class.getResource("/images/add.png")));
		gainameButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				gainameButton(e);
			}
		});
		
		JButton deleButton = new JButton("删除信息");
		deleButton.setIcon(new ImageIcon(ListCustomerFrame.class.getResource("/images/delete.png")));
		deleButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				deleButton(e);
			}
		});
		
		menjrbn = new JRadioButton("男");
		buttonGroup.add(menjrbn);
		menjrbn.setSelected(true);
		
		womenjrb = new JRadioButton("女");
		buttonGroup.add(womenjrb);
		
		cityidJrb = new JComboBox();
		GroupLayout gl_panel_1 = new GroupLayout(panel_1);
		gl_panel_1.setHorizontalGroup(
			gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_1.createSequentialGroup()
					.addGap(28)
					.addGroup(gl_panel_1.createParallelGroup(Alignment.TRAILING)
						.addComponent(gainameButton)
						.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING, false)
							.addGroup(gl_panel_1.createSequentialGroup()
								.addComponent(label_4)
								.addGap(18)
								.addComponent(cuetemailText))
							.addGroup(gl_panel_1.createSequentialGroup()
								.addComponent(label_1)
								.addGap(18)
								.addComponent(custidText, GroupLayout.PREFERRED_SIZE, 130, GroupLayout.PREFERRED_SIZE))))
					.addGap(105)
					.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel_1.createSequentialGroup()
							.addComponent(label_2)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(custnameText, GroupLayout.PREFERRED_SIZE, 143, GroupLayout.PREFERRED_SIZE)
							.addGap(25)
							.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_panel_1.createSequentialGroup()
									.addComponent(label_3)
									.addGap(18)
									.addComponent(custphoneText, GroupLayout.DEFAULT_SIZE, 211, Short.MAX_VALUE))
								.addComponent(deleButton)))
						.addGroup(gl_panel_1.createSequentialGroup()
							.addComponent(lblNewLabel)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(menjrbn)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(womenjrb)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(lblNewLabel_1)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(cityidJrb, 0, 88, Short.MAX_VALUE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(label_5)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(cuslevelText, GroupLayout.PREFERRED_SIZE, 184, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap())
		);
		gl_panel_1.setVerticalGroup(
			gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_1.createSequentialGroup()
					.addGap(24)
					.addGroup(gl_panel_1.createParallelGroup(Alignment.BASELINE)
						.addComponent(custnameText, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(label_2)
						.addComponent(custidText, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(label_1)
						.addComponent(custphoneText, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(label_3))
					.addGap(42)
					.addGroup(gl_panel_1.createParallelGroup(Alignment.BASELINE)
						.addComponent(label_4)
						.addComponent(cuetemailText, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel_1)
						.addComponent(womenjrb)
						.addComponent(menjrbn)
						.addComponent(lblNewLabel)
						.addComponent(cityidJrb, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(cuslevelText, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(label_5))
					.addPreferredGap(ComponentPlacement.RELATED, 28, Short.MAX_VALUE)
					.addGroup(gl_panel_1.createParallelGroup(Alignment.BASELINE)
						.addComponent(gainameButton)
						.addComponent(deleButton))
					.addContainerGap())
		);
		panel_1.setLayout(gl_panel_1);
		
		JLabel label = new JLabel("客户姓名：");
		
		searchCustnameText = new JTextField();
		searchCustnameText.setColumns(10);
		
		JButton searchCustButton = new JButton("查    询");
		searchCustButton.setIcon(new ImageIcon(ListCustomerFrame.class.getResource("/images/search.png")));
		searchCustButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				searchCustButton(arg0);
			}
		});
		
		JButton resetCustButton = new JButton("清    空");
		resetCustButton.setIcon(new ImageIcon(ListCustomerFrame.class.getResource("/images/reset.png")));
		resetCustButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				resetCustButton(arg0);
			}
		});
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(35)
					.addComponent(label)
					.addGap(18)
					.addComponent(searchCustnameText, GroupLayout.PREFERRED_SIZE, 206, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED, 156, Short.MAX_VALUE)
					.addComponent(searchCustButton)
					.addGap(147)
					.addComponent(resetCustButton)
					.addGap(104))
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(43)
					.addGroup(gl_panel.createParallelGroup(Alignment.TRAILING)
						.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
							.addComponent(searchCustnameText, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addComponent(resetCustButton)
							.addComponent(searchCustButton))
						.addComponent(label))
					.addContainerGap(46, Short.MAX_VALUE))
		);
		panel.setLayout(gl_panel);
		
		table = new JTable();
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent arg0) {
				detailCustomer(arg0);
			}
		});
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"\u5BA2\u6237\u7F16\u53F7", "\u5BA2\u6237\u59D3\u540D", "\u5BA2\u6237\u7535\u8BDD", "\u5BA2\u6237\u6027\u522B", "\u5BA2\u6237\u57CE\u5E02", "\u5BA2\u6237\u90AE\u7BB1", "\u5BA2\u6237\u7B49\u7EA7"
			}
		));
		scrollPane.setViewportView(table);
		contentPane.setLayout(gl_contentPane);
		this.setLocationRelativeTo(null);
		//默认居中
		DefaultTableCellRenderer r = new DefaultTableCellRenderer();
		r.setHorizontalAlignment(JLabel.CENTER);
		this.table.setDefaultRenderer(Object.class, r);
		//调用getCustomers(null)
		this.getCustomers(null);
	}
	
	
	
	
	/**
	 * UPDATE customer SET custname = ?,custphone = ?,cuetemail = ?,custgender = ?,cityid = ?,cuslevel = ?  WHERE custid = ?
	 * Customer(custid=null, cityid=null, cuslevel=2, custname=null, custphone=123456, cuetemail=123@qq.com, custgender=null)
	 * @param e
	 */
protected void gainameButton(ActionEvent e) {
		String strCustid = this.custidText.getText();
		int custid = Integer.parseInt(strCustid);
		String custname = this.custnameText.getText();
		String cityname = (String) this.cityidJrb.getItemAt(cityidJrb.getSelectedIndex());
		String cuetemail = this.cuetemailText.getText();
		String custphone = this.custphoneText.getText();
		City city = dao.queryCityByName(cityname);
		
		int cuslevel = Integer.parseInt(this.cuslevelText.getText());
		
		Customer customer =  new Customer();
		customer.setCustid(custid);
		customer.setCustname(custname);
		customer.setCuetemail(cuetemail);
		customer.setCityid(city.getCityid());
		customer.setCuslevel(cuslevel);
		customer.setCustphone(custphone);
		if(this.menjrbn.isSelected()) {
			customer.setCustgender("男");
		}else {
			customer.setCustgender("女");
		}
		int row = cdao.updateCustomer(customer);
		if(row > 0) {
			JOptionPane.showMessageDialog(this, "修改成功");
			this.getCustomers(null);
		}else {
			JOptionPane.showMessageDialog(this, "修改失败");
		}
		
		
	}

	protected void deleButton(ActionEvent e) {
		String strCustid = this.custidText.getText();
		int custid = Integer.parseInt(strCustid);
		int row = this.cdao.deleteCustomer(custid);
		if(row > 0) {
			JOptionPane.showMessageDialog(this, "删除客户成功");
			this.getCustomers(null);
		}else {
			JOptionPane.showMessageDialog(this, "删除客户失败");
		}
	}

	/**
	 * 根据custid查询一条客户信息
	 * @param arg0
	 */
	
	protected void detailCustomer(MouseEvent arg0) {
		int row = this.table.getSelectedRow();
		int custid = (Integer)this.table.getValueAt(row, 0);
		Customer customer = cdao.queryCustomerById(custid);
		this.custidText.setText(String.valueOf(customer.getCustid()));
		this.custnameText.setText(customer.getCustname());
		this.custphoneText.setText(customer.getCustphone());
		this.cuetemailText.setText(customer.getCuetemail());
		this.getCitys("modify");
		this.cuslevelText.setText(String.valueOf(customer.getCuslevel()));
		if(customer.getCustgender().equals("男")) {
			this.menjrbn.setSelected(true);
		}else {
			this.womenjrb.setSelected(true);
		}
		int count = this.cityidJrb.getItemCount();
		for(int i = 0;i < count;i++) {
			City selectcity = dao.queryCityById(customer.getCityid());
			if(selectcity.getCityname().equals(this.cityidJrb.getItemAt(i))) {
				this.cityidJrb.setSelectedIndex(i);
			}
		}
	}
	
	
	
	
	
	
	
	/**
	 * 初始化性别
	 */
	private String getGender(String gender) {
		String sex = "男";
		if("男".equals(gender)) {
			sex = "男";
		}else {
			sex = "女";
		}
		return sex;
	}
	
	
	/**
	 * 城市下拉列表
	 * @param arg0
//	 */
	private void getCitys(String type) {
		List<City> list = dao.queryCityToCustomer();
		for (City city : list) {
			if("search".equals(type)) {
				City c = new City();
				c.setCityname("--请选择--");
				//查询条件的下拉列表
			}else{
				//修改客户信息的下拉列表
				this.cityidJrb.addItem(city.getCityname());
			}
		}
	}
	private CustomerDao cdao = BeanFactory.getInstance(CommonUtils.CustomerInof.CUSTOMERDAO);
	
	protected void searchCustButton(ActionEvent arg0) {
		String custname = this.searchCustnameText.getText();
		Customer customer = new Customer();
		customer.setCustname(custname);
		this.getCustomers(customer);
		
	}

	/**
	 * 重置信息
	 * @param arg0
	 */
	
	protected void resetCustButton(ActionEvent arg0) {
		//清空查询条件
		this.searchCustnameText.setText("");
		//初始化查询列表
		this.getCustomers(null);
	}

	/**
	 * 调用dao的queryAllCustomer
	 */
	private void getCustomers(Customer customer) {
		List<Customer> list = cdao.queryAllCustomer(customer);
		DefaultTableModel model = (DefaultTableModel) this.table.getModel();
		model.setRowCount(0);
		if(list.size() > 0) {
			for (Customer c : list) {
				Vector<Object> vector = new Vector<Object>();
				City city = dao.queryCityById(c.getCityid());
				vector.add(c.getCustid());
				vector.add(c.getCustname());
				vector.add(c.getCustphone());
				vector.add(c.getCustgender());
				if (city!=null) {
					vector.add(city.getCityname());
				} else {
					vector.add("中国");
				}
				
				vector.add(c.getCuetemail());
				vector.add(c.getCuslevel());
				model.addRow(vector);
			}
		}else {
			JOptionPane.showMessageDialog(this, "对不起，没有查询到相关记录");
		}
	}
	private CityDao dao = BeanFactory.getInstance(CommonUtils.CityInfo.CITYDAO);
	private JTextField searchCustnameText;
	private JTextField custidText;
	private JTextField custnameText;
	private JTextField custphoneText;
	private JTextField cuetemailText;
	private JTextField cuslevelText;
	private final ButtonGroup buttonGroup = new ButtonGroup();
}
