package com.games.world.applocations.jdbc.main;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import com.games.world.applocations.jdbc.JDBCResult;
import com.games.world.applocations.jdbc.sql.UsrSql;

public class GamesMain {

	public static void main(String[] args) {
//		JFrame.setDefaultLookAndFeelDecorated(true);
		start();
		// System.out.println(gamesMain.jdbcList(UsrSql.GET_USR_ALL));
	}

	public static void start() {
		GamesMain gamesMain = new GamesMain();
		// 创建 JFrame 实例
		JFrame frame = new JFrame("login");
		// Setting the width and height of frame
		frame.setSize(350, 200);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		// 创建面板，这个类似于 HTML 的 div 标签 我们可以创建多个面板并在 JFrame
		// 中指定位置面板中我们可以添加文本字段，按钮及其他组件。
		JPanel panel = new JPanel();
		// 添加面板
		frame.add(panel);
		// 调用用户定义的方法并添加组件到面板
		gamesMain.placeComponents(panel, frame);
		// 设置界面可见
		frame.setVisible(true);
	}

	// login
	public void placeComponents(JPanel panel, JFrame frame) {
		GamesMain gamesMain = new GamesMain();
		// 布局部分我们这边不多做介绍 这边设置布局为 null
		panel.setLayout(null);
		// 设置面板的边框
		panel.setBorder(new EmptyBorder(5, 5, 5, 5));
		// 创建 JLabel
		JLabel userLabel = new JLabel("User:");
		// 这个方法定义了组件的位置。 setBounds(x, y, width, height) x 和 y 指定左上角的新位置，由 width和
		// height 指定新的大小。
		userLabel.setBounds(10, 20, 80, 25);
		panel.add(userLabel);
		// 创建文本域用于用户输入
		JTextField userText = new JTextField(20);
		userText.setBounds(100, 20, 165, 25);
		panel.add(userText);
		// 输入密码的文本域
		JLabel passwordLabel = new JLabel("Password:");
		passwordLabel.setBounds(10, 50, 80, 25);
		panel.add(passwordLabel);
		// 这个类似用于输入的文本域 但是输入的信息会以点号代替，用于包含密码的安全性
		JPasswordField passwordText = new JPasswordField(20);
		passwordText.setBounds(100, 50, 165, 25);
		panel.add(passwordText);
		// 创建登录按钮
		JButton loginButton = new JButton("login");
		loginButton.setBounds(10, 80, 80, 25);
		// 监听登录按钮
		loginButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				char[] passrodChar = passwordText.getPassword();
				StringBuffer passwordBuffer = new StringBuffer();
				for (int i = 0; i < passrodChar.length; i++) {
					passwordBuffer.append(passwordText.getPassword()[i]);
				}
				Map<String, Object> loginResultMap = gamesMain.login(userText.getText(), passwordBuffer.toString());
				boolean loginfg = (boolean) loginResultMap.get("loginfg");
				if (loginfg) {
					// 关闭之前的窗口
					frame.setVisible(false);
					gamesMain.loginFrame(loginResultMap.get("id").toString());
				} else {
					// error错误提示
					JOptionPane.showMessageDialog(panel, "账号/密码错误", "提示", JOptionPane.WARNING_MESSAGE);
				}
			}
		});
		panel.add(loginButton);
	}

	// login事件
	public Map<String, Object> login(String Usrname, String Password) {
		Map<String, Object> resultMap = new HashMap<>();
		String sql = UsrSql.loginSQL(Usrname, Password);
		List<Map<String, Object>> loginList = JDBCResult.jdbcList(sql);
		System.out.println("loginMap:" + loginList);
		if (loginList == null || loginList.size() < 1) {
			System.out.println("账号密码错误");
			resultMap.put("loginfg", false);
			return resultMap;
		} else {
			System.out.println("success");
			resultMap.put("loginfg", true);
			resultMap.put("name", loginList.get(0).get("name"));
			resultMap.put("id", loginList.get(0).get("id"));
			return resultMap;
		}
	}

	// index frame
	private void loginFrame(String usrID) {
		GamesMain gamesMain = new GamesMain();
		JFrame indexFrame = new JFrame("index");
		// Setting the width and height of frame
		indexFrame.setSize(400, 800);
		indexFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		// 创建面板，这个类似于 HTML 的 div 标签 我们可以创建多个面板并在 JFrame
		// 中指定位置面板中我们可以添加文本字段，按钮及其他组件。
		JPanel indexPanel = new JPanel();
		// 添加面板
		indexFrame.add(indexPanel);
		// 调用用户定义的方法并添加组件到面板
		gamesMain.indexComponents(indexPanel, indexFrame, usrID);
		// 设置界面可见
		indexFrame.setVisible(true);
	}

	// index components
	public void indexComponents(JPanel indexPanel, JFrame frame, String usrID) {
		// 查询index所需的所有数据（缺表，缺数据）
		String sql = UsrSql.getUsrInfo(usrID);
		List<Map<String, Object>> usrInfo = JDBCResult.jdbcList(sql);
		Map<String, Object> usrMap=usrInfo.get(0);
		System.out.println(usrMap);
		// getUsrInfo
		indexPanel.setLayout(null);
		// 设置面板的边框
		indexPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		//用户昵称
		JLabel headerLabel = new JLabel("用户:" + usrMap.get("name"));
		headerLabel.setBounds(10, 10, 150, 40);
		indexPanel.add(headerLabel);
		
		JLabel careernmLabel = new JLabel("阶级:" + usrMap.get("careernm"));
		careernmLabel.setBounds(200, 10, 150, 40);
		indexPanel.add(careernmLabel);
		
		JLabel nameLabel = new JLabel("副职业:" + usrMap.get("name"));
		nameLabel.setBounds(10, 40, 150, 40);
		indexPanel.add(nameLabel);
	}

}
