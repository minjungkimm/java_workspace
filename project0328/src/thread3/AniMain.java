
package thread3;

import java.awt.BorderLayout;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

//개발자가 쓰레드를 상속하여 개발할 수 있으나
//이미 다른 클래스의 자식일 경우, 상속은 불가하다
//이럴 때 사용할 수 있는 것 객체가 바로 
//Runnable 인터페이스이다!!
//나는 run 할 수 있는 객체를 구현하겠다!!!
//1번 클래스 생성 , 재사용성 높아지만 , 개발자가 귀찮아진다. 클래스를 생성해서 레퍼런스를 넘겨야 하니깐..
//2번 내부익명클래스 , 멤버변수를 내것처럼 쓸 수 있다 , 일회성이라 재사용성이 떨어진다..
//3번 runnable , 이미 누군가의 자식일 경우,  상속은 불가하다. 이 때 사용가능한 것이 runnable 인터페이스!! 
//run이 같은 클래스에 있어서 멤버변수를 쓸 수 있다..
public class AniMain extends JFrame implements Runnable{
	JButton bt;
	Canvas can;
	int x,y;
	//AniMain animain; //내부익명으로
	Thread thread; //내부익명 스타일로 개발

	public AniMain () {
		//animain = this; //(안에) runnable 인 객체를 인수로 넘긴다
								//그러면 , run 메서드의 호출은 runnable 을 재정의한
								//객체의 run 메서드를 호출한다..
		thread = new Thread(this); //new 만 한다
		
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
	
	@Override
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
	
	public static void main(String[] args) {
		new AniMain();

	}


}
