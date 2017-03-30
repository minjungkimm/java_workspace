package com.ss.gui;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class Enter extends JFrame{
	JTextField t_input;
	JTextArea area;
	JButton bt;
	
	public Enter(){
		setLayout(new FlowLayout());
		
		t_input=new JTextField(20);
		area=new  JTextArea(30,40);
		bt= new JButton("����ư");
		//������ ��ȣ�� �ȿ������� �����ϱ⶧����
		//add(t_input=new JTextField(20);) �����ϱ��ѵ� ����..
		add(t_input);
		add(area);
		add(bt);
		
		//.java ������ ����� ���� ���, Ŭ���� �ڵ� ��ü��
		//�޼����� �μ���, Ŭ������ ��������
		//�ٷ� ������ ���� �ִ�..!!!
		//������������ �˷��ֽǰ���!!! 
		// - ���� �͸�Ŭ����(Anonymous inner class)�� ����ϴ� ������ ?
		//.java vs �����͸� -> �ڵ������� vs ��ȸ��(���밡�ɼ�x)
		//.java�� ���������� �����ҽ����� �ۼ��ϴ� ������?
		//�ڵ��� ���뼺�� �ִ�!! ������ GUI ���α׷��� ��� Ư��
		//�̺�Ʈ �����ڵ�� Ư�� Ŭ������ �������̱� ������!!
		//���뼺�� ����� ��������!! �̰��!
		//�����ڰ� .java ���� ������, �μ��� ���� ��ü�� �Ѱܹ޴� ���� �ؾ��ұ�?
		//�ش� ) ��ȸ�� �ڵ�� ����!! �� ���� Ŭ������
		//�Ϻη� Ŭ������ �����Ű��!!
		//.class ��ü�� ���� , ��Ǫ�� .java �ڵ��� ����!! 
		//���;���͸� ���Ѱ�//�͸�Ŭ�����̸鼭,����Ŭ����
																	//�����͸�Ŭ����!!
		//�տ��ִ� �θ�Ŭ������ �߻�Ŭ�����ӿ��� �ұ��ϰ� new ��������
		//new�� �����δ� �ڿ��ִ� �ڽ�Ŭ������ �Ѱ�!!
		t_input.addKeyListener(new KeyAdapter(){
										//�θ�Ŭ���� , �ڿ��� �ٷ� �ڽ�Ŭ�����ִ´�
			public void keyReleased(KeyEvent e) {
				//�����ƴ� area�� t_input�� �Է��� ���ڿ� ���
				if(e.getKeyCode()==KeyEvent.VK_ENTER){
					String msg=t_input.getText();
					area.append(msg+"\n");
					t_input.setText("");
				}
			}	
		});
		//�����͸� Ŭ������ ����
		//�����͸� �޼��� �ڵ�ȿ��� �ڽ��� ������ 
		//�ܺ�Ŭ������ ��������� ����ó�� �����ִ�!!
		//�ڰ������蹮��
		//�����͸�Ŭ������ ������� ��� �̵��� ���������
		//������ �� �ִٴ� ���ε�, ���� �����ڰ� ���������� �����͸� ������
		//����ϰ��� �Ҷ��� �� ���������� final �� ����Ǿ� �־�� �Ѵ�..
		int a=9;
		bt.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("��������"); 
				
			}
		});
		
		//t_input �� �����ʿ��� ���� //�μ��� �ִٸ� ���� �޾������!! 
		//this.addKeyListener(new EnterAdapter(area,t_input));
		
		
		setVisible(true);
		setSize(300,400);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		
	}	

	public static void main(String[] args) {
		new Enter();

	}

}
