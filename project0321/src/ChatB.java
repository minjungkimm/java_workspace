/*양자 채팅을 구현한다!!*/
package chat;

import java.awt.*;
import javax.swing.JFrame;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;



class ChatB extends JFrame implements ActionListener,KeyListener{
	//패널 1개 - 버튼 , 텍스트에리아
	//위에는 스크롤과 텍스트필드
	JTextArea area;
	JScrollPane scroll;
	JPanel p_south;
	JTextField t_input;
	ChatA chatA;
	
	public ChatB(ChatA a){

		area=new JTextArea(20,30);
		scroll=new JScrollPane(area);
		p_south=new JPanel();
		t_input=new JTextField(20);
		chatA=a;
		
		//하단 패널에 버튼과 텍스트입력창 붙히기
		p_south.add(t_input);
		//하단패널을 프레임에 붙히자
		add(p_south,BorderLayout.SOUTH);
		
		add(scroll);
		//모든대상의 준비가 완료된 후 이벤트 추가
		t_input.addKeyListener(this);

		setVisible(true);
		setBounds(400,100,400,600);
		//디폴드클로즈오퍼레이션 상대방이 꺼버리면 다같이 프로그램
		//꺼질것을 예방해서..
	}

	public void KeyPressed(KeyEvent e){
	
	}
	
	public void KeyReleased(KeyEvent e){
		//e에서 keyCode 값만 선택
		ChatA chatA=new ChatA();
		int key=e.getKeyCode();
		if(key==KeyEvent.VK_ENTER){
			//나의textarea에 input 값을 출력하자
			//msg는 텍스트인풋값을 가져온값
			String msg=t_input.getText();
			//textarea에갖다붙힌다.(텍스트인풋값을)
			chatA.area.append(msg+"\n");
		}
	}

	public void KeyTyped(KeyEvent e){
	
	}
	//남이 호출할 때 태어나므로, 메인실행부 제거
}
