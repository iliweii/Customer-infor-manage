package cn.edu.sdut.customer.user.swing;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import cn.edu.sdut.customer.city.swing.AddCityFrame;
import cn.edu.sdut.customer.city.swing.ListCityFrame;
import cn.edu.sdut.customer.customer.swing.AddCustomerFrame;
import cn.edu.sdut.customer.customer.swing.ListCustomerFrame;
import cn.edu.sdut.customer.user.entity.User;

import javax.swing.JLabel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.Toolkit;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.stream.Collectors;

import javax.swing.ImageIcon;
import java.awt.Color;
import java.awt.Component;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Frame;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.FlowLayout;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JMenu;
import java.awt.SystemColor;
import javax.swing.border.MatteBorder;

class Weather{
	public String location, codc, cond, tmp;
	public Weather(String location, String codc, String cond, String tmp) {
		this.location = location;
		this.codc = codc;
		this.cond = cond;
		this.tmp = tmp;
	}
}

public class MainFrame extends JFrame {

	private JPanel contentPane;

	/**
	 * Create the frame.
	 */
	public MainFrame(User user) {
		
		setIconImage(Toolkit.getDefaultToolkit().getImage(MainFrame.class.getResource("/images/customer.png")));
		setTitle("客户资料管理系统");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1960, 1100);
		//主窗体默认最大化
		this.setExtendedState(JFrame.MAXIMIZED_BOTH);
		
