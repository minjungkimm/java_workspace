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
		
		bt=new JButton("이동");
		bt.addActionListener(this);
		//배경색주자!
		p_north.setBackground(Color.PINK);
		
		add(bt,BorderLayout.NORTH);
		add(p_north);
		
		setSize(600,500);
		setVisible(true);
		
	}
	
	
	public void actionPerformed(ActionEvent e) {
		x+=10;
		y+=10;
		//프레임을 접근하는 방법!!
		repaint(); //윈도우!
		//this의 위험성.. 조심하고 생각많이 해보자 
		
	}
	/*public void test(){
		System.out.println("test 호출");
		
	}*/
	public static void main(String[] args) {
		new ManualMove();
		
	}
}

