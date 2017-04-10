package com.ss.gui;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class ChatA extends JFrame implements ActionListener, KeyListener {
	JTextArea area;
	JScrollPane scroll;
	JPanel p_south;
	JTextField t_input;
	JButton bt;
	private ChatB chatB;
	private ChatC chatC;

	public ChatA() {
		area = new JTextArea();
		scroll = new JScrollPane();
		p_south = new JPanel();
		bt = new JButton("����");
		t_input = new JTextField(15);

		// ������Ʈ�� ������ ����!!
		// ������(��)�� ����!!
		bt.addActionListener(this);
		t_input.addKeyListener(this);

		this.add(scroll);
		p_south.add(t_input);
		p_south.add(bt);
		this.add(p_south, BorderLayout.SOUTH);

		setBounds(100, 100, 300, 400);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		System.out.println("������?");
		// ChatB�� ChatC�� �����غ���!!
		// ������ ��õ�ϴ� ���!! Ŭ�������� �ҹ��ڷ�����!!
		// ã��, �����ϴµ� �ſ� ȿ�����̴�!!
		chatB = new ChatB();
		chatC = new ChatC();
		//ChatB���� �ʿ��� ������ ���Խ�������!!
		chatB.setChatA(this);
		chatB.setChatC(chatC);
		
		//ChatC���� �ʿ��� ������ ���Խ�������!!
		chatC.setChatA(this);
		chatC.setChatB(chatB);	
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void keyReleased(KeyEvent e) {
		/* ���͸� ġ��, �޼����� �ٸ�â���� ������ */
		int key = e.getKeyCode();
		if (key == KeyEvent.VK_ENTER) {
			String msg = t_input.getText();
			area.append(msg+"\n");
			chatB.area.append(msg+"\n");
			chatC.area.append(msg+"\n");
			t_input.setText("");
		}
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub

	}

	public static void main(String[] args) {
		new ChatA();
	}

}
