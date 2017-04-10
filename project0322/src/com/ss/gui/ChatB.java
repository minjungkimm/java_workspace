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

public class ChatB extends JFrame implements KeyListener {
	JTextArea area;
	JScrollPane scroll;
	JPanel p_south;
	JTextField t_input;
	JButton bt; 
	private ChatA chatA; //���� null �̴�.. //�츮�� ������ �ٶ�� A�� ������ A..
	private ChatC chatC; //������ �ʿ��� ,�� ����� ��ü�� �ִٸ� has a ����� ��������!!
	
	public ChatB() {
		area = new JTextArea();
		scroll = new JScrollPane();
		p_south = new JPanel();
		bt = new JButton("����");
		t_input = new JTextField(15);
		//new �ϸ� �ȵǴ� ����??
		//���ο� ChatA�� �ƴ϶�, ���� �¾�� �ߴ�
		//�� ChatA�� �ּҰ��� �̿��ؾ� �Ѵ�..
		//chatA = new ChatA();
		//������ �����͸� ������ �����Ƿ�, ����ȭ �ǰ� �޼���� ��Ʈ�� �ɰ��̴�..
		//�ּҰ��� �Ѱܾ� �Ҷ��� ������ �ƴ϶� �޼��带 ����.. 
		
		this.add(scroll);
		p_south.add(t_input);
		p_south.add(bt);
		this.add(p_south,BorderLayout.SOUTH);
		//������Ʈ�� ����
		t_input.addKeyListener(this);
		
		setBounds(400,100,300,400);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		//ChatA,ChatC ���� �޼��� ������!!
		int key = e.getKeyCode();
		if(key ==KeyEvent.VK_ENTER){
			String msg=t_input.getText();
			area.append(msg+"\n");
			chatA.area.append(msg+"\n");
			chatC.area.append(msg+"\n");
			t_input.setText("");
		}
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	//�ܺ��� ���ü�� , ������ �����͸� ���Խ��� 
	//�ټ� �ִ� setter �� �غ�����!!
	public void setChatA(ChatA chatA){
		this.chatA=chatA;
	}
	public void setChatC(ChatC chatC){
		this.chatC=chatC;
	}
	
}

