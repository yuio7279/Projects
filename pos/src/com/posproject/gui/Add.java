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
import com.posproject.valid.Valid_buy;

public class Add extends JPanel {
	private ArrayList<Product> list;
	JScrollPane scroll;
	private Vector<String> tableTitle;
	private DefaultTableModel model;
	private JTable table;
	JTextField[] jtf;
	ProductDAO pDao = new ProductDAO();

	public Add() {
		setLayout(new BorderLayout());
		addPanel(this);

		AddTblScrolll add = new AddTblScrolll();
		add(add, BorderLayout.CENTER);
	}

	public JPanel addPanel(JPanel panel) {

		JPanel add_pn = new JPanel();
		JLabel name_la = new JLabel("추가하실 상품명 : ");
		JTextField name_tx = new JTextField(12);
		JLabel stock_la = new JLabel("재고량 : ");
		JTextField stock_tx = new JTextField(12);
		JLabel price_la = new JLabel("가격 : ");
		JTextField price_tx = new JTextField(12);
		add_pn.add(name_la);
		add_pn.add(name_tx);
		add_pn.add(stock_la);
		add_pn.add(stock_tx);
		add_pn.add(price_la);
		add_pn.add(price_tx);

		Valid_buy valid = new Valid_buy();
		JButton addBtn = new JButton("상품 추가하기");
		add_pn.add(addBtn);
		addBtn.addActionListener((e) -> {
			try {
				String productName = name_tx.getText();
				int stock = Integer.parseInt(stock_tx.getText());
				int price = Integer.parseInt(price_tx.getText());

				if (valid.validProduct(productName) == 1) { // 기존의 상품이 없다면
					if (valid.addCheck(productName, stock_tx.getText(), price_tx.getText()) == 1) { // 양식 체크
						if (pDao.addProcess(productName, stock, price) == 1) { // 등록완료시
							name_tx.setText("");
							stock_tx.setText("");
							price_tx.setText("");
							JOptionPane.showMessageDialog(null, "상품 추가가 완료 되었습니다.");
						}
					}
				}

				else {
					if (valid.addCheck(productName, stock_tx.getText(), price_tx.getText()) == 1) { // 양식 체크
						if (pDao.updateProcess(productName, stock, price) == 1) { // 등록완료시
							name_tx.setText("");
							stock_tx.setText("");
							price_tx.setText("");
							JOptionPane.showMessageDialog(null, "상품 수정이 완료 되었습니다.");
						}
					}
				}
				
				JButton imsi = (JButton) e.getSource();
				Start imsi2 = (Start) imsi.getTopLevelAncestor();
				imsi2.viewScreen(new Add());
			} catch (NumberFormatException e1) {

				JOptionPane.showMessageDialog(null, "상품명, 재고량, 가격 입력을 확인해주세요");
			}
		});

		panel.add(add_pn, BorderLayout.SOUTH);

		return panel;
	}

	class AddTblScrolll extends JPanel {
		AddTblScrolll() {
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
