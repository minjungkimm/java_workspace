package homework;

import java.awt.BorderLayout;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Event;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
/*���δٸ� �׷��� , �ӵ� , ��Ÿ���� ����
 * ��ü�� �����̰� ����!!*/
public class AniMin extends JFrame{
	JButton bt;
	Canvas can;
	int x=0;
	int y=0;
	int w,h;
	AniMin animin;
	
	public AniMin(){
		animin = this;
		bt = new JButton("�ٰ����̵�");
		can = new Canvas(){
			@Override
			public void paint(Graphics g) {
				g.drawOval(x, y, w, h);
			}
		};	
		add(bt,BorderLayout.NORTH);
		add(can);
		can.setBackground(Color.pink);
		
		bt.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				MyMin mn= new MyMin(AniMin.this);
				MyMin mn2= new MyMin(AniMin.this);
				mn.start();
				mn2.start();
			}
		});
		
		setSize(700,500);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	
	
	public void move(int x,int y,int w,int h){
		this.x+=x;
		this.y+=y;
		this.w=w;
		this.h=h;
		can.repaint();
	}
	
	public static void main(String[] args) {
		new AniMin();

	}

}
