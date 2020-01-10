package cn.edu.sdut.customer.user.swing;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Toolkit;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JTextField;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.stream.Collectors;
import java.awt.Cursor;
import javax.swing.border.MatteBorder;

import cn.edu.sdut.comm.prorperties.factory.BeanFactory;
import cn.edu.sdut.customer.comm.CommonUtils;
import cn.edu.sdut.customer.user.dao.UserDao;
import cn.edu.sdut.customer.user.entity.User;

import javax.swing.JPasswordField;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;

public class LoginFrame extends JFrame {

	private JPanel contentPane;
	private JTextField usernameText;
	private JPasswordField passwordText;
	private JTextField usernameplaceholder;
	private JTextField passwordplaceholder;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginFrame frame = new LoginFrame();
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
	public LoginFrame() {
		setUndecorated(true);
		setIconImage(Toolkit.getDefaultToolkit().getImage(LoginFrame.class.getResource("/images/customer.png")));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 898, 487);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(0, 0, 0, 0));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel closeButton = new JLabel("  ✕");
		closeButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		closeButton.setOpaque(false);
		closeButton.setBackground(new Color(255, 77, 77));
		closeButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				closeButton(arg0);
			}
			public void mouseEntered(MouseEvent e) {
				closeButton.setOpaque(true);
			}

			public void mouseExited(MouseEvent e) {
				closeButton.setOpaque(false);
			}
		});
		
		JLabel maintitle1 = new JLabel("易");
		maintitle1.setForeground(Color.WHITE);
		maintitle1.setFont(new Font("华文行楷", Font.BOLD, 88));
		maintitle1.setBounds(447, 10, 93, 104);
		contentPane.add(maintitle1);
		
		JLabel maintitle2 = new JLabel("管理");
		maintitle2.setForeground(Color.WHITE);
		maintitle2.setFont(new Font("方正舒体", Font.BOLD, 68));
		maintitle2.setBounds(521, 44, 214, 87);
		contentPane.add(maintitle2);
		closeButton.setFont(new Font("Dialog", 0, 16));
		closeButton.setForeground(Color.WHITE);
		closeButton.setBounds(868, 0, 30, 30);
		contentPane.add(closeButton);
		
		JLabel minsizeButton = new JLabel("—", JLabel.CENTER);
		minsizeButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		minsizeButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				minwindowButton(e);
			}
			public void mouseEntered(MouseEvent e) {
				minsizeButton.setOpaque(true);
			}

			public void mouseExited(MouseEvent e) {
				minsizeButton.setOpaque(false);
			}
		});
		minsizeButton.setOpaque(false);
		minsizeButton.setBackground(new Color(200, 200, 200));
		minsizeButton.setBounds(834, 0, 30, 30);
		minsizeButton.setFont(new Font("Dialog", 0, 16));
		minsizeButton.setForeground(Color.WHITE);
		contentPane.add(minsizeButton);
		
		JLabel titleLine = new JLabel("客户资料管理系统");
		titleLine.setFont(new Font("华文细黑", Font.PLAIN, 16));
		titleLine.setForeground(Color.WHITE);
		titleLine.setBounds(382, 151, 137, 31);
		contentPane.add(titleLine);
		
		usernameText = new JTextField();
		usernameText.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent arg0) {
				usernameTextFouse(arg0);
			}
			@Override
			public void focusLost(FocusEvent e) {
				usernameTextFouseLost(e);
			}
		});
		usernameText.setDisabledTextColor(new Color(30, 144, 255));
		usernameText.setForeground(Color.WHITE);
		usernameText.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 18));
		usernameText.setBounds(352, 192, 206, 31);
		usernameText.setOpaque(false);
		contentPane.add(usernameText);
		usernameText.setColumns(10);
		
		passwordText = new JPasswordField();
		passwordText.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent arg0) {
				passwordTextFouse(arg0);
			}
			@Override
			public void focusLost(FocusEvent e) {
				passwordTextFouseLost(e);
			}
		});
		passwordText.setDisabledTextColor(new Color(30, 144, 255));
		passwordText.setEchoChar('*');
		passwordText.setForeground(Color.WHITE);
		passwordText.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 18));
		passwordText.setBounds(352, 233, 206, 31);
		passwordText.setOpaque(false);
		contentPane.add(passwordText);
		
		JButton loginButton = new JButton("登   录");
		loginButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				loginButton(arg0);
			}
		});
		loginButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		loginButton.setBounds(352, 295, 206, 36);
		loginButton.setFont(new Font("微软雅黑", 0, 15));
	    loginButton.setForeground(Color.WHITE);
	    loginButton.setBackground(new Color(0, 153, 255));
	    loginButton.setBorder(null);
		contentPane.add(loginButton);
		
		JLabel usernameIcon = new JLabel("");
		usernameIcon.setIcon(new ImageIcon(LoginFrame.class.getResource("/images/user.png")));
		usernameIcon.setBounds(320, 192, 30, 30);
		contentPane.add(usernameIcon);
		
		JLabel passwordIcon = new JLabel("");
		passwordIcon.setIcon(new ImageIcon(LoginFrame.class.getResource("/images/password.png")));
		passwordIcon.setBounds(320, 234, 30, 30);
		contentPane.add(passwordIcon);
		
		JCheckBox autologinSelect = new JCheckBox("自动登录");
		autologinSelect.setFocusPainted(false);
		autologinSelect.setFont(new Font("微软雅黑", 0, 12));
		autologinSelect.setBounds(352, 270, 80, 20);
		autologinSelect.setForeground(new Color(200, 200, 200));
		autologinSelect.setBackground(Color.WHITE);
		autologinSelect.setOpaque(false);
		autologinSelect.setIcon(new ImageIcon(LoginFrame.class.getResource("/images/unchecked.png")));
		autologinSelect.setSelectedIcon(new ImageIcon(LoginFrame.class.getResource("/images/checked.png")));
		contentPane.add(autologinSelect);
		
		JCheckBox rempwdSelect = new JCheckBox("记住密码");
		rempwdSelect.setFocusPainted(false); 
		rempwdSelect.setFont(new Font("微软雅黑", 0, 12));
		rempwdSelect.setBounds(478, 270, 80, 20);
		rempwdSelect.setOpaque(false);
		rempwdSelect.setForeground(new Color(200, 200, 200));
		rempwdSelect.setBackground(Color.WHITE);
		rempwdSelect.setIcon(new ImageIcon(LoginFrame.class.getResource("/images/unchecked.png")));
		rempwdSelect.setSelectedIcon(new ImageIcon(LoginFrame.class.getResource("/images/checked.png")));
		contentPane.add(rempwdSelect);
		
		JLabel usernameBg = new JLabel("");
		usernameBg.setIcon(new ImageIcon(LoginFrame.class.getResource("/images/login-centerbg3.png")));
		usernameBg.setBounds(352, 192, 206, 31);
		contentPane.add(usernameBg);
		
		JLabel passwordBg = new JLabel("");
		passwordBg.setIcon(new ImageIcon(LoginFrame.class.getResource("/images/login-centerbg3.png")));
		passwordBg.setBounds(352, 233, 206, 31);
		contentPane.add(passwordBg);
		
		usernameplaceholder = new JTextField();
		usernameplaceholder.setEditable(false);
		usernameplaceholder.setForeground(Color.LIGHT_GRAY);
		usernameplaceholder.setBorder(null);
		usernameplaceholder.setOpaque(false);
		usernameplaceholder.setText("用户名");
		usernameplaceholder.setBounds(360, 200, 60, 22);
		contentPane.add(usernameplaceholder);
		usernameplaceholder.setColumns(10);
		
		passwordplaceholder = new JTextField();
		passwordplaceholder.setBorder(null);
		passwordplaceholder.setOpaque(false);
		passwordplaceholder.setForeground(Color.LIGHT_GRAY);
		passwordplaceholder.setEditable(false);
		passwordplaceholder.setText("密码");
		passwordplaceholder.setBounds(362, 241, 66, 21);
		contentPane.add(passwordplaceholder);
		passwordplaceholder.setColumns(10);
		
		JLabel loginCenterBg = new JLabel("");
		loginCenterBg.setIcon(new ImageIcon(LoginFrame.class.getResource("/images/login-centerbg2.png")));
		loginCenterBg.setBounds(300, 141, 323, 210);
		contentPane.add(loginCenterBg);
		
		JLabel background = new JLabel("");
		background.setBackground(Color.WHITE);
		background.setForeground(Color.WHITE);
		background.setBounds(-33, 0, 931, 487);
		background.setIcon(new ImageIcon(LoginFrame.class.getResource("/images/bg5.jpg")));
		contentPane.add(background);
		
		this.setLocationRelativeTo(null);
	}
	
	
	
	
	private UserDao dao = BeanFactory.getInstance(CommonUtils.UserInfo.USERDAO);
	/**
	 * 密码输入框聚焦事件
	 */
	protected void passwordTextFouse(FocusEvent arg0) {
		this.passwordplaceholder.setText("");
	}
	/**
	 * 密码输入框失焦事件
	 */
	protected void passwordTextFouseLost(FocusEvent e) {
		String pwd = new String(this.passwordText.getPassword());
		if (pwd.equals("")) {
			this.passwordplaceholder.setText("密码");
		}
	}
	/**
	 * 用户名输入框聚焦事件
	 */
	protected void usernameTextFouse(FocusEvent arg0) {
		this.usernameplaceholder.setText("");
	}
	
	/**
	 * 用户名输入框失焦事件
	 */
	protected void usernameTextFouseLost(FocusEvent e) {
		String uname = this.usernameText.getText();
		if (uname.equals("")) {
			this.usernameplaceholder.setText("用户名");
		}
	}

	/**
	 * 登录事件
	 */
	protected void loginButton(ActionEvent arg0) {
		String uname = this.usernameText.getText();
		String pwd = new String(this.passwordText.getPassword());
		if (uname.equals("")) {
			JOptionPane.showConfirmDialog(this, "请输入用户名");
			this.usernameText.requestFocus();
			return ;
		}
		if (pwd.equals("")) {
			JOptionPane.showConfirmDialog(this, "请输入密码");
			this.passwordText.requestFocus();
			return ;
		}
		if (uname.length() < 4 || uname.length() > 8) {
			JOptionPane.showConfirmDialog(this, "用户名长度限制为4-8位");
			this.usernameText.requestFocus();
			return ;
		}
		if (pwd.length() < 4 || pwd.length() > 8) {
			JOptionPane.showConfirmDialog(this, "密码长度限制为4-8位");
			this.passwordText.requestFocus();
			return ;
		}
		// 和MySQL数据库进行交互，查询tcbd1011 tbuser 表
		User user = new User();
		// 把用户名、密码封装在user对象中
		user.setUsername(uname);
		user.setUserpassword(pwd);
		// 把user对象传给login方法
		User u = dao.login(user);
		// 对u对象进行判断
		if(u!=null) {
			this.dispose();
			if (u.getUserlevel() == 1) {
				new MainFrame(u).setVisible(true);
			}else if (u.getUserlevel() == 2) {
				new MainFrame2(u).setVisible(true);
			}
		} else {
			JOptionPane.showMessageDialog(this, "用户名或密码错误");
			this.usernameText.setText("");
			this.passwordText.setText("");
			this.usernameText.requestFocus();
		}
	}

	/**
	 * 最小化窗口按钮
	 */
	protected void minwindowButton(MouseEvent e) {
		this.setExtendedState(JFrame.ICONIFIED);
	}

	/**
	 * 关闭窗口按钮
	 */
	protected void closeButton(MouseEvent arg0) {
		System.exit(0);
	}
}
