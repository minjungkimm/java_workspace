/*양자 채팅을 구현한다!!
**이벤트 구현의 3단계
1. 적절한 리스너를 선택하여 구현(implements)한다.
2. 추상 메서드 재정의
3. 리스너와 컴포넌트와의 연결
*/
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


class ChatA extends JFrame implements ActionListener,KeyListener{
	//패널 1개 - 버튼 , 텍스트에리아
	//위에는 스크롤과 텍스트필드
	JTextArea area;
	JScrollPane scroll;
	JPanel p_south;
	JTextField t_input;
	JButton bt_open;
	ChatB chatB; //chatB도 has a 관계
	ChatC chatC;
	
	public ChatA(){

		area=new JTextArea(20,30);
		scroll=new JScrollPane(area);
		p_south=new JPanel();
		t_input=new JTextField(20);
		bt_open=new JButton("열기");
		
		//하단 패널에 버튼과 텍스트입력창 붙히기
		p_south.add(t_input);
		p_south.add(bt_open);
		//하단패널을 프레임에 붙히자
		add(p_south,BorderLayout.SOUTH);
		
		add(scroll);
		
		//대상 컴포넌트와 리스너의 연결!!
		//보여주기 직전에 모든게 준비된 상태에서 추가
		bt_open.addActionListener(this);

		//키리스너와의 연결//나 자체가 귀가 여러개 달린 괴물!!
		t_input.addKeyListener(this);

		setVisible(true);
		setBounds(100,100,400,600);
		setDefaultCloseOperation(EXIT_ON_CLOSE);	
		
	}
	
	public void actionPerformed(ActionEvent e){
		//ChatB 인스턴스 만들기
		//멤버변수 선언 햇으니 맨앞 ChatB날리기 
		chatB= new ChatB(this);
		chatC= new ChatC(this);
		t_input.requestFocus(); //커서 올리기!!
		//setRequestFocus 메서드를 통해 바로입력가능하게
		//setInable
	}
	
	public void keyPressed(KeyEvent e){
	
	}

	public void keyReleased(KeyEvent e){
		//e에는 이벤트로인한 수많은정보가 담겨있으므로,
		//그중에 (선택하여)골라서 담아야 한다
		//int key=e.getKeyCode();
		//System.out.println(key); 누르는 키의 값 출력
		//상수는 Field 보면된다..
		/*
		key 값이 엔터를 쳤을 때 10인걸 테스트를 통해,
		우리는 알게되었다. 하지만, 우리는 인간이기 때문에
		10보다는 ENTER 라는 단어가 더 익숙하다.
		이러한, 이유로 상수가 주로 사용된다.
		즉 상수란, 그 값이 변하지 않는 특징만 있는 게
		아니라, 프로그래머에게 친숙한 단어의 의미를 
		부여하는 목적이 아주 크다!!
		*/
		int key=e.getKeyCode();
		if(key==KeyEvent.VK_ENTER){
			//System.out.println("엔터쳤어?");
			//나의 AREA에 t_input의 값을 출력하고
			//\n 은 기능적인 줄바꿈!!!
			String msg=t_input.getText();
			area.append(msg+"\n");
			//찌꺼기 날리기
			t_input.setText("");
			//ChatB의 area에도 t_input 값을 출력한다.
			chatB.area.append(msg+"\n");
		}
		
	}
		
	public void keyTyped(KeyEvent e){
	
	}
	
	public static void main(String[] args){
		new ChatA();
	}
}
