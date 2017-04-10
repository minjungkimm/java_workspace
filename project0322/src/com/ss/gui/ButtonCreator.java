package com.ss.gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

//추가 버튼 누르면 생성, 색상 버튼 누르면 전체 색상이 적용됨.
public class ButtonCreator extends JFrame implements ActionListener{
	JPanel p_north, p_center;
	JButton bt_create, bt_color;
	int count=0;
	
	ArrayList list=new ArrayList(); //얘 완전 배열!! 크기를 명시하지 않아도 되고, 객체만을 다룸
	/*
	 * 지금까지 사용해왔던 배열은 대량의 데이터를
	 * 순서있게 처리함에 있어서 엄청난 이득을 줘왔다..
	 * 하지만 자바, c, c#과 같은 응용프로그램에서는 
	 	배열 생성시 그 크기를 반드시 명시해야 한다는 특징+선언시 자료형 결정된다는 점은 오히려 유연성이 떨어진다.
	 	자바에서는 대량의 객체(★★★★)를 처리하는데 유용한 라이브러리를 제공하는데
	 	이러한 라이브러리를 가리켜 컬렉션 프레임웍이라 하고, java.util 패키지에 모여있다..
	 	
	 	자바의 collection framework에서 제공하는 객체는 그 수가 상당하기 때문에
	 	모두 사용한다는 것은 멍청한 짓이다..
	 	업무에 따라 그때마다 적절한 것을 선택하면 된다..
	 	
	 	주의!! 배열과는 달리 컬렉션 프레임웍의 대상이 되는 것은 오직 사물인 객체에 한정된다!!
	 	배열과 공통점, 모아서 처리하는데 유용하다
	 	
	 	 순서 없는 것=set유형, 순서 있음-list 유형, map유형
	 */
	JButton[] bts=new JButton[6];
	
	public ButtonCreator() {
		p_north=new JPanel();
		p_center=new JPanel();
		bt_create=new JButton("버튼추가");
		bt_color=new JButton("색상변경");
		
		p_north.add(bt_create);
		p_north.add(bt_color);
		add(p_north,BorderLayout.NORTH);
		add(p_center);
		
		//버튼과 리스너 연결, 이벤트 구현
		bt_create.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//버튼 생성
				createButton();
				
			}
		});
		bt_color.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				//모든 버튼을 대상으로 배경색 변경
				setColor();
				
			}
		});
	
		
		
		setSize(500,600);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);

	}
	
	//버튼 생성 메서드!!
	//피곤함에도 별도로 뺀 이유
	//이벤트에 의존하여 로직을 작성하면
	//이벤트 방식의 변경에 의해 로직도 손상받으니까..
	public void createButton(){
		count++;
		JButton bt=new JButton(Integer.toString(count));
		
		//javascript의 push()와 완전 비슷한 메서드 호출하자!
		list.add(bt); //1건 추가!!
		System.out.println("현재까지 누적 수는"+list.size());
		
		p_center.add(bt);
		p_center.updateUI(); //refresh
		
	}
	
	public void setColor(){
		for(int i=0; i<list.size(); i++){
			JButton bt=(JButton)list.get(i); //오브젝트 형으로 받았으므로 다운캐스팅
			bt.setBackground(Color.GREEN);
			
		}
		
	}


	public static void main(String[] args) {
		new ButtonCreator();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}

}
