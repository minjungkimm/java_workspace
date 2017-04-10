package gui;
import java.awt.*;
import javax.swing.JPanel;
import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;

//액션리스너 기능추가!!!-> 하면 not override 뜬다 추상메서드 완성하라!!
class MyFrame2 extends JFrame implements ActionListener , KeyListener{
					/*is a관계*/        /*is a 관계*/
	//멤버변수 has a 관계
	JPanel p_north;
	JPanel p_west;
	JButton bt;
	JTextArea ta;
	JTextField tf; //t_input

	public MyFrame2(){
	//생성자메서드 has a 관계의 완성
	bt=new JButton("클릭");
	ta=new JTextArea(20,30);
	tf=new JTextField(20);
	p_north=new JPanel();
	p_west=new JPanel();
	
	p_north.add(ta);
	p_west.add(bt);
	
	add(p_north,BorderLayout.NORTH);
	add(p_west,BorderLayout.WEST);
	add(ta);
	add(tf);

	//누굴대상으로 이작업을 수행할것인가? 버튼이요!!
	//마치 js에서의 addEventListener()
	//와 같은 작업으로 간주하면 된다
	//버튼과 리스너와의 연결//인수안에는 리스너인객체가온다!!
	bt.addActionListener(this); 
	//윈도우//내가리스너이다!!

	setVisible(true);
	setSize(300,400);
	setDefaultCloseOperation(EXIT_ON_CLOSE);

	
	}
	
	//ActionListener는 사용자가 일으킨 이벤트중
	//ActionEvent 만을 감지하고, 그 이벤트가
	//감지되었을 때 어떤 처리를 할지는 개발자가
	//결정해야 하기 때문에, ActionListener 는
	//내용을 확정지을수 없는 추상메서드를 가진
	//객체이어야 하고, 이 인터페이스를 상속받는 자가
	//어떤 클래스의 이미 자식일 수도
	//있으므로, sun에서는 추상클래스가 아닌
	//인터페이스로 제공함으로서 다중상속의
	//문제를 피해갈 수 있도록 했다!!!
									//클릭하면 인수값에 들어온다
	//누굴대상으로 이작업을 수행할것인가? 버튼이요!!
	public void actionPerformed(ActionEvent e){
		System.out.println("나 눌렀어?");
	}
	
	public static void main(String[] args){
		new MyFrame2();
	
	}
}
