package com.ss.gui;

import java.awt.FlowLayout;
import java.awt.event.ActionListener;
import java.awt.event.KeyListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextArea;
import javax.swing.JTextField;


public class MyWin extends JFrame implements ActionListener,KeyListener{
	JTextField t_input;
	JButton bt;
	JTextArea area;
	
	public MyWin(){
		t_input = new JTextField(20);
		bt = new JButton("클릭");
		//사용하고싶으면, new 올려야한다
		MyActionListener my= new MyActionListener();
		bt.addActionListener(my);
		MyKeyListener key= new MyKeyListener();
		t_input.addKeyListener(key);
		
		setLayout(new FlowLayout());
		setVisible(true);
		setSize(300,450);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		add(bt);
		add(t_input);

	}
	
	
	public static void main(String[] args) {
		new MyWin();

	}

}
