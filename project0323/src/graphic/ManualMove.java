package graphic;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class ManualMove extends JFrame implements ActionListener{
	JPanel p_north;
	JButton bt;
	int x,y;
	
	public ManualMove(){
		p_north=new JPanel(){
			
			public void paint(Graphics g) {
				g.drawOval(x, y, 50, 50);
			}
			
		};
		
		bt=new JButton("�̵�");
		bt.addActionListener(this);
		//��������!
		p_north.setBackground(Color.PINK);
		
		add(bt,BorderLayout.NORTH);
		add(p_north);
		
		setSize(600,500);
		setVisible(true);
		
	}
	
	
	public void actionPerformed(ActionEvent e) {
		x+=10;
		y+=10;
		//�������� �����ϴ� ���!!
		repaint(); //������!
		//this�� ���輺.. �����ϰ� �������� �غ��� 
		
	}
	/*public void test(){
		System.out.println("test ȣ��");
		
	}*/
	public static void main(String[] args) {
		new ManualMove();
		
	}
}

