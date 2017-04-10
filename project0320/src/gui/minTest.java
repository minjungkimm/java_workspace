package gui;
import java.awt.*;
//import java.awt.Label;
// 다 완성하고 고치기
class minTest{
	public static void main(String[] args){
		Frame frame=new Frame();
		//프레임 생성
		//BorderLayout border=new BorderLayout();
		//frame.setLayout(border);
		//프레임 전체를 보더레이아웃으로 설정
		frame.setVisible(true);
		//보이게 처리
		frame.setSize(400,150);
		//버튼이 본래의 크기를 유지할 수 있는것은 FlowLayout 설정했기때문
		Button bt1=new Button("로그인");
		Button bt2=new Button("회원가입");		
		
		Panel p1=new Panel();
		p1.add(bt1);
		p1.add(bt2);

		frame.add(p1,BorderLayout.SOUTH);
		
		GridLayout grid=new GridLayout(2,6,50,10);

		TextField txt1=new TextField(20);
		TextField txt2=new TextField(20);
		
		txt2.setEchoChar('*');

		Panel p2=new Panel();
		
		Label lb1=new Label("ID");
		Label lb2=new Label("PW");

		//lb1.add("ID");
		//lb2.add("PW");

		p2.add(lb1);
		p2.add(txt1);
		p2.add(lb2);
		p2.add(txt2);
		
		p2.setLayout(grid);
		
		
		frame.add(p2,BorderLayout.CENTER);

		

	}
}
