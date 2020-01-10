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
import java.awt.Toolkit;
import java.awt.Window;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class UpdatePwdFrame extends JFrame {

	private JPanel contentPane;
	private JPasswordField passwordField;
	private JPasswordField passwordField_1;
	private JPasswordField passwordField_2;

	/**
	 * Create the frame.
	 */
	public UpdatePwdFrame(User user) {
		setIconImage(Toolkit.getDefaultToolkit().getImage(UpdatePwdFrame.class.getResource("/images/customer.png")));
		setTitle("修改密码");
		setBounds(100, 100, 600, 414);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel label_2 = new JLabel("修改密码");
		label_2.setFont(new Font("等线 Light", Font.PLAIN, 16));
		label_2.setForeground(Color.WHITE);
		label_2.setBounds(272, 97, 64, 26);
		contentPane.add(label_2);
		label_2.setLabelFor(passwordField);
		
		JLabel label_3 = new JLabel("原密码");
		label_3.setIcon(new ImageIcon(UpdatePwdFrame.class.getResource("/images/password.png")));
		label_3.setFont(new Font("微软雅黑", Font.PLAIN, 14));
		label_3.setForeground(Color.WHITE);
		label_3.setBounds(156, 143, 78, 26);
		contentPane.add(label_3);
		label_3.setLabelFor(passwordField_1);
		
		JLabel label_4 = new JLabel("新密码");
		label_4.setIcon(new ImageIcon(UpdatePwdFrame.class.getResource("/images/password.png")));
		label_4.setForeground(Color.WHITE);
		label_4.setFont(new Font("微软雅黑", Font.PLAIN, 14));
		label_4.setBounds(156, 179, 78, 26);
		contentPane.add(label_4);
		label_4.setLabelFor(passwordField_2);
		
		JLabel label_5 = new JLabel("再次输入");
		label_5.setIcon(new ImageIcon(UpdatePwdFrame.class.getResource("/images/password.png")));
		label_5.setForeground(Color.WHITE);
		label_5.setFont(new Font("微软雅黑", Font.PLAIN, 14));
		label_5.setBounds(156, 215, 93, 26);
		contentPane.add(label_5);
		
		passwordField = new JPasswordField();
		passwordField.setFont(new Font("宋体", Font.PLAIN, 16));
		passwordField.setForeground(Color.WHITE);
		passwordField.setOpaque(false);
		passwordField.setBounds(244, 143, 188, 26);
		contentPane.add(passwordField);
		
		passwordField_1 = new JPasswordField();
		passwordField_1.setFont(new Font("宋体", Font.PLAIN, 16));
		passwordField_1.setForeground(Color.WHITE);
		passwordField_1.setOpaque(false);
		passwordField_1.setBounds(244, 179, 188, 26);
		contentPane.add(passwordField_1);
		
		passwordField_2 = new JPasswordField();
		passwordField_2.setFont(new Font("宋体", Font.PLAIN, 16));
		passwordField_2.setForeground(Color.WHITE);
		passwordField_2.setOpaque(false);
		passwordField_2.setBounds(244, 215, 188, 26);
		contentPane.add(passwordField_2);
		
		JLabel lblNewLabel_3 = new JLabel("");
		lblNewLabel_3.setIcon(new ImageIcon(UpdatePwdFrame.class.getResource("/images/login-centerbg3.png")));
		lblNewLabel_3.setBounds(241, 144, 191, 26);
		contentPane.add(lblNewLabel_3);
		
		JLabel label_6 = new JLabel("");
		label_6.setIcon(new ImageIcon(UpdatePwdFrame.class.getResource("/images/login-centerbg3.png")));
		label_6.setBounds(241, 143, 191, 26);
		contentPane.add(label_6);
		
		JLabel label_7 = new JLabel("");
		label_7.setIcon(new ImageIcon(UpdatePwdFrame.class.getResource("/images/login-centerbg3.png")));
		label_7.setBounds(241, 179, 191, 26);
		contentPane.add(label_7);
		
		JLabel label_8 = new JLabel("");
		label_8.setIcon(new ImageIcon(UpdatePwdFrame.class.getResource("/images/login-centerbg3.png")));
		label_8.setBounds(241, 179, 191, 26);
		contentPane.add(label_8);
		
		JLabel label_9 = new JLabel("");
		label_9.setIcon(new ImageIcon(UpdatePwdFrame.class.getResource("/images/login-centerbg3.png")));
		label_9.setBounds(241, 215, 191, 26);
		contentPane.add(label_9);
		
		JLabel label_10 = new JLabel("");
		label_10.setIcon(new ImageIcon(UpdatePwdFrame.class.getResource("/images/login-centerbg3.png")));
		label_10.setBounds(241, 215, 191, 26);
		contentPane.add(label_10);
		
		JButton button = new JButton("确认");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				updatePwdButton(e, user);
			}
		});
		button.setOpaque(false);
		button.setForeground(Color.BLUE);
		button.setBounds(339, 251, 93, 23);
		contentPane.add(button);
		
		JLabel label_1 = new JLabel("管理");
		label_1.setFont(new Font("华文行楷", Font.PLAIN, 34));
		label_1.setForeground(Color.WHITE);
		label_1.setBounds(440, 47, 68, 38);
		contentPane.add(label_1);
		
		JLabel label = new JLabel("易");
		label.setFont(new Font("方正舒体", Font.BOLD, 40));
		label.setForeground(Color.WHITE);
		label.setBounds(403, 25, 78, 49);
		contentPane.add(label);
		
		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setIcon(new ImageIcon(UpdatePwdFrame.class.getResource("/images/login-centerbg2.png")));
		lblNewLabel_2.setBounds(156, 84, 300, 219);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon(UpdatePwdFrame.class.getResource("/images/login-centerbg2.png")));
		lblNewLabel_1.setBounds(156, 84, 300, 219);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(UpdatePwdFrame.class.getResource("/images/bg4.jpg")));
		lblNewLabel.setBounds(0, 0, 594, 386);
		contentPane.add(lblNewLabel);
		this.setLocationRelativeTo(null);
		this.setResizable(false);
	}
	
	private UserDao dao = BeanFactory.getInstance(CommonUtils.UserInfo.USERDAO);
	private int disposeOnClose;

	/**
	 * 修改密码事件
	 * @param e
	 */
	protected void updatePwdButton(ActionEvent e, User user) {
		String pwdold = new String(this.passwordField.getPassword());
		String pwdnew1 = new String(this.passwordField_1.getPassword());
		String pwdnew2 = new String(this.passwordField_2.getPassword());
		if (pwdold.equals("")) {
			JOptionPane.showConfirmDialog(this, "请输入旧密码");
			this.passwordField.requestFocus();
			return ;
		}
		if (pwdnew1.equals("")) {
			JOptionPane.showConfirmDialog(this, "请输入新密码");
			this.passwordField_1.requestFocus();
			return ;
		}
		if (pwdnew2.equals("")) {
			JOptionPane.showConfirmDialog(this, "请再次输入新密码");
			this.passwordField_2.requestFocus();
			return ;
		}
		if (!pwdnew1.equals(pwdnew2)) {
			JOptionPane.showMessageDialog(this, "两次输入新密码不匹配");
			this.passwordField_2.setText("");
			this.passwordField_2.requestFocus();
			return ;
		}
		if (pwdold.length() < 4 || pwdold.length() > 16) {
			JOptionPane.showConfirmDialog(this, "旧密码长度限制为4-16位");
			this.passwordField.requestFocus();
			return ;
		}
		if (pwdnew1.length() < 4 || pwdold.length() > 16) {
			JOptionPane.showConfirmDialog(this, "新密码长度限制为4-16位");
			this.passwordField_1.requestFocus();
			return ;
		}
		if (pwdnew2.length() < 4 || pwdold.length() > 16) {
			JOptionPane.showConfirmDialog(this, "新密码长度限制为4-16位");
			this.passwordField_2.requestFocus();
			return ;
		}
		if (!pwdold.equals(user.getUserpassword())) {
			JOptionPane.showConfirmDialog(this, "原密码不正确，请重新输入");
			this.passwordField.requestFocus();
			return ;
		}
		user.setUserpassword(pwdnew1);
		int row = dao.updatePassowrd(user);
		if (row != 0) {
			JOptionPane.showMessageDialog(this, "修改成功,请重新登录");
			this.dispose();
			System.exit(0);
			new LoginFrame().setVisible(true);
		} else {
			JOptionPane.showMessageDialog(this, "修改失败");
		}
	}
}
