package com.ss.gui;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JTextArea;
import javax.swing.JTextField;

public class EnterAdapter extends KeyAdapter{
	JTextField t_input; //������ ���� ����ؾ� �ϱ� ������, ���޹޾ƾ� �Ѵ� - �޼��带 �̿�����!!
	JTextArea area; //������ null �ƴϰ��ؾ��� ����!!!
	
	//�μ��� �������� �극�̽��� ������ �״´�.. ������ ��������� ������!!
	public EnterAdapter(JTextArea area,JTextField t_input){
		this.area=area;
		this.t_input=t_input;
	}
	
	@Override
	public void keyReleased(KeyEvent e) {
		//�����ƴ� area�� t_input�� �Է��� ���ڿ� ���
		if(e.getKeyCode()==KeyEvent.VK_ENTER){
			String msg=t_input.getText();
			area.append(msg+"\n");
			t_input.setText("");
		}
	}	
}
