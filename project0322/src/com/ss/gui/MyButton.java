package com.ss.gui;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class MyButton extends JFrame implements ActionListener {
	JButton bt_create;
	JButton bt_color;
	JPanel p_north;
	int count=0;
	
	public MyButton(){
		bt_create=new JButton("��ư�߰�");
		bt_color=new JButton("��ư����");
		p_north=new JPanel();
		p_center=new JPanel();
		
		p.add(bt_create);
		p.add(bt_color);
		add(p_north,BorderLayout.NORTH);
		
		//�������ư�߰�//
		bt_create.addActionListener(new ActionListener() {
			
			//�̺�Ʈ ����!!
			public void actionPerformed(ActionEvent e) {
				//��ư����!!
				createButton();
				
			}
		});
		
		//��ư���� �޼���!!
		//�ǰ��Կ���, ������ �� ������?
		//�̺�Ʈ�� �����Ͽ� ������ �ۼ��ϸ� , �̺�Ʈ ����� ���濡 ����
		//������ �ջ�!! �����ϱ�... �׷��� ����!!
		public void createButton(){
				count++;
				JButton bt=new JButton(Interger.toString(count));
				p_center.add(bt);
				p_center.updateUI(); //refresh
		}
	
		
		setVisible(true);
		setSize(500, 600);
		setDefaultCloseOperation(EXIT_ON_CLOSE);	
		
	}
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		for(int i=1; i<40; i++){
		System.out.println("��");
		//bt_plus=new JButton("i");
		//bt_plus.setBounds(50*i,50,50,100);
		//append(bt_plus);
		}
	}
	
	public static void main(String[] args) {
		new MyButton();
		
	}

}
