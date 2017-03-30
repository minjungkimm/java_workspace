package com.ss.gui;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class Enter extends JFrame{
	JTextField t_input;
	JTextArea area;
	JButton bt;
	
	public Enter(){
		setLayout(new FlowLayout());
		
		t_input=new JTextField(20);
		area=new  JTextArea(30,40);
		bt= new JButton("나버튼");
		//언제나 괄호는 안에서부터 실행하기때문에
		//add(t_input=new JTextField(20);) 가능하긴한데 비추..
		add(t_input);
		add(area);
		add(bt);
		
		//.java 파일을 만들기 싫은 경우, 클래스 코드 자체를
		//메서드의 인수나, 클래스의 멤버변수등에
		//바로 대입할 수도 있다..!!!
		//언제쓰는지도 알려주실거임!!! 
		// - 내부 익명클래스(Anonymous inner class)를 사용하는 이유는 ?
		//.java vs 내부익명 -> 코드의재사용 vs 일회용(재사용가능성x)
		//.java를 물리적으로 원본소스까지 작성하는 이유는?
		//코드의 재사용성에 있다!! 하지만 GUI 프로그래밍 등에서 특히
		//이벤트 구현코드는 특정 클래스에 종속적이기 때문에!!
		//재사용성이 상당히 떨어진다!! 이경우!
		//개발자가 .java 까지 만들어가며, 인수를 통해 객체를 넘겨받는 수고를 해야할까?
		//해답 ) 일회성 코드로 가자!! 즉 현재 클래스에
		//일부러 클래스를 존재시키자!!
		//.class 객체의 재사용 , 거푸집 .java 코드의 재사용!! 
		//엔터어댑터를 뉴한것//익명클래스이면서,내부클래스
																	//내부익명클래스!!
		//앞에있는 부모클래스는 추상클래스임에도 불구하고 new 에왓지만
		//new는 실제로는 뒤에있는 자식클래스를 한것!!
		t_input.addKeyListener(new KeyAdapter(){
										//부모클래스 , 뒤에는 바로 자식클래스넣는다
			public void keyReleased(KeyEvent e) {
				//내꺼아닌 area에 t_input의 입력한 문자열 출력
				if(e.getKeyCode()==KeyEvent.VK_ENTER){
					String msg=t_input.getText();
					area.append(msg+"\n");
					t_input.setText("");
				}
			}	
		});
		//내부익명 클래스의 장점
		//내부익명 메서드 코드안에서 자신을 포함한 
		//외부클래스의 멤버변수를 내것처럼 쓸수있다!!
		//자격증시험문제
		//내부익명클래스의 사용으로 얻는 이득은 멤버변수를
		//공유할 수 있다는 것인데, 만일 개발자가 지역변수를 내부익명 내에서
		//사용하고자 할때는 그 지역변수는 final 로 선언되어 있어야 한다..
		int a=9;
		bt.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("나눌럿냐"); 
				
			}
		});
		
		//t_input 과 리스너와의 연결 //인수가 있다면 값을 받아줘야해!! 
		//this.addKeyListener(new EnterAdapter(area,t_input));
		
		
		setVisible(true);
		setSize(300,400);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		
	}	

	public static void main(String[] args) {
		new Enter();

	}

}
