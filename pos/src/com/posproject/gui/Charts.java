package com.posproject.gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;
import javax.swing.JPanel;

import com.posproject.dao.BuyDAO;
import com.posproject.main.Start;


public class Charts extends JFrame {
	BuyDAO bDao = new BuyDAO();

	public Charts() {

	        setTitle("매출 현황 차트");
			setResizable(false);
			setLocation(600,320);
			setBackground(Color.white);
	        setPreferredSize(new Dimension(700,450));
	        Container contentPane = getContentPane();

	        addWindowListener(new WindowAdapter() {
	        	public void windowClosing(WindowEvent e) {
	        		new SalesRank();
	        		dispose();
	        	}
	        });


	        DrawingPanel drawingPanel = new DrawingPanel();	//드로잉 패널 선언
	        contentPane.add(drawingPanel, BorderLayout.CENTER);
	        //그래프를 그릴 패널



	        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	        pack();
	        setVisible(true);


			setBackground(Color.white);
	}
	   class DrawingPanel extends JPanel
	        {
		   		double[] stocks =	bDao.get5BestSell();
		   		int[] stocks_i = new int[5];
		   		String[] products = bDao.get5BestSell_p();

		   		public void setStock() {
		   			for(int i=0; i<5; i++) {
		   				stocks[i] = Math.floor((stocks[i]) / 3.55);


		   				stocks_i[i] = (int)(stocks[i]);

		   			}
		   		}
		   		DrawingPanel(){
		   			setStock();
		   		}

	            public void paint(Graphics g){
	                g.clearRect(0,0,getWidth(),getHeight());
	                g.drawLine(70,315,600,315);
	                for(int cnt = 1 ;cnt<10;cnt++)
	                {
	                    g.drawString(cnt *100 +"",25,320-28*cnt);
	                    g.drawLine(70, 315-28*cnt, 600,315-28*cnt);
	                }
	                g.drawString("매출 상위 품목 5개", 300, 40);
	                g.drawLine(70,50,70,315);
	                g.drawString(products[4],100,340);
	                g.drawString(products[3],200,340);
	                g.drawString(products[2],300,340);
	                g.drawString(products[1],400,340);
	                g.drawString(products[0],500,340);
	                g.setColor(Color.PINK);

	                //기존 값 / 3.55를 해야 맞게 그려진다.
	                    g.fillRect(120,315-stocks_i[4],10,stocks_i[4]);
	                    g.fillRect(220,315-stocks_i[3],10,stocks_i[3]);
	                    g.fillRect(320,315-stocks_i[2],10,stocks_i[2]);
	                    g.fillRect(420,315-stocks_i[1],10,stocks_i[1]);
	                    g.fillRect(520,315-stocks_i[0],10,stocks_i[0]);
	            }
	        }
}