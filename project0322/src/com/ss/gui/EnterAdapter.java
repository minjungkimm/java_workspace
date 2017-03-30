package com.ss.gui;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JTextArea;
import javax.swing.JTextField;

public class EnterAdapter extends KeyAdapter{
	JTextField t_input; //기존의 것을 사용해야 하기 때문에, 전달받아야 한다 - 메서드를 이용하자!!
	JTextArea area; //쓰려면 null 아니게해야지 얻어와!!!
	
	//인수로 받은것은 브레이스가 끝나면 죽는다.. 그전에 멤버변수로 빼내자!!
	public EnterAdapter(JTextArea area,JTextField t_input){
		this.area=area;
		this.t_input=t_input;
	}
	
	@Override
	public void keyReleased(KeyEvent e) {
		//내꺼아닌 area에 t_input의 입력한 문자열 출력
		if(e.getKeyCode()==KeyEvent.VK_ENTER){
			String msg=t_input.getText();
			area.append(msg+"\n");
			t_input.setText("");
		}
	}	
}
