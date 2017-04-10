package com.ss.gui;

import java.awt.BorderLayout;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class ChatC extends JFrame implements KeyListener{
	JTextArea area;
	JScrollPane scroll;
	JPanel p_south;
	JTextField t_input;
	JButton bt;
	private ChatA chatA;
	private ChatB chatB;


	public ChatC() {
		area = new JTextArea();
		scroll = new JScrollPane();
		p_south = new JPanel();
		bt = new JButton("열기");
		t_input = new JTextField(15);
		
		this.add(scroll);
		p_south.add(t_input);
		p_south.add(bt);
		this.add(p_south,BorderLayout.SOUTH);
		
		t_input.addKeyListener(this);
		
		setBounds(400,500,300,400);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
	}
	


	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		//ChatA,ChatC 에게 메세지 보내기!!
		int key = e.getKeyCode();
		if(key ==KeyEvent.VK_ENTER){
			String msg=t_input.getText();
			area.append(msg+"\n");
			chatA.area.append(msg+"\n");
			chatB.area.append(msg+"\n");
			t_input.setText("");

		}
		
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}	
	
	public void setChatA(ChatA chatA) {
		this.chatA = chatA;
	}
	
	public void setChatB(ChatB chatB) {
		this.chatB = chatB;
	}	
}

