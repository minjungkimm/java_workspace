package game.word;

import java.awt.FlowLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;

//이 윈도우는 크기가 결정되어 있지 않아야 한다
//왜? 윈도우 안에 들어오게 될 패널이 
//그 크기를 결정하게 되므로..
//로그인 기능일 때는 작게 , 게임 메인 화면에서는 크게..
//게임이 움직이는 것 1. 물리량 변화 2. 반영
public class GameWindow extends JFrame{
	LoginForm loginform;
	GamePanel gamePanel; //이제 윈도우는 2페이지를 다 소유하고 있다.
	
	JPanel[] page = new JPanel[2]; //2페이지를 묶어놓을 패널 배열
	
	public GameWindow() {
		
		setLayout(new FlowLayout());

		page[0] = new LoginForm(this); //배열에 담자
		page[1] = new GamePanel(this); //배열에 담자
		
		add(page[0]);
		add(page[1]);
		
		setPage(0);

		setVisible(true);	
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	
	//윈도우 안에 어떤 패널이 올지 결정해주는 메서드를 정의하자!!
	//인수로 원하는 패널을 넣는다
	public void setPage(int index){
		for(int i=0; i<page.length; i++){
			if(i==index){
				page[i].setVisible(true); //인수로 받는 index
				//setSize 로 윈도우 크기를 설정하지 않았기 때문에 화면이 최소로 나온다
			}else{page[i].setVisible(false);}
		}
		pack(); //내용물의 크기만큼 윈도우 크기를 설정하자!
		setLocationRelativeTo(null);//화면중앙으로 계속해서 셋팅되게.. 로그인된후에는 먹히지 않는 현상 때메
	}
	
	public static void main(String[] args) {
		new GameWindow();

	}
}