		contentPane = new JPanel();
		contentPane.setBackground(Color.BLACK);
		contentPane.setAlignmentY(Component.TOP_ALIGNMENT);
		contentPane.setAlignmentX(Component.LEFT_ALIGNMENT);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				String str = "cmd /c start chrome http://honghong520.xyz/aboutwe.html";
		        try {
		            Runtime.getRuntime().exec(str);
		        } catch (IOException e) {
		            e.printStackTrace();
		        }
			}
		});
		panel.setOpaque(false);
		panel.setBounds(0, 0, 2100, 1016);
		contentPane.add(panel);
		
		JPanel topPanel = new JPanel();
		topPanel.setAlignmentY(Component.TOP_ALIGNMENT);
		topPanel.setAlignmentX(Component.LEFT_ALIGNMENT);
		topPanel.setOpaque(false);
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addComponent(topPanel, GroupLayout.PREFERRED_SIZE, 1920, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(179, Short.MAX_VALUE))
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addComponent(topPanel, GroupLayout.PREFERRED_SIZE, 118, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(69, Short.MAX_VALUE))
		);
		mainFrameComponentResized(null, topPanel, gl_panel);
		addComponentListener(new ComponentAdapter() {
			@Override
			public void componentResized(ComponentEvent arg0) {
				mainFrameComponentResized(arg0, topPanel, gl_panel);
			}
		});
		
		JPanel panel_1 = new JPanel();
		panel_1.setOpaque(false);
		GroupLayout gl_panel1 = new GroupLayout(panel);
		gl_panel1.setHorizontalGroup(
			gl_panel1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel1.createSequentialGroup()
					.addGroup(gl_panel1.createParallelGroup(Alignment.LEADING)
						.addComponent(topPanel, GroupLayout.PREFERRED_SIZE, 1921, GroupLayout.PREFERRED_SIZE)
						.addComponent(panel_1, GroupLayout.PREFERRED_SIZE, 1110, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(179, Short.MAX_VALUE))
		);
		gl_panel1.setVerticalGroup(
			gl_panel1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel1.createSequentialGroup()
					.addComponent(topPanel, GroupLayout.PREFERRED_SIZE, 118, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(panel_1, GroupLayout.PREFERRED_SIZE, 665, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(226, Short.MAX_VALUE))
		);
		JLabel label_1 = new JLabel("欢迎·");
		label_1.setFont(new Font("华文细黑", Font.PLAIN, 24));
		label_1.setForeground(new Color(30, 144, 255));
		
		JLabel lblNewLabel_2 = new JLabel("使用易管理客户资料管理系统");
		lblNewLabel_2.setFont(new Font("华文楷体", Font.PLAIN, 16));
		lblNewLabel_2.setForeground(Color.WHITE);
		
		JLabel label_2 = new JLabel("用户管理");
		label_2.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		label_2.setBackground(Color.LIGHT_GRAY);
		label_2.setFont(new Font("华文行楷", Font.PLAIN, 32));
		label_2.setForeground(Color.WHITE);
		label_2.setIcon(new ImageIcon(MainFrame.class.getResource("/images/mangeuser.png")));
		
		JLabel lblNewLabel_3 = new JLabel("城市管理");
		lblNewLabel_3.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lblNewLabel_3.setForeground(Color.WHITE);
		lblNewLabel_3.setBackground(Color.LIGHT_GRAY);
		lblNewLabel_3.setFont(new Font("华文行楷", Font.PLAIN, 30));
		lblNewLabel_3.setIcon(new ImageIcon(MainFrame.class.getResource("/images/mangecity.png")));
		
		JLabel label_3 = new JLabel("客户管理");
		label_3.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		label_3.setFont(new Font("华文行楷", Font.PLAIN, 30));
		label_3.setForeground(Color.WHITE);
		label_3.setIcon(new ImageIcon(MainFrame.class.getResource("/images/mangecom.png")));
		
		JLabel username = new JLabel(user.getUsername());
		username.setFont(new Font("宋体", Font.PLAIN, 16));
		username.setForeground(Color.WHITE);
		
		JLabel userlevel =new JLabel("高级管理员");
		userlevel.setForeground(Color.RED);
		
		JButton button = new JButton("修改密码");
		button.setOpaque(false);
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				updatePasswordButton(arg0, user);
			}
		});
		button.setBackground(Color.LIGHT_GRAY);
		button.setForeground(new Color(128, 0, 0));
		button.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		
		JButton button_1 = new JButton("退出系统");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				exitButton(e);
			}
		});
		button_1.setForeground(new Color(0, 128, 0));
		button_1.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		button_1.setOpaque(false);
		
		JLabel label = new JLabel("》》");
		label.setForeground(Color.BLUE);
		label.setFont(new Font("华文行楷", Font.PLAIN, 30));
		
		JLabel label_4 = new JLabel("》》");
		label_4.setForeground(Color.MAGENTA);
		label_4.setFont(new Font("华文行楷", Font.PLAIN, 30));
		
		JLabel label_5 = new JLabel("》》");
		label_5.setForeground(Color.RED);
		label_5.setFont(new Font("华文行楷", Font.PLAIN, 30));
		
		JLabel lblNewLabel_1 = new JLabel("新增客户");
		lblNewLabel_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				addCustomerButton(e);
			}
		});
		lblNewLabel_1.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lblNewLabel_1.setBorder(new MatteBorder(1, 1, 1, 1, (Color) Color.BLUE));
		lblNewLabel_1.setFont(new Font("方正舒体", Font.BOLD, 24));
		lblNewLabel_1.setIcon(new ImageIcon(MainFrame.class.getResource("/images/add.png")));
		lblNewLabel_1.setForeground(Color.WHITE);
		
		JLabel lblNewLabel_4 = new JLabel("客户列表");
		lblNewLabel_4.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				listCustomerButton(e);
			}
		});
		lblNewLabel_4.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lblNewLabel_4.setFont(new Font("方正舒体", Font.PLAIN, 24));
		lblNewLabel_4.setForeground(Color.WHITE);
		lblNewLabel_4.setIcon(new ImageIcon(MainFrame.class.getResource("/images/list.png")));
		lblNewLabel_4.setBorder(new MatteBorder(1, 1, 1, 1, (Color) Color.DARK_GRAY));
		
		JLabel label_6 = new JLabel("新增城市");
		label_6.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				addCityButton(e);
			}
		});
		label_6.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		label_6.setBorder(new MatteBorder(1, 1, 1, 1, (Color) Color.MAGENTA));
		label_6.setFont(new Font("方正舒体", Font.PLAIN, 24));
		label_6.setForeground(Color.WHITE);
		label_6.setIcon(new ImageIcon(MainFrame.class.getResource("/images/add.png")));
		
		JLabel lblNewLabel_6 = new JLabel("城市列表");
		lblNewLabel_6.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				listCityButton(e);
			}
		});
		lblNewLabel_6.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lblNewLabel_6.setBorder(new MatteBorder(1, 1, 1, 1, (Color) Color.WHITE));
		lblNewLabel_6.setFont(new Font("方正舒体", Font.PLAIN, 24));
		lblNewLabel_6.setForeground(Color.WHITE);
		lblNewLabel_6.setIcon(new ImageIcon(MainFrame.class.getResource("/images/city.png")));
		
		JLabel lblNewLabel_7 = new JLabel("新增用户");
		lblNewLabel_7.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				addUserButton(e);
			}
		});
		lblNewLabel_7.setBorder(new MatteBorder(1, 1, 1, 1, (Color) Color.ORANGE));
		lblNewLabel_7.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lblNewLabel_7.setFont(new Font("方正舒体", Font.PLAIN, 24));
		lblNewLabel_7.setForeground(Color.WHITE);
		lblNewLabel_7.setIcon(new ImageIcon(MainFrame.class.getResource("/images/add.png")));
		
		JLabel lblNewLabel_8 = new JLabel("用户列表");
		lblNewLabel_8.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				listUserButton(e);
			}
		});
		lblNewLabel_8.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lblNewLabel_8.setBorder(new MatteBorder(1, 1, 1, 1, (Color) Color.PINK));
		lblNewLabel_8.setIcon(new ImageIcon(MainFrame.class.getResource("/images/list.png")));
		lblNewLabel_8.setFont(new Font("方正舒体", Font.PLAIN, 24));
		lblNewLabel_8.setForeground(Color.WHITE);
		
		JLabel lblNewLabel_9 = new JLabel("  查看客户资料，查询客户资料，新增客户资料，更新客户资料等功能");
		lblNewLabel_9.setBorder(new MatteBorder(0, 1, 0, 0, (Color) Color.WHITE));
		lblNewLabel_9.setForeground(Color.WHITE);
		
		JLabel lblNewLabel_10 = new JLabel("  新增城市，修改城市，删除城市等功能");
		lblNewLabel_10.setBorder(new MatteBorder(0, 1, 0, 0, (Color) Color.WHITE));
		lblNewLabel_10.setForeground(Color.WHITE);
		
		JLabel lblNewLabel_11 = new JLabel("  管理用户，高级管理员可以创建新的普通管理员，查询修改和删除普通管理员");
		lblNewLabel_11.setBorder(new MatteBorder(0, 1, 0, 0, (Color) Color.WHITE));
		lblNewLabel_11.setForeground(Color.WHITE);
		
		
		GroupLayout gl_panel_1 = new GroupLayout(panel_1);
		gl_panel_1.setHorizontalGroup(
			gl_panel_1.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_panel_1.createSequentialGroup()
					.addGap(63)
					.addComponent(username)
					.addGap(18)
					.addComponent(userlevel)
					.addGap(18)
					.addGroup(gl_panel_1.createParallelGroup(Alignment.TRAILING)
						.addComponent(button)
						.addComponent(button_1))
					.addGap(278)
					.addComponent(lblNewLabel_9)
					.addContainerGap(466, Short.MAX_VALUE))
				.addGroup(gl_panel_1.createSequentialGroup()
					.addGap(39)
					.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel_1.createSequentialGroup()
							.addComponent(label_1)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(lblNewLabel_2)
							.addGap(254)
							.addComponent(label_3)
							.addGap(10)
							.addComponent(label)
							.addGap(10)
							.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
								.addComponent(lblNewLabel_4, GroupLayout.DEFAULT_SIZE, 138, Short.MAX_VALUE)
								.addComponent(lblNewLabel_1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
						.addGroup(gl_panel_1.createSequentialGroup()
							.addGap(135)
							.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
								.addComponent(lblNewLabel_11)
								.addGroup(gl_panel_1.createSequentialGroup()
									.addComponent(label_2)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(label_5, GroupLayout.PREFERRED_SIZE, 60, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING, false)
										.addComponent(lblNewLabel_7, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
										.addComponent(lblNewLabel_8, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
							.addPreferredGap(ComponentPlacement.RELATED, 409, Short.MAX_VALUE)))
					.addGap(65))
				.addGroup(gl_panel_1.createSequentialGroup()
					.addContainerGap(400, Short.MAX_VALUE)
					.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel_1.createSequentialGroup()
							.addComponent(lblNewLabel_10)
							.addContainerGap())
						.addGroup(gl_panel_1.createSequentialGroup()
							.addComponent(lblNewLabel_3)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(label_4, GroupLayout.PREFERRED_SIZE, 60, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
								.addComponent(lblNewLabel_6, GroupLayout.DEFAULT_SIZE, 145, Short.MAX_VALUE)
								.addComponent(label_6, GroupLayout.PREFERRED_SIZE, 143, GroupLayout.PREFERRED_SIZE))
							.addGap(245))))
		);
		gl_panel_1.setVerticalGroup(
			gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_1.createSequentialGroup()
					.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel_1.createSequentialGroup()
							.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING, false)
								.addGroup(gl_panel_1.createSequentialGroup()
									.addGap(119)
									.addGroup(gl_panel_1.createParallelGroup(Alignment.BASELINE)
										.addComponent(label_3)
										.addComponent(label)))
								.addGroup(gl_panel_1.createSequentialGroup()
									.addGap(131)
									.addComponent(lblNewLabel_1, GroupLayout.PREFERRED_SIZE, 55, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(lblNewLabel_4, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
							.addGap(18)
							.addComponent(lblNewLabel_9)
							.addPreferredGap(ComponentPlacement.RELATED))
						.addGroup(gl_panel_1.createSequentialGroup()
							.addGap(124)
							.addGroup(gl_panel_1.createParallelGroup(Alignment.BASELINE)
								.addComponent(label_1)
								.addComponent(lblNewLabel_2))
							.addPreferredGap(ComponentPlacement.RELATED, 104, Short.MAX_VALUE)
							.addGroup(gl_panel_1.createParallelGroup(Alignment.TRAILING)
								.addGroup(gl_panel_1.createSequentialGroup()
									.addGroup(gl_panel_1.createParallelGroup(Alignment.BASELINE)
										.addComponent(userlevel)
										.addComponent(username))
									.addGap(17))
								.addGroup(gl_panel_1.createSequentialGroup()
									.addComponent(button)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(button_1)))))
					.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel_1.createSequentialGroup()
							.addPreferredGap(ComponentPlacement.RELATED, 36, Short.MAX_VALUE)
							.addGroup(gl_panel_1.createParallelGroup(Alignment.BASELINE)
								.addComponent(label_4, GroupLayout.PREFERRED_SIZE, 34, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblNewLabel_3)))
						.addGroup(gl_panel_1.createSequentialGroup()
							.addGap(34)
							.addComponent(label_6, GroupLayout.PREFERRED_SIZE, 59, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(lblNewLabel_6, GroupLayout.PREFERRED_SIZE, 52, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(lblNewLabel_10)
					.addGap(24)
					.addGroup(gl_panel_1.createParallelGroup(Alignment.TRAILING)
						.addGroup(gl_panel_1.createSequentialGroup()
							.addComponent(lblNewLabel_7, GroupLayout.PREFERRED_SIZE, 56, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(lblNewLabel_8, GroupLayout.PREFERRED_SIZE, 54, GroupLayout.PREFERRED_SIZE)
							.addGap(14))
						.addGroup(gl_panel_1.createSequentialGroup()
							.addGroup(gl_panel_1.createParallelGroup(Alignment.BASELINE)
								.addComponent(label_2)
								.addComponent(label_5, GroupLayout.PREFERRED_SIZE, 34, GroupLayout.PREFERRED_SIZE))
							.addPreferredGap(ComponentPlacement.RELATED)))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(lblNewLabel_11))
		);
		panel_1.setLayout(gl_panel_1);
		
		String result="";
		try {
			URL url = new URL("https://free-api.heweather.net/s6/weather/now?location=淄博&key=48f12d9a666243b99be97f36ef0f2b93");
			InputStream inputStream;
			inputStream = url.openStream();
			result = new BufferedReader(new InputStreamReader(inputStream))
					.lines().collect(Collectors.joining(System.lineSeparator()));
		} catch (IOException e) {
			e.printStackTrace();
		}
		String weatherinfo[] = result.split("\"|:");
		Weather weather = new Weather(weatherinfo[15], weatherinfo[78], weatherinfo[83], weatherinfo[108]);
		String weatherIconUrl = "/images/weather/"+weather.codc+".png";
		
		JPanel weatherPanel = new JPanel();
		weatherPanel.setOpaque(false);
		weatherPanel.setAlignmentX(Component.LEFT_ALIGNMENT);
		
		JLabel weatherIcon = new JLabel("");
		weatherIcon.setIcon(new ImageIcon(MainFrame.class.getResource(weatherIconUrl)));
		
		JLabel weatherTemp = new JLabel(weather.tmp);
		weatherTemp.setFont(new Font("Segoe UI Light", Font.PLAIN, 38));
		weatherTemp.setForeground(Color.WHITE);
		
		JLabel weartherTempIcon = new JLabel("℃ ");
		weartherTempIcon.setFont(new Font("微软雅黑 Light", Font.PLAIN, 22));
		weartherTempIcon.setForeground(Color.WHITE);
		
		JLabel weatherLoaction = new JLabel(weather.location);
		weatherLoaction.setFont(new Font("微软雅黑 Light", Font.PLAIN, 14));
		weatherLoaction.setForeground(Color.WHITE);
		
		JLabel weatherCond = new JLabel(weather.cond);
		weatherCond.setFont(new Font("微软雅黑 Light", Font.PLAIN, 14));
		weatherCond.setForeground(Color.WHITE);
		GroupLayout gl_weatherPanel = new GroupLayout(weatherPanel);
		gl_weatherPanel.setHorizontalGroup(
			gl_weatherPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_weatherPanel.createSequentialGroup()
					.addComponent(weatherIcon)
					.addGroup(gl_weatherPanel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_weatherPanel.createSequentialGroup()
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(weatherTemp)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(weartherTempIcon))
						.addGroup(Alignment.TRAILING, gl_weatherPanel.createSequentialGroup()
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(weatherLoaction)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(weatherCond)
							.addGap(52)))
					.addGap(60))
		);
		gl_weatherPanel.setVerticalGroup(
			gl_weatherPanel.createParallelGroup(Alignment.LEADING)
				.addComponent(weatherIcon, GroupLayout.PREFERRED_SIZE, 118, GroupLayout.PREFERRED_SIZE)
				.addGroup(gl_weatherPanel.createSequentialGroup()
					.addGap(26)
					.addGroup(gl_weatherPanel.createParallelGroup(Alignment.BASELINE)
						.addComponent(weatherTemp, GroupLayout.PREFERRED_SIZE, 37, GroupLayout.PREFERRED_SIZE)
						.addComponent(weartherTempIcon, GroupLayout.PREFERRED_SIZE, 37, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_weatherPanel.createParallelGroup(Alignment.BASELINE)
						.addComponent(weatherLoaction)
						.addComponent(weatherCond, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
					.addGap(2))
		);
		weatherPanel.setLayout(gl_weatherPanel);
		
		JLabel topTitle = new JLabel("客户资料管理系统");
		topTitle.setAlignmentX(Component.CENTER_ALIGNMENT);
		topTitle.setForeground(Color.WHITE);
		topTitle.setFont(new Font("幼圆", Font.PLAIN, 38));
		
		JPanel timePanel = new JPanel();
		timePanel.setOpaque(false);
		
		SimpleDateFormat df = new SimpleDateFormat("EEEE");
		JLabel label_11 = new JLabel(df.format(new Date()));
		label_11.setFont(new Font("微软雅黑 Light", Font.PLAIN, 18));
		label_11.setForeground(Color.WHITE);
		
		df = new SimpleDateFormat("yyyy-MM-dd");
		JLabel datetime = new JLabel(df.format(new Date()));
		datetime.setFont(new Font("Microsoft YaHei UI Light", Font.PLAIN, 14));
		datetime.setForeground(Color.WHITE);
		GroupLayout gl_timePanel = new GroupLayout(timePanel);
		gl_timePanel.setHorizontalGroup(
			gl_timePanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_timePanel.createSequentialGroup()
					.addGap(34)
					.addGroup(gl_timePanel.createParallelGroup(Alignment.LEADING)
						.addComponent(datetime)
						.addComponent(label_11, GroupLayout.PREFERRED_SIZE, 65, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(28, Short.MAX_VALUE))
		);
		gl_timePanel.setVerticalGroup(
			gl_timePanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_timePanel.createSequentialGroup()
					.addGap(26)
					.addComponent(label_11, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(datetime)
					.addContainerGap(41, Short.MAX_VALUE))
		);
		timePanel.setLayout(gl_timePanel);
		GroupLayout gl_topPanel = new GroupLayout(topPanel);
		gl_topPanel.setHorizontalGroup(
			gl_topPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_topPanel.createSequentialGroup()
					.addComponent(weatherPanel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addGap(415)
					.addComponent(topTitle)
					.addGap(482)
					.addComponent(timePanel, GroupLayout.PREFERRED_SIZE, 136, GroupLayout.PREFERRED_SIZE)
					.addGap(301))
		);
		gl_topPanel.setVerticalGroup(
			gl_topPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_topPanel.createSequentialGroup()
					.addGroup(gl_topPanel.createParallelGroup(Alignment.LEADING)
						.addGroup(Alignment.TRAILING, gl_topPanel.createSequentialGroup()
							.addContainerGap()
							.addComponent(timePanel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
						.addComponent(weatherPanel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_topPanel.createSequentialGroup()
							.addGap(35)
							.addComponent(topTitle)))
					.addContainerGap())
		);
		topPanel.setLayout(gl_topPanel);
		panel.setLayout(gl_panel1);
		
		JLabel lblNewLabel_13 = new JLabel("易");
		lblNewLabel_13.setFont(new Font("\u65B9\u6B63\u8212\u4F53", lblNewLabel_13.getFont().getStyle(), lblNewLabel_13.getFont().getSize() + 161));
		lblNewLabel_13.setForeground(Color.WHITE);
		lblNewLabel_13.setBounds(1153, 223, 220, 173);
		contentPane.add(lblNewLabel_13);
		
		JLabel lblNewLabel_16 = new JLabel("关于我们");
		lblNewLabel_16.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lblNewLabel_16.setBorder(new MatteBorder(0, 0, 1, 0, (Color) Color.WHITE));
		lblNewLabel_16.setIcon(new ImageIcon(MainFrame.class.getResource("/lombok/installer/eclipse/myeclipse.png")));
		lblNewLabel_16.setFont(new Font("微软雅黑 Light", Font.PLAIN, 27));
		lblNewLabel_16.setForeground(Color.WHITE);
		lblNewLabel_16.setBounds(900, 870, 144, 59);
		contentPane.add(lblNewLabel_16);
		
		JLabel lblNewLabel_14 = new JLabel("管理");
		lblNewLabel_14.setFont(new Font("华文行楷", Font.BOLD, 85));
		lblNewLabel_14.setForeground(Color.WHITE);
		lblNewLabel_14.setBounds(1327, 324, 187, 129);
		contentPane.add(lblNewLabel_14);
		
		JLabel lblNewLabel_15 = new JLabel("New label");
		lblNewLabel_15.setIcon(new ImageIcon(MainFrame.class.getResource("/images/framebg2.png")));
		lblNewLabel_15.setBounds(1163, 216, 382, 285);
		contentPane.add(lblNewLabel_15);
		
		JLabel lblNewLabel_12 = new JLabel("");
		lblNewLabel_12.setIcon(new ImageIcon(MainFrame.class.getResource("/images/framebg.png")));
		lblNewLabel_12.setBounds(0, 956, 1919, 59);
		contentPane.add(lblNewLabel_12);
		
		JLabel lblNewLabel_5 = new JLabel("");
		lblNewLabel_5.setIcon(new ImageIcon(MainFrame.class.getResource("/images/framebg.png")));
		lblNewLabel_5.setBounds(721, 472, 144, 59);
		contentPane.add(lblNewLabel_5);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setBounds(0, 370, 349, 83);
		contentPane.add(lblNewLabel);
		lblNewLabel.setIcon(new ImageIcon(MainFrame.class.getResource("/images/framebg.png")));
		
		JLabel label_21 = new JLabel("");
		label_21.setIcon(new ImageIcon(MainFrame.class.getResource("/images/framebg.png")));
		label_21.setBounds(0, 223, 407, 83);
		contentPane.add(label_21);
		
		JLabel topbackground = new JLabel("");
		topbackground.setIcon(new ImageIcon(MainFrame.class.getResource("/images/framebg.png")));
		topbackground.setBounds(0, 0, 1919, 118);
		contentPane.add(topbackground);
		
		JLabel backgroung = new JLabel("");
		backgroung.setBackground(Color.BLACK);
		backgroung.setIcon(new ImageIcon(MainFrame.class.getResource("/images/bg8.jpg")));
		backgroung.setBounds(0, 0, 1990, 1016);
		contentPane.add(backgroung);

	}

	/**
	 * 客户列表
	 * @param e
	 */
	protected void listCustomerButton(MouseEvent e) {
		new ListCustomerFrame().setVisible(true);
	}

	/**
	 * 新增客户
	 * @param e
	 */
	protected void addCustomerButton(MouseEvent e) {
		new AddCustomerFrame().setVisible(true);
	}

	/**
	 * 新增城市
	 * @param e
	 */
	protected void addCityButton(MouseEvent e) {
		new AddCityFrame().setVisible(true);
	}

	/**
	 * 城市列表
	 * @param e
	 */
	protected void listCityButton(MouseEvent e) {
		new ListCityFrame().setVisible(true);
	}

	/**
	 * 用户列表按钮点击事件
	 * @param e
	 */
	protected void listUserButton(MouseEvent e) {
		new ListUserFrame().setVisible(true);
	}

	/**
	 * 增加用户按钮点击事件
	 * @param e
	 */
	protected void addUserButton(MouseEvent e) {
		new AddUserFrame().setVisible(true);
	}

	/**
	 * 客户管理组件点击事件
	 * @param e
	 */
	protected void mangeCusButton(MouseEvent e, JPanel mangeCusPanel) {
		getContentPane().add(mangeCusPanel);
	}


	/**
	 * 退出按钮
	 * @param e
	 */
	protected void exitButton(ActionEvent e) {
		System.exit(0);
	}

	/**
	 *  修改密码按钮
	 * @param arg0
	 * @param user
	 */
	protected void updatePasswordButton(ActionEvent arg0, User user) {
		new UpdatePwdFrame(user).setVisible(true);
	}

	/**
	 * 窗口大小改变事件
	 */
	protected void mainFrameComponentResized(ComponentEvent arg0, JPanel topPanel, GroupLayout gl_panel) {
		
	}
}
