package homework;

import java.awt.BorderLayout;
import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

/*���δٸ� �׷��� , �ӵ� , ��Ÿ���� ����
 * ��ü�� �����̰� ����!!*/
public class MultiAni extends JFrame{
	JButton bt;
	Canvas can;
	
	CircleThread ct;
	
	public MultiAni(){
		bt = new JButton("���ڿ����̱�");
		can = new Canvas(){
			@Override
			public void paint(Graphics g) {
				//gp=g;
			}
		};

		
		can.setBackground(Color.PINK);
		add(bt,BorderLayout.NORTH);
		add(can);
		
		bt.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				Graphics g=can.getGraphics();
				
				for(int i=0; i<5; i++){
					CircleThread ct = new CircleThread(0, i*(50+10), 50, 50,100,g); //��ư������ gp ������ ������ ������ �Ű��
					//ct.start(); shapeThread ����..
					RectThread rt = new RectThread(0,200,100,100,10,g);
				}
			}
		});
		
		setSize(700,500);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);	
	}
	
	public static void main(String[] args) {
		new MultiAni();

	}

}
