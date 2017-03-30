package com.ss.gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

//�߰� ��ư ������ ����, ���� ��ư ������ ��ü ������ �����.
public class ButtonCreator extends JFrame implements ActionListener{
	JPanel p_north, p_center;
	JButton bt_create, bt_color;
	int count=0;
	
	ArrayList<String>list=new ArrayList(); //�� ���� �迭!! ũ�⸦ ������� �ʾƵ� �ǰ�, ��ü���� �ٷ�
	/*
	 * ���ݱ��� ����ؿԴ� �迭�� �뷮�� �����͸�
	 * �����ְ� ó���Կ� �־ ��û�� �̵��� ��Դ�..
	 * ������ �ڹ�, c, c#�� ���� �������α׷������� 
	 	�迭 ������ �� ũ�⸦ �ݵ�� ����ؾ� �Ѵٴ� Ư¡+����� �ڷ��� �����ȴٴ� ���� ������ �������� ��������.
	 	�ڹٿ����� �뷮�� ��ü(�ڡڡڡ�)�� ó���ϴµ� ������ ���̺귯���� �����ϴµ�
	 	�̷��� ���̺귯���� ������ �÷��� �����ӿ��̶� �ϰ�, java.util ��Ű���� ���ִ�..
	 	
	 	�ڹ��� collection framework���� �����ϴ� ��ü�� �� ���� ����ϱ� ������
	 	��� ����Ѵٴ� ���� ��û�� ���̴�..
	 	������ ���� �׶����� ������ ���� �����ϸ� �ȴ�..
	 	
	 	����!! �迭���� �޸� �÷��� �����ӿ��� ����� �Ǵ� ���� ���� �繰�� ��ü�� �����ȴ�!!
	 	�迭�� ������, ��Ƽ� ó���ϴµ� �����ϴ�
	 	
	 	 ���� ���� ��=set����, ���� ����-list ����, map����
	 */
	JButton[] bts=new JButton[6];
	
	public ButtonCreator() {
		p_north=new JPanel();
		p_center=new JPanel();
		bt_create=new JButton("��ư�߰�");
		bt_color=new JButton("���󺯰�");
		
		p_north.add(bt_create);
		p_north.add(bt_color);
		add(p_north,BorderLayout.NORTH);
		add(p_center);
		
		//��ư�� ������ ����, �̺�Ʈ ����
		bt_create.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//��ư ����
				createButton();
				
			}
		});
		bt_color.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				//��� ��ư�� ������� ���� ����
				setColor();
				
			}
		});
	
		
		
		setSize(500,600);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);

	}
	
	//��ư ���� �޼���!!
	//�ǰ��Կ��� ������ �� ����
	//�̺�Ʈ�� �����Ͽ� ������ �ۼ��ϸ�
	//�̺�Ʈ ����� ���濡 ���� ������ �ջ�����ϱ�..
	public void createButton(){
		count++;
		JButton bt=new JButton(Integer.toString(count));
		
		//javascript�� push()�� ���� ����� �޼��� ȣ������!
		list.add(bt); //1�� �߰�!!
		System.out.println("������� ���� ����"+list.size());
		
		p_center.add(bt);
		p_center.updateUI(); //refresh
		
	}
	
	public void setColor(){
		for(int i=0; i<list.size(); i++){
			JButton bt=(JButton)list.get(i); //������Ʈ ������ �޾����Ƿ� �ٿ�ĳ����
			bt.setBackground(Color.GREEN);
			
		}
		
	}


	public static void main(String[] args) {
		new ButtonCreator();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
	
		
	}

}
