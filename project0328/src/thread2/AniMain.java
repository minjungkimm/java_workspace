package thread2;

import java.awt.BorderLayout;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

//모두 내부익명클래스로 갈 것임 
public class AniMain extends JFrame{
	JButton bt;
	Canvas can;
	int x,y;
	//AniMain animain; //내부익명으로
	Thread thread; //내부익명 스타일로 개발

	public AniMain () {
		//animain = this;
		thread = new Thread(){ //태어나기만 했다.. //시스템에 맞기자
			@Override //개발자는 로직은 run 에짜라!!
			public void run() { 
				while(true){
					try {
						Thread.sleep(100);//0.1초 간격으로
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					move(); 
				}
			}	
		};
		
		bt = new JButton("물체이동");
		add(bt, BorderLayout.NORTH);
		
		
		can = new Canvas(){
			
			@Override
			public void paint(Graphics g) {
				g.drawOval(x, y, 50, 50);
			}
		};
		
		can.setBackground(Color.YELLOW);
		add(can);
		//버튼과 리스너 연결
		bt.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				//이동 메서드 호출!!
				//동생 쓰레드를 만들어 일시키자!!
				//MoveThread mt = new MoveThread(animain); 둘다가능
				//MoveThread mt = new MoveThread(AniMain.this);
				//mt.start(); //내부익명 
				thread.start(); //클릭했을 때 맡겨버리자!!
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
