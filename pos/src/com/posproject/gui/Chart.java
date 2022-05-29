package com.posproject.gui;

import java.awt.Container;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;

import com.posproject.main.Start;
import com.posproject.main.Start.Login;

public class Chart extends JFrame {
	Container c;
	public Chart() {
		setTitle("매출순위 차트");
		setSize(1000, 400);
		setResizable(false);
		setLocationRelativeTo(null);
		c = getContentPane();
		setVisible(true);
	}
	
	
	
}
