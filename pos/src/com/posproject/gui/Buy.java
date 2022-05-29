package com.posproject.gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.GridLayout;
import java.awt.HeadlessException;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellEditor;
import javax.swing.table.TableCellRenderer;

import com.posproject.dao.BuyDAO;
import com.posproject.dao.DAO;
import com.posproject.dao.ProductDAO;
import com.posproject.dao.UserDAO;
import com.posproject.dto.Product;
import com.posproject.dto.User;
import com.posproject.main.Start;
import com.posproject.process.LoginUser;
import com.posproject.valid.LoginInfo;
import com.posproject.valid.Valid_buy;

import java.util.*;

public class Buy extends JPanel {
	private ArrayList<Product> list;
	JScrollPane scroll;
	private Vector<String> tableTitle;
	private DefaultTableModel model;
	private JTable table;
	JTextField[] jtf;
	ProductDAO pDao = new ProductDAO();
	BuyDAO bDao = new BuyDAO();
	UserDAO uDao = new UserDAO();
	Valid_buy valid = new Valid_buy();

	public Buy() {
		setLayout(new BorderLayout());
		AddTblScroll buy = new AddTblScroll();
		add(buy, BorderLayout.CENTER);
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
			tableTitle.add("구매");
			model = new DefaultTableModel(tableTitle, 0);
			table = new JTable(model);
			table.getColumnModel().getColumn(3).setCellRenderer(new TableCell());
			;
			table.getColumnModel().getColumn(3).setCellEditor(new TableCell());
			;

			scroll = new JScrollPane(table);

			String id = LoginUser.id;
			int rank = uDao.getRank(id);

			switch (rank) {
			case 1: {
				for (Product data : list) { // 일반등급일때
					display(data, 1);
				}

				break;
			}
			case 2: {
				for (Product data : list) { // 우수등급일때 상품값을 20퍼센트 할인
					display(data, 0.8);
				}

				break;
			}
			case 3: { // VIP등급
				for (Product data : list) {
					display(data, 0.7);
				}
				break;
			}
			}

			add(scroll);
		}
	}

	public void display(Product data, double x) {
		Vector<String> imsi = new Vector<String>();
		imsi.add(data.getProduct());
		imsi.add(Integer.toString(data.getStock()));
		int price = (int) (data.getPrice() * x);
		imsi.add(Integer.toString(price));

		imsi.add("구매");
		model.addRow(imsi);
	}

	class TableCell extends AbstractCellEditor implements TableCellEditor, TableCellRenderer {
		JButton jb;

		public TableCell() {
			jb = new JButton("구매하기");
			jb.addActionListener(e -> {
				try {
					String amount = JOptionPane.showInputDialog("구매 수량을 입력하세요");
					if (valid.buyCheck(amount) == 1) {
						String product = (String) table.getValueAt(table.getSelectedRow(), 0);
						double price = Double.parseDouble((String) table.getValueAt(table.getSelectedRow(), 2));
						price = price * Integer.parseInt(amount);
						System.out.println(amount + " / " + product + " / " + price);

						int stock = Integer.parseInt((String) table.getValueAt(table.getSelectedRow(), 1));
						if (Integer.parseInt(amount) > stock) {
							JOptionPane.showMessageDialog(null, "수량을 잘 확인하세요", "경고입니다", JOptionPane.ERROR_MESSAGE);
						} else if (Integer.parseInt(amount) <= stock) {
							stock = stock - Integer.parseInt(amount);
							bDao.buyProcess(LoginUser.id, product, Integer.parseInt(amount), price, stock);
							JButton imsi = (JButton) e.getSource();
							Start imsi2 = (Start) imsi.getTopLevelAncestor();
							imsi2.viewScreen(new Buy());

						}
					}
				} catch (NullPointerException e1) {
				} catch (NumberFormatException e1) {
				}

			});
		}

		@Override
		public Object getCellEditorValue() {
			return null;
		}

		@Override
		public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus,
				int row, int column) {
			return jb;
		}

		@Override
		public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row,
				int column) {
			return jb;
		}
	}
}
