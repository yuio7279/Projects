package com.posproject.gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellEditor;
import javax.swing.table.TableCellRenderer;

import com.posproject.dao.BuyDAO;
import com.posproject.dao.ProductDAO;
import com.posproject.dto.Buy;
import com.posproject.main.Start;
import com.posproject.process.LoginUser;
import com.posproject.valid.Valid_user;

import java.util.*;

public class Refund extends JPanel {
	private ArrayList<Buy> list;
	JScrollPane scroll;
	private Vector<String> tableTitle;
	private DefaultTableModel model;
	private JTable table;
	JTextField[] jtf;
	BuyDAO bDao = new BuyDAO();
	ProductDAO pDao = new ProductDAO();
	Valid_user u_valid = new Valid_user();
	public Refund() {
		setLayout(new BorderLayout());
		BuyList buy = new BuyList();
		add(buy, BorderLayout.CENTER);
	}

	public void rep() {
		this.repaint();
		this.revalidate();
	}

	class BuyList extends JPanel {
		BuyList() {
			setLayout(new GridLayout(1, 1));
			list = bDao.getBuyTbl(LoginUser.id);
			setBackground(Color.BLACK);
			tableTitle = new Vector<String>();
			tableTitle.addElement("구매번호");
			tableTitle.add("상품명");
			tableTitle.add("구매량");
			tableTitle.add("구매가격");
			tableTitle.add("환불");
			model = new DefaultTableModel(tableTitle, 0){	//버튼 제외 클릭금지
		         public boolean isCellEditable(int i, int c){
		        	 if(c==4) {
		        		 return true;
		        	 }
		        	 else {
		        		 return false;
		        	 }
		         }
		        };
			table = new JTable(model);
			table.setRowHeight(50);
			table.setFont(new Font("SansSerif",Font.PLAIN,15));
			try {
				table.getColumnModel().getColumn(4).setCellRenderer(new TableCell());
				;
				table.getColumnModel().getColumn(4).setCellEditor(new TableCell());
				;
			} catch (Exception e) {
				// TODO Auto-generated catch block
				System.out.println("ggg");
			}

			scroll = new JScrollPane(table);

			for (Buy data : list) {
				Vector<String> imsi = new Vector<String>();
				imsi.add(Integer.toString(data.getBuyNo()));
				imsi.add(data.getProduct());
				imsi.add(Integer.toString(data.getStock()));
				imsi.add(Integer.toString(data.getPrice()));
				imsi.add("환불");
				model.addRow(imsi);
			}

			add(scroll);
		}

	}

	class ConfirmList extends JPanel {
		ConfirmList() {
			JButton btn1 = new JButton("일단크기");
			add(btn1);
		}
	}

	class TableCell extends AbstractCellEditor implements TableCellEditor, TableCellRenderer {
		JButton jb;

		public TableCell() {
			jb = new JButton("환불하기");

			jb.addActionListener(e -> {

				int real = JOptionPane.showConfirmDialog(null, "정말 환불할까요?", "Confirm", JOptionPane.YES_NO_OPTION);
				if (real == JOptionPane.CLOSED_OPTION) {

				} else if (real == JOptionPane.YES_OPTION) {

					int buyNo = Integer.parseInt((String) table.getValueAt(table.getSelectedRow(), 0));
					String product = (String) table.getValueAt(table.getSelectedRow(), 1);
					int stock = Integer.parseInt((String) table.getValueAt(table.getSelectedRow(), 2));

					if (Double.parseDouble((String) table.getValueAt(table.getSelectedRow(), 3)) != 0) {

						pDao.refund(buyNo, stock, product);
						JOptionPane.showMessageDialog(null, "환불 완료!");
						if(u_valid.rankManager(LoginUser.id)==1) {
							JOptionPane.showMessageDialog(null, "등급이 변경되었습니다. 해당등급에 따른 할인율을 적용받습니다.");
						}
						JButton imsi = (JButton) e.getSource();
						Start imsi2 = (Start) imsi.getTopLevelAncestor();
						imsi2.viewScreen(new Refund());
					} else {
						JOptionPane.showMessageDialog(null, "이미 환불한 상품입니다!", "경고입니다", JOptionPane.ERROR_MESSAGE);
					}
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