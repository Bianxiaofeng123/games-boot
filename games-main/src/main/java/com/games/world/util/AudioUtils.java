package com.games.world.util;

import java.applet.Applet;
import java.applet.AudioClip;
import java.net.MalformedURLException;
import java.net.URL;

import javax.swing.JButton;
import javax.swing.JFrame;

public class AudioUtils extends JFrame {
	
	private static final long serialVersionUID = 1L;

	public static void main(String[] args) {
		createUI();
		new AudioUtils();
	}

	public void Audio() {
		setSize(200, 200);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);

		URL codebase = null;
		try {
			// codebase = new URL("file:/C:/tmp/1/Windows Ding.wav");
			codebase = new URL(
					"file:/F:/网易云音乐下载文件夹/2 Chainz/We Own It (Single)/2 Chainz - We Own It (feat. Wiz Khalifa)");
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
		AudioClip audio1 = Applet.newAudioClip(codebase);
		audio1.loop();
	}

	public static void createUI() {
		JFrame frame = new JFrame();
		JButton jb = new JButton("创建临时文件");
		frame.add(jb, "North");
		frame.setSize(200, 100);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}
}
