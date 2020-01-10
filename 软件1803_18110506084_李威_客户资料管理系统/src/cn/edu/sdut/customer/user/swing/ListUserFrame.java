package cn.edu.sdut.customer.user.swing;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Toolkit;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;

import cn.edu.sdut.comm.prorperties.factory.BeanFactory;
import cn.edu.sdut.customer.comm.CommonUtils;
import cn.edu.sdut.customer.user.dao.UserDao;
import cn.edu.sdut.customer.user.entity.User;
import cn.edu.sdut.customer.user.entity.UserRoles;

import javax.swing.border.TitledBorder;
import javax.swing.border.MatteBorder;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.util.List;
import java.util.Vector;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;

public class ListUserFrame extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private JTextField usernameText;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JComboBox comboBox;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ListUserFrame frame = new ListUserFrame();
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
	public ListUserFrame() {
		setTitle("管理管理员页面-用户列表查询、修改和删除");
		setIconImage(Toolkit.getDefaultToolkit().getImage(ListUserFrame.class.getResource("/images/customer.png")));
		setBounds(100, 100, 1095, 640);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel label_2 = new JLabel("管理员查询");
		label_2.setFont(new Font("华文细黑", Font.PLAIN, 28));
		label_2.setForeground(Color.WHITE);
		label_2.setBounds(102, 44, 301, 32);
		contentPane.add(label_2);
		
		JLabel label = new JLabel("管理员登录名：");
		label.setForeground(Color.WHITE);
		label.setIcon(new ImageIcon(AddUserFrame.class.getResource("/images/user.png")));
		label.setBounds(99, 114, 125, 32);
		contentPane.add(label);
		
		usernameText = new JTextField();
		usernameText.setBounds(230, 114, 148, 32);
		contentPane.add(usernameText);
		usernameText.setColumns(10);
		
		JLabel label_3 = new JLabel("管理员等级：");
		label_3.setIcon(new ImageIcon(ListUserFrame.class.getResource("/images/user.png")));
		label_3.setForeground(Color.WHITE);
		label_3.setBounds(420, 114, 125, 32);
		contentPane.add(label_3);
		
		comboBox = new JComboBox();
		comboBox.setOpaque(false);
		comboBox.setBounds(544, 114, 125, 32);
		contentPane.add(comboBox);
		
		JButton btnNewButton_2 = new JButton("查询");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				defailUser(e);
			}
		});
		btnNewButton_2.setOpaque(false);
		btnNewButton_2.setForeground(Color.DARK_GRAY);
		btnNewButton_2.setIcon(new ImageIcon(ListUserFrame.class.getResource("/images/search.png")));
		btnNewButton_2.setBounds(722, 114, 108, 32);
		contentPane.add(btnNewButton_2);
		
		JButton button = new JButton("清空");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				resetButton(e);
			}
		});
		button.setIcon(new ImageIcon(ListUserFrame.class.getResource("/images/reset.png")));
		button.setOpaque(false);
		button.setForeground(Color.DARK_GRAY);
		button.setBounds(862, 114, 108, 32);
		contentPane.add(button);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setOpaque(false);
		scrollPane.setBounds(99, 168, 868, 220);
		contentPane.add(scrollPane);
		
		table = new JTable();
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				detailUser(e);
			}
		});
		table.setBackground(Color.LIGHT_GRAY);
		table.setFont(new Font("幼圆", Font.PLAIN, 14));
		table.setOpaque(false);
		table.setForeground(Color.BLACK);
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"\u7BA1\u7406\u5458\u7F16\u53F7", "\u7BA1\u7406\u5458\u767B\u5F55\u540D", "\u7BA1\u7406\u5458\u7EA7\u522B"
			}
		));
		scrollPane.setViewportView(table);
		
		JPanel panel = new JPanel();
		panel.setOpaque(false);
		panel.setBorder(new TitledBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(255, 255, 255)), "\u7BA1\u7406\u5458\u4FE1\u606F", TitledBorder.LEADING, TitledBorder.TOP, null, Color.WHITE));
		panel.setBounds(99, 415, 868, 137);
		contentPane.add(panel);
		
		JLabel label_1 = new JLabel("管理员登录名：");
		label_1.setForeground(Color.WHITE);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		
		JLabel label_4 = new JLabel("重置管理员登录密码：");
		label_4.setForeground(Color.WHITE);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		
		JLabel label_5 = new JLabel("管理员等级：");
		label_5.setForeground(Color.WHITE);
		
		textField_3 = new JTextField();
		textField_3.setEditable(false);
		textField_3.setEnabled(false);
		textField_3.setColumns(10);
		
		JButton button_1 = new JButton("修改管理员信息");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				changeUserButton(arg0);
			}
		});
		button_1.setOpaque(false);
		button_1.setForeground(new Color(0, 0, 139));
		
		JButton button_2 = new JButton("删除管理员信息");
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				deleteUserButton(e);
			}
		});
		button_2.setOpaque(false);
		button_2.setForeground(new Color(128, 0, 0));
		
		textField = new JTextField();
		textField.setEnabled(false);
		textField.setEditable(false);
		textField.setColumns(10);
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(51)
					.addComponent(label_1)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addComponent(textField_1, GroupLayout.PREFERRED_SIZE, 148, GroupLayout.PREFERRED_SIZE)
						.addComponent(textField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(38)
					.addGroup(gl_panel.createParallelGroup(Alignment.TRAILING)
						.addGroup(gl_panel.createSequentialGroup()
							.addComponent(label_4)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(textField_2, GroupLayout.PREFERRED_SIZE, 139, GroupLayout.PREFERRED_SIZE)
							.addGap(58))
						.addGroup(gl_panel.createSequentialGroup()
							.addComponent(button_1)
							.addGap(55)))
					.addGap(0, 0, Short.MAX_VALUE)
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel.createSequentialGroup()
							.addComponent(label_5)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(textField_3, GroupLayout.PREFERRED_SIZE, 102, GroupLayout.PREFERRED_SIZE))
						.addComponent(button_2, GroupLayout.PREFERRED_SIZE, 137, GroupLayout.PREFERRED_SIZE))
					.addGap(34))
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(textField_1, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE)
						.addComponent(label_1, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE)
						.addComponent(label_4)
						.addComponent(textField_2, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
						.addComponent(label_5)
						.addComponent(textField_3, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE))
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel.createSequentialGroup()
							.addPreferredGap(ComponentPlacement.RELATED, 25, Short.MAX_VALUE)
							.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
								.addComponent(button_1, GroupLayout.PREFERRED_SIZE, 37, GroupLayout.PREFERRED_SIZE)
								.addComponent(button_2, GroupLayout.PREFERRED_SIZE, 34, GroupLayout.PREFERRED_SIZE))
							.addContainerGap())
						.addGroup(gl_panel.createSequentialGroup()
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(textField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addContainerGap())))
		);
		panel.setLayout(gl_panel);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(AddUserFrame.class.getResource("/images/bg8.jpg")));
		lblNewLabel.setBounds(0, 0, 1079, 602);
		contentPane.add(lblNewLabel);
		this.queryAllUser(null);
		//初始化查询条件的管理员身份下拉列表
		this.addUserroles("search");
	}

	/**
	 * 删除管理员
	 */
	protected void deleteUserButton(ActionEvent e) {
		String level = this.textField_3.getText();
		if (level.equals("高级管理员")) {
			JOptionPane.showMessageDialog(this, "对不起，不能删除高级管理员的信息");
			return;
		}
		String username = this.textField_1.getText();
		if (this.textField.getText().isEmpty()) {
			JOptionPane.showMessageDialog(this, "未选中任何信息。");
			return;
		}
		int userid = Integer.parseInt(this.textField.getText());
		User ou = dao.detailUser(userid);
		int showConfirmDialog = JOptionPane.showConfirmDialog(this,  "确认要删除"+ou.getUsername()+"吗？");
		if(showConfirmDialog==0) {
			int row = dao.deleteUserById(userid);
			if (row > 0) {
				JOptionPane.showMessageDialog(this, "删除"+ou.getUsername()+"成功");
			} else {
				JOptionPane.showMessageDialog(this, "删除失败");
			}
		}
		queryAllUser(null);
	}

	/**
	 * 修改用户信息按钮
	 * @param arg0
	 */
	protected void changeUserButton(ActionEvent arg0) {
		String level = this.textField_3.getText();
		if (level.equals("高级管理员")) {
			JOptionPane.showMessageDialog(this, "对不起，不能修改高级管理员的信息");
			return;
		}
		if (this.textField.getText().isEmpty()) {
			JOptionPane.showMessageDialog(this, "未选中任何信息。");
			return;
		}
		String username = this.textField_1.getText();
		if (username.length()<4 || username.length()>16) {
			JOptionPane.showMessageDialog(this, "新登录名长度在4-16位之间");
			this.textField_1.requestFocus();
			return;
		}
		String password = this.textField_2.getText();
		if (!password.equals("") && password.length()<4 || password.length()>16) {
			JOptionPane.showMessageDialog(this, "新密码名长度在4-16位之间");
			this.textField_2.requestFocus();
			return;
		}
		int userid = Integer.parseInt(this.textField.getText());
		User user = new User();
		user.setUserid(userid);
		user.setUsername(username);
		user.setUserpassword(password);
		user.setUserlevel(2);
		User u = dao.userQueryByUsername(user);
		User ou = dao.detailUser(userid);
		if (u!=null && !u.getUsername().equals(ou.getUsername())) {
			JOptionPane.showMessageDialog(this, "登录名重复，请更换");
			this.textField_1.requestFocus();
			return;
		}
		if (!username.isEmpty() && !username.equals(ou.getUsername())) {
			int row = dao.updateUsername(user);
			if (row > 0) {
				JOptionPane.showMessageDialog(this, "登录名修改成功");
				this.textField_1.setText("");
			} else {
				JOptionPane.showMessageDialog(this, "登录名修改失败");
			}
		}
		if (!password.isEmpty()) {
			int row = dao.updatePassowrd(user);
			if (row > 0) {
				JOptionPane.showMessageDialog(this, "修改该用户登录密码成功");
				this.textField_2.setText("");
			} else {
				JOptionPane.showMessageDialog(this, "密码修改失败");
			}
		}
		queryAllUser(null);
	}

	/**
	 * 根据主键查询用户信息
	 * @param e
	 */
	protected void detailUser(MouseEvent e) {
		int row = this.table.getSelectedRow();
		int userid = (Integer)table.getValueAt(row, 0);
		User user = dao.detailUser(userid);
		this.textField_1.setText(user.getUsername());
		int level = user.getUserlevel();
		if (level == 1) {
			this.textField_3.setText("高级管理员");
		}else if (level == 2) {
			this.textField_3.setText("普通管理员");
		}
		this.textField.setText(String.valueOf(userid));
	}

	/**
	 * 重置按钮点击事件
	 * @param e
	 */
	protected void resetButton(ActionEvent e) {
		this.usernameText.setText("");
		addUserroles(null);
		queryAllUser(null);
		this.usernameText.requestFocus();
	}

	private UserDao dao = BeanFactory.getInstance(CommonUtils.UserInfo.USERDAO);
	private JTextField textField;

	protected void defailUser(ActionEvent e) {
		User user = new User();
		String username = this.usernameText.getText();
		user.setUsername(username);
		int userlevel = comboBox.getSelectedIndex();
		user.setUserlevel(userlevel);
		queryAllUser(user);
	}

	/**
	 * 查询所有数据
	 * @param user
	 */
	private void queryAllUser(User user) {
		DefaultTableModel model = (DefaultTableModel) this.table.getModel();
		model.setRowCount(0);
		List<User> list = dao.userQueryAll(user);
		if(list.size()>0) {
			for (User u : list) {
//				u.setUserlevel(this.comboBox(u.getUserlevel()));
				Vector<Object> vector = new Vector<>();
				vector.add(u.getUserid());
				vector.add(u.getUsername());
				//if ( u.getUserlevel()!=null && u.getUserlevel()==1) {
					vector.add("高级管理员");
				//} else if ( u.getUserlevel()!=null && u.getUserlevel()==2) {
					vector.add("普通管理员");
				//}
				
				model.addRow(vector);
			}
		}else {
			JOptionPane.showMessageDialog(this, "对不起，没有查询到相关记录");
		}
	}
	
	/**
	 * 初始化用户角色下拉列表信息
	 */
	private void addUserroles(String type) {
		UserRoles roles0 = new UserRoles();
		roles0.setUserrolesid("0");
		roles0.setUserrolesName("--请选择--");
		this.comboBox.addItem(roles0);
		UserRoles roles1 = new UserRoles();
		roles1.setUserrolesid("1");
		roles1.setUserrolesName("高级管理员");
		this.comboBox.addItem(roles1);
		UserRoles roles2 = new UserRoles();
		roles2.setUserrolesid("2");
		roles2.setUserrolesName("普通管理员");
		this.comboBox.addItem(roles2);
		
	}
}
