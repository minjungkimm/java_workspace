package com.ss.gui;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;

public class MyWin extends JFrame implements ActionListener, KeyListener{
	JTextField t_input;
	
	JButton bt;
	MyKeyListener myKey;
	MyActionListener myAction;
	
	public MyWin(){
		t_input=new JTextField(20);
		
		bt=new JButton("버튼");
		setLayout(new FlowLayout());
		
		add(t_input);
		add(bt);
		myAction=new MyActionListener();
		myKey=new MyKeyListener();
		
		
		t_input.addKeyListener(myKey);
		bt.addActionListener(myAction); //일반클래스 사용 원함. 변수로 받던지,  new MyActionListener()로 하면 됨
		
		setSize(400,500);
		setVisible(true);		
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
	}
	
	public void keyPressed(KeyEvent e) {
		
		
	}

	
	public void keyReleased(KeyEvent e) {
		

	}

	
	public void keyTyped(KeyEvent e) {
		
		
	}

	
	public void actionPerformed(ActionEvent e) {
		MyActionListener.setAction(this,JTextField );
		
	}
	
	public static void main(String[] args) {
		new MyWin();

	}


}
