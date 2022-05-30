package com.posproject.gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.util.ArrayList;
import java.util.Vector;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import com.posproject.dao.ProductDAO;
import com.posproject.dto.Product;
import com.posproject.main.Start;

public class Remove extends JPanel {
	private ArrayList<Product> list;
	JScrollPane scroll;
	private Vector<String> tableTitle;
	private DefaultTableModel model;
	private JTable table;
	JTextField[] jtf;
	ProductDAO pDao = new ProductDAO();

	public Remove() {
		setLayout(new BorderLayout());
		addPanel(this);

		AddTblScroll remove = new AddTblScroll();
		add(remove, BorderLayout.CENTER);

	}

	public JPanel addPanel(JPanel panel) {

		JPanel add_pn = new JPanel();
		JLabel name_la = new JLabel("삭제하실 상품명 : ");
		JTextField name_tx = new JTextField(12);
		add_pn.add(name_la);
		add_pn.add(name_tx);

		JButton addBtn = new JButton("상품 삭제하기");
		add_pn.add(addBtn);
		addBtn.addActionListener((e) -> {
			String productName = name_tx.getText();

			if (pDao.removeProcess(productName) == 1) {
				name_tx.setText("");
				JOptionPane.showMessageDialog(null, "[" + productName + "] 삭제 완료");
			}
			;
			JButton imsi = (JButton) e.getSource();
			Start imsi2 = (Start) imsi.getTopLevelAncestor();
			imsi2.viewScreen(new Remove());
		});

		panel.add(add_pn, BorderLayout.SOUTH);

		return panel;
	}

	class AddTblScroll extends JPanel {
		AddTblScroll() {
			setLayout(new GridLayout(1, 1));
			list = pDao.getProductTbl();
			setBackground(Color.BLACK);
			tableTitle = new Vector<String>();
			tableTitle.addElement("상품명");
			tableTitle.add("재고");
			tableTitle.add("가격");
			model = new DefaultTableModel(tableTitle, 0);
			table = new JTable(model);
			table.getColumnModel().getColumn(2).setCellRenderer(null);
			;
			table.getColumnModel().getColumn(2).setCellEditor(null);
			;

			scroll = new JScrollPane(table);

			for (Product data : list) {
				Vector<String> imsi = new Vector<String>();
				imsi.add(data.getProduct());
				imsi.add(Integer.toString(data.getStock()));
				imsi.add(Integer.toString(data.getPrice()));
				model.addRow(imsi);
			}

			add(scroll);
		}

	}

}
