/*
자바언어로도 GUI(Graphic User Interface):
(그래픽적으로 어플리케이션을 사용할 수 있도록
제공하는 환경!!)
어플리케이션을 제작할 수 있다.
그리고 자바를 가장 잘할 수 있는 기회, 찰나이다.

모든 그래픽 프로그램은 윈도우상에서 실행되므로,
자바에서 윈도우를 띄우는 법을 배우자!!
*/
package gui;

import java.awt.Frame;
import java.awt.Button;
import java.awt.TextField;
import java.awt.FlowLayout; //배치관리자
import java.awt.Color;
import java.awt.Checkbox;
import java.awt.Choice;
import java.awt.CheckboxGroup;
import java.awt.TextArea;

class WinTest{
	public static void main(String[] args){
		Frame frame=new Frame();
		//컴포넌트가 너무 대왕으로 만들어지므로
		//이 문제를 해결하기 위해 레이아웃을
		//적용한다.. (이따가 배울거임)
		FlowLayout flow=new FlowLayout();
		frame.setLayout(flow);

		//컴파일해서 실행하면 cmd 에 아무것도 나오지않음
		//프레임은 디폴트로 보이지 않는 속성가짐
		//따라서 보이게 처리하자!!
		frame.setVisible(true);
		//창이나오긴 했지만 크기를 조정해줘야함
		frame.setSize(800,800);
		frame.setTitle("나의윈도우");

		Button bt; //객체라서 default 값은 null
						//메모리올린다고 하면 생성자보기!!
		bt=new Button("왕버튼");
		
		frame.add(bt);

		//텍스트 입력박스 생성         //글자칸수
		TextField txt=new TextField(20);

		frame.add(txt);

		//윈도우에 색상 주자!!
		//난생 처음보는 객체에 대한 대처법
		/*
		자바의 모든 객체는 결국 일반,추상,인터페이스
		중 하나이다.
		따라서, 처음보는 객체라 할지라도 결국 메모리에
		올려서 사용하라고 준것 이기 때문에..
		셋 중 어느 케이스에 속하는지 먼저 조사한 후 
		그 객체에 맞게 메모리에 올리자!!
		1) 일반 - new 하자
		2) 추상 - 자식을 new 하자
		3) 인터페이스 - implements 한 자식을 new 하자
		근데, 내 경험상 2,3번은 꼭 자식들을 new 하지 않더라도
		생성하는 방법을 api 에서 제공하는 경우가 더 많다...
		*/
		Color c=new Color(0,0,255);
		frame.setBackground(c);

		//체크박스 생성
		Checkbox ch1=new Checkbox("여행");
		Checkbox ch2=new Checkbox("게임");
		Checkbox ch3=new Checkbox("독서");
		Checkbox ch4=new Checkbox("운동");
		
		frame.add(ch1);
		frame.add(ch2);
		frame.add(ch3);
		frame.add(ch4);

		//html의 select 를 자바에서는 Choice 라 한다
		//사과 딸기 바나나

		Choice choice=new Choice();

		choice.add("사과"); 

		frame.add(choice); //프레임에 부착!!

		//radio box 이용하여 남녀를 체크한다!!
		//주의) java에서는 Radio 말 자체가 없다!!
		//Checkbox를 그룹화 시켜야한다..

		CheckboxGroup cbg=new CheckboxGroup();

		Checkbox c1=new Checkbox("남",cbg,false);
		Checkbox c2=new Checkbox("여",cbg,true);
		
		frame.add(c1);
		frame.add(c2);

		//TextArea 동일
		
		TextArea txa=new TextArea("Hello",5,40);
		frame.add(txa);
	}
}
