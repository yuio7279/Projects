package com.posproject.gui;

import java.awt.Container;

import javax.swing.JFrame;


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
