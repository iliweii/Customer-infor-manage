package cn.edu.sdut.customer.user.swing;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import cn.edu.sdut.comm.prorperties.factory.BeanFactory;
import cn.edu.sdut.customer.comm.CommonUtils;
import cn.edu.sdut.customer.user.dao.UserDao;
import cn.edu.sdut.customer.user.entity.User;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import java.awt.Toolkit;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import java.awt.Color;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AddUserFrame extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField txtCmrs;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddUserFrame frame = new AddUserFrame();
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
	public AddUserFrame() {
		setTitle("新增普通管理员");
		setIconImage(Toolkit.getDefaultToolkit().getImage(AddUserFrame.class.getResource("/images/customer.png")));
		setBounds(100, 100, 776, 458);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel label = new JLabel("管理员登录名：");
		label.setForeground(Color.WHITE);
		label.setIcon(new ImageIcon(AddUserFrame.class.getResource("/images/user.png")));
		label.setBounds(99, 114, 125, 32);
		contentPane.add(label);
		
		textField = new JTextField();
		textField.setBounds(230, 114, 173, 32);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel label_1 = new JLabel("默认密码 ：");
		label_1.setForeground(Color.WHITE);
		label_1.setIcon(new ImageIcon(AddUserFrame.class.getResource("/images/password.png")));
		label_1.setBounds(99, 173, 125, 32);
		contentPane.add(label_1);
		
		txtCmrs = new JTextField();
		txtCmrs.setFont(new Font("宋体", Font.PLAIN, 14));
		txtCmrs.setText("cmrs123");
		txtCmrs.setEditable(false);
		txtCmrs.setBounds(230, 173, 173, 32);
		contentPane.add(txtCmrs);
		txtCmrs.setColumns(10);
		
		JLabel label_2 = new JLabel("新增管理员");
		label_2.setFont(new Font("华文细黑", Font.PLAIN, 28));
		label_2.setForeground(Color.WHITE);
		label_2.setBounds(102, 44, 301, 32);
		contentPane.add(label_2);
		
		JButton btnNewButton_1 = new JButton("添加");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				addUserButton(e);
			}
		});
		btnNewButton_1.setForeground(Color.DARK_GRAY);
		btnNewButton_1.setIcon(new ImageIcon(AddUserFrame.class.getResource("/images/add.png")));
		btnNewButton_1.setOpaque(false);
		btnNewButton_1.setBounds(159, 275, 119, 41);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton = new JButton("清空");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				resetButton(e);
			}
		});
		btnNewButton.setForeground(Color.DARK_GRAY);
		btnNewButton.setIcon(new ImageIcon(AddUserFrame.class.getResource("/images/reset.png")));
		btnNewButton.setOpaque(false);
		btnNewButton.setBounds(288, 275, 119, 41);
		contentPane.add(btnNewButton);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(AddUserFrame.class.getResource("/images/bg8.jpg")));
		lblNewLabel.setBounds(0, 0, 760, 420);
		contentPane.add(lblNewLabel);
	}

	private UserDao dao = BeanFactory.getInstance(CommonUtils.UserInfo.USERDAO);
	/**
	 * 添加用户按钮
	 * @param e
	 */
	protected void addUserButton(ActionEvent e) {
		String username = this.textField.getText();
		String password = new String("crms123");
		
		if(username.length() < 4 || username.length() > 16) {
			JOptionPane.showMessageDialog(this, "登录名长度限制为4-16位!");
			this.textField.requestFocus();
			return;
		}
		
		User user = new User();
		user.setUsername(username);
		user.setUserpassword(password);
		user.setUserlevel(2);
		
		User u = dao.userQueryByUsername(user);
		if (u!=null) {
			JOptionPane.showMessageDialog(this, "对不起，该登录名已经存在!");
			this.textField.setText("");
			this.textField.requestFocus();
			return;
		}
		
		int row = dao.addUser(user);
		if (row > 0) {
			JOptionPane.showMessageDialog(this, "添加管理员"+username+"成功！");
		} else {
			JOptionPane.showMessageDialog(this, "添加管理员登录名失败");
		}
	}

	/**
	 * 重置按钮点击事件
	 */
	protected void resetButton(ActionEvent e) {
		this.textField.setText("");
		this.textField.requestFocus();
	}

}
