
package thread3;

import java.awt.BorderLayout;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

//�����ڰ� �����带 ����Ͽ� ������ �� ������
//�̹� �ٸ� Ŭ������ �ڽ��� ���, ����� �Ұ��ϴ�
//�̷� �� ����� �� �ִ� �� ��ü�� �ٷ� 
//Runnable �������̽��̴�!!
//���� run �� �� �ִ� ��ü�� �����ϰڴ�!!!
//1�� Ŭ���� ���� , ���뼺 �������� , �����ڰ� ����������. Ŭ������ �����ؼ� ���۷����� �Ѱܾ� �ϴϱ�..
//2�� �����͸�Ŭ���� , ��������� ����ó�� �� �� �ִ� , ��ȸ���̶� ���뼺�� ��������..
//3�� runnable , �̹� �������� �ڽ��� ���,  ����� �Ұ��ϴ�. �� �� ��밡���� ���� runnable �������̽�!! 
//run�� ���� Ŭ������ �־ ��������� �� �� �ִ�..
public class AniMain extends JFrame implements Runnable{
	JButton bt;
	Canvas can;
	int x,y;
	//AniMain animain; //�����͸�����
	Thread thread; //�����͸� ��Ÿ�Ϸ� ����

	public AniMain () {
		//animain = this; //(�ȿ�) runnable �� ��ü�� �μ��� �ѱ��
								//�׷��� , run �޼����� ȣ���� runnable �� ��������
								//��ü�� run �޼��带 ȣ���Ѵ�..
		thread = new Thread(this); //new �� �Ѵ�
		
		bt = new JButton("��ü�̵�");
		add(bt, BorderLayout.NORTH);
		
		
		can = new Canvas(){
			
			@Override
			public void paint(Graphics g) {
				g.drawOval(x, y, 50, 50);
			}
		};
		
		can.setBackground(Color.YELLOW);
		add(can);
		//��ư�� ������ ����
		bt.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				//�̵� �޼��� ȣ��!!
				//���� �����带 ����� �Ͻ�Ű��!!
				//MoveThread mt = new MoveThread(animain); �Ѵٰ���
				//MoveThread mt = new MoveThread(AniMain.this);
				//mt.start(); //�����͸� 
				thread.start(); //Ŭ������ �� �ðܹ�����!!
			}
		});
		
		setSize(700,500);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	
	public void move(){
		x+=5;
		can.repaint();
	}
	
	@Override
	public void run() {
		while(true){
			try {
				Thread.sleep(100);//0.1�� ��������
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			move(); 
		}
		
	}
	
	public static void main(String[] args) {
		new AniMain();

	}


}
