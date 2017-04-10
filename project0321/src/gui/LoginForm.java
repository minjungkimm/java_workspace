/*로그인 폼 만들기*/
package gui;
import java.awt.*;

class LoginForm{
	public static void main(String[] args){
		Frame frame; //지역변수는 개발자가 초기화 하지않으면,
		//자동으로 초기화되지 않으므로, 아래의 객체들에 대한
		//레퍼런스 변수엔 아무런 값도 들어있지 않다..
		//=null 넣어줘야 한다.. FM) Frame frame=null;
		Panel p_center,p_south,p_container; //의미부여한 네이밍이 필요하다

		Label la_id,la_pw; 

		TextField t_id,t_pw;

		Button bt_login,bt_regist;

		frame=new Frame("로그인 폼");
		p_center = new Panel();
		p_south = new Panel();
		//윈도우 대신에 패널을 가질 container!!
		p_container = new Panel();
		la_id = new Label("ID");
		la_pw = new Label("Password");
		t_id=new TextField(20);
		t_pw=new TextField(20);
		bt_login=new Button("로그인");
		bt_regist=new Button("회원가입");

		//센터 영역 조합하기
		//붙히기 전에 레이아웃을 먼저 결정해야 한다!!
		//Panel 디폴트가 FlowLayout 이므로,
		//GridLayout 으로 변경하자!!\
		p_center.setLayout(new GridLayout(2,2));
		p_center.add(la_id); //1행 1열
		p_center.add(t_id); //1행 2열

		p_center.add(la_pw); //2행 1열
		p_center.add(t_pw); //2행 2열

		//남쪽 패널에 버튼 부착!!
		p_south.add(bt_login);
		p_south.add(bt_regist);
		
		//프레임 대신, BorderLayout 을 적용할 컨테이너
		p_container.setLayout(new BorderLayout());

		//패널들을 전체 프레임에 붙히자!!
						//클래스. 상수 가능하면 static 선언되어있다는 증거
		p_container.add(p_center,BorderLayout.CENTER);
		p_container.add(p_south,BorderLayout.SOUTH);

		//윈도우의 레이아웃을 FlowLayout 으로 변환
		frame.setLayout(new FlowLayout());
		frame.add(p_container);
		
		//윈도우 크기 및 보이기 설정
		frame.setSize(300,150);
		frame.setVisible(true);
	}	
}
