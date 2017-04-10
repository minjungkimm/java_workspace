/*이벤트 프로그래밍시 리스너가 인터페이스이기 때문에
 단 하나라도 메서드를 오버라이드 하지 않으면
 구현강제의 약속을 어기게 되어, 컴파일 에러가 발생한다..
 이 원칙은 특히나 추상메서드를 많이 보유한 인터페이스일
 경우 너무 비효율적이고 피곤하다...
 해결책) 개발자를 대신하여 이미 리스너의 메서드들을
 재정의해놓은 객체들을 가리켜 "어댑터"라 한다!!!
 BUT - 어댑터는 무조건 지원되는 게 아니라, 내 경험상
 보통 3개 이상의 추상메서드를 보유한 리스너라면
 어댑터 지원을 일단 의심해봐야 한다....*/

package com.ss.gui;

import java.awt.FlowLayout;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.JButton;
import javax.swing.JFrame;

/*윈도우 이벤트를 구현해본다*/
public class WindowTest extends JFrame{
	//윈도우리스너를 나한테 붙혔다..
	//메인메서드 비어있다 창을 만들어서 순서대로 찍혀나오게 만들어라..
	JButton bt;
	//생성자메서드
	public WindowTest(){
		//닫는오퍼레이션은 윈도우창 닫힐때 메서드 존재하므로 안해도됨
		//윈도우리스너의 주체는 윈도우 , 나자신
		bt=new JButton("나버튼");
		setLayout(new FlowLayout());
		
		add(bt);
		//추상클래스는 new 안되니깐  윈도우어댑터 그 자체를  넣을수없다..
		//그러나 윈도우어댑터를 오버라이딩 한 마이 어댑터를 넣을수있다..
		this.addWindowListener(new MyAdapter());
		setVisible(true);
		setSize(300, 400);
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new WindowTest();
	}
	
}
