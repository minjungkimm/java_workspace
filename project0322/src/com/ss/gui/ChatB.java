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
	private ChatA chatA; //현재 null 이다.. //우리가 나오길 바라는 A는 기존의 A..
	private ChatC chatC; //앞으로 필요한 ,즉 사용할 객체가 있다면 has a 관계로 보유하자!!
	
	public ChatB() {
		area = new JTextArea();
		scroll = new JScrollPane();
		p_south = new JPanel();
		bt = new JButton("열기");
		t_input = new JTextField(15);
		//new 하면 안되는 이유??
		//새로운 ChatA가 아니라, 나를 태어나게 했던
		//그 ChatA의 주소값을 이용해야 한다..
		//chatA = new ChatA();
		//변수는 데이터를 가지고 있으므로, 은닉화 되고 메서드로 컨트롤 될것이다..
		//주소값을 넘겨야 할때는 변수가 아니라 메서드를 통해.. 
		
		this.add(scroll);
		p_south.add(t_input);
		p_south.add(bt);
		this.add(p_south,BorderLayout.SOUTH);
		//컴포넌트와 연결
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
		//ChatA,ChatC 에게 메세지 보내기!!
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
	
	//외부의 어떤객체가 , 나에게 데이터를 주입시켜 
	//줄수 있는 setter 를 준비하자!!
	public void setChatA(ChatA chatA){
		this.chatA=chatA;
	}
	public void setChatC(ChatC chatC){
		this.chatC=chatC;
	}
	
}

