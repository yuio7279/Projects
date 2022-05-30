package com.posproject.valid;

import javax.swing.JButton;
import javax.swing.JTextField;

public class CheckField {
	JTextField jtf;
	JButton jbt;

	CheckField(JTextField jtf, JButton jbt) {
		this.jtf = jtf;
		this.jbt = jbt;
	}

	public JTextField getJtf() {
		return this.jtf;
	}

	public JButton getJbt() {
		return this.jbt;
	}
}