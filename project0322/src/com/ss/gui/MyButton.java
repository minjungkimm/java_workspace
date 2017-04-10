package com.ss.gui;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class MyButton extends JFrame implements ActionListener {
	JButton bt_create;
	JButton bt_color;
	JPanel p_north;
	int count=0;
	
	public MyButton(){
		bt_create=new JButton("버튼추가");
		bt_color=new JButton("버튼색상");
		p_north=new JPanel();
		p_center=new JPanel();
		
		p.add(bt_create);
		p.add(bt_color);
		add(p_north,BorderLayout.NORTH);
		
		//누르면버튼추가//
		bt_create.addActionListener(new ActionListener() {
			
			//이벤트 구현!!
			public void actionPerformed(ActionEvent e) {
				//버튼생성!!
				createButton();
				
			}
		});
		
		//버튼생성 메서드!!
		//피곤함에도, 별도로 뺀 이유는?
		//이벤트에 의존하여 로직을 작성하면 , 이벤트 방식의 변경에 의해
		//로직도 손상!! 받으니깐... 그래서 뺐다!!
		public void createButton(){
				count++;
				JButton bt=new JButton(Interger.toString(count));
				p_center.add(bt);
				p_center.updateUI(); //refresh
		}
	
		
		setVisible(true);
		setSize(500, 600);
		setDefaultCloseOperation(EXIT_ON_CLOSE);	
		
	}
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		for(int i=1; i<40; i++){
		System.out.println("응");
		//bt_plus=new JButton("i");
		//bt_plus.setBounds(50*i,50,50,100);
		//append(bt_plus);
		}
	}
	
	public static void main(String[] args) {
		new MyButton();
		
	}

}
