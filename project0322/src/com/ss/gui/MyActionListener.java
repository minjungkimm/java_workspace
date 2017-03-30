package com.ss.gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTextField;

public class MyActionListener implements ActionListener{
	MyWin mywin;
	JTextField t_input;
	
	public void actionPerformed(ActionEvent e) {

		System.out.println("버튼 누름!!");
		
		String msg=t_input.getText();
		
	}

	public void setAction(MyWin mywin,JTextField t_input){
		this.mywin=mywin;
		this.t_input=t_input;
	}
	
}
