package com.ss.gui;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class MyAdapter extends WindowAdapter{
	//������ ������� �ڽ����� ������!!
	//�߻�Ŭ����������, ���������ϴ� �޼��尡 ����!! 
	//�������̵�(�츮�� ����Ͱ� ����7���� �����ִ� ���̴�, ���߿��� ���׷��̵� �ؼ� ����Ұ͸� �������̵�) �ҷ���!!
	//�׸��� �극�̽� �ϼ����ѳ����Ƿ�, ��� ������������ �ʰ�
	//�ʿ��� �޼��常 �������̵� ����!! 

	/*����Ͱ� �̹� 7���� ��� �������̵� �߱� ������
	 �츮�� ���������� ���� �ʴ� �����̴�
	 ���߿��� ���ϴ� �޼��带 �� �������̵�����!!!*/
	public void windowClosing(WindowEvent e) {
		System.exit(0);//���α׷� ����
	}		
}
