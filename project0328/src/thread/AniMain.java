package thread;

import java.awt.BorderLayout;
import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

public class AniMain extends JFrame{
	JButton bt;
	Canvas can;
	int x,y;
	AniMain animain;
	
	public AniMain () {
		animain = this;
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
				MoveThread mt = new MoveThread(AniMain.this);
				mt.start();
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
	
	public static void main(String[] args) {
		new AniMain();

	}

}
