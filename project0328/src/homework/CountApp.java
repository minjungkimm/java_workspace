package homework;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JFrame;
import javax.swing.JLabel;

public class CountApp extends JFrame{
	Canvas can;
	JLabel la_west;
	JLabel la_east;
	count=0;
	
	public CountApp(){
		la_west = new JLabel("count");
		la_east = new JLabel("count");
		can = new Canvas(){
			
			@Override
			public void paint(Graphics g) {
				
			}
		};
		
		can.setBackground(Color.PINK);
		add(can);
		add(la_east);
		add(la_west);
		
		setSize(700,500);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
	}
	
	
	public static void main(String[] args) {
		new CountApp();
	}
}
