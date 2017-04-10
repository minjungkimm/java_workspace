package gui;

import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JPanel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;
import java.awt.*;


//속상하지 않게.. 현실반영되게 코딩
//가로 300 , 세로 400
//보이는 것은 swing
//안보이는 것은 awt
//총 4개의 컴퍼넌트
//내가 작성한 클래스가 윈도우가 되어버렸다.. 내가 윈도우야!!
//객체 중심 관점
class MyFrame extends JFrame implements ActionListener , KeyListener{
		//멤버변수 선언하면, has a 관계
		JPanel p_north;
		JButton bt;
		JTextArea area;
		JTextField t_input;

	//이 윈도우가 태어날 때 각종 부품들도
	//같이 태어난다!! 물건이 만들어질때 부품이 붙어나와야 하니깐!!
	//멤버메서드
    public MyFrame(){
		p_north=new JPanel();
		bt=new JButton("클릭");
		area=new JTextArea(20,30);
		t_input=new JTextField(10);
		
		
		p_north.add(bt);
		p_north.add(t_input);

		//패널을 나의 북쪽에 붙이자!!
		add(p_north,BorderLayout.NORTH);
		add(area);

		//누굴대상으로 이작업을 수행할것인가? 버튼이요!!
		//마치 js에서의 addEventListener()
		//와 같은 작업으로 간주하면 된다
		//버튼과 리스너와의 연결//인수안에는 리스너인객체가온다!!
		bt.addActionListener(this);
		t_input.addKeyListener(this); 
		//윈도우//내가리스너이다!!

		//this. 가 사실상 숨겨져있다.. 
		setVisible(true);
		setSize(300,400);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	//KeyListener 의 추상메서드를 오버라이드하자

	//키 누를때
	public void keyPressed(KeyEvent e){
		System.out.println("keyPressed");
	}
	//키를 눌렀다 떼어냈을 때
	public void keyReleased(KeyEvent e){
		System.out.println("keyReleased");
	}
	//타자를 칠때
	public void keyTyped(KeyEvent e){
		System.out.println("keyTyped");
	}

	public void actionPerformed(ActionEvent e){
		System.out.println("나 눌렀어?");
	}

	public static void main(String[] args){
		new MyFrame();

	}
}
