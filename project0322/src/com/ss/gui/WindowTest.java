/*�̺�Ʈ ���α׷��ֽ� �����ʰ� �������̽��̱� ������
 �� �ϳ��� �޼��带 �������̵� ���� ������
 ���������� ����� ���� �Ǿ�, ������ ������ �߻��Ѵ�..
 �� ��Ģ�� Ư���� �߻�޼��带 ���� ������ �������̽���
 ��� �ʹ� ��ȿ�����̰� �ǰ��ϴ�...
 �ذ�å) �����ڸ� ����Ͽ� �̹� �������� �޼������
 �������س��� ��ü���� ������ "�����"�� �Ѵ�!!!
 BUT - ����ʹ� ������ �����Ǵ� �� �ƴ϶�, �� �����
 ���� 3�� �̻��� �߻�޼��带 ������ �����ʶ��
 ����� ������ �ϴ� �ǽ��غ��� �Ѵ�....*/

package com.ss.gui;

import java.awt.FlowLayout;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.JButton;
import javax.swing.JFrame;

/*������ �̺�Ʈ�� �����غ���*/
public class WindowTest extends JFrame{
	//�����츮���ʸ� ������ ������..
	//���θ޼��� ����ִ� â�� ���� ������� ���������� ������..
	JButton bt;
	//�����ڸ޼���
	public WindowTest(){
		//�ݴ¿��۷��̼��� ������â ������ �޼��� �����ϹǷ� ���ص���
		//�����츮������ ��ü�� ������ , ���ڽ�
		bt=new JButton("����ư");
		setLayout(new FlowLayout());
		
		add(bt);
		//�߻�Ŭ������ new �ȵǴϱ�  ���������� �� ��ü��  ����������..
		//�׷��� ���������͸� �������̵� �� ���� ����͸� �������ִ�..
		this.addWindowListener(new MyAdapter());
		setVisible(true);
		setSize(300, 400);
	}
	
	public static void main(String[] args) {
	
		new WindowTest();
	}
	
}
