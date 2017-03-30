package homework;

import java.awt.Color;
import java.awt.Graphics;

//원을 표현한 객체 및 그 움직임
public class CircleThread extends ShapeThread{
	//변수 부모한테 있다
	
	//부모를 오버라이드(업그레이드) 했다..
	public void render(){
		//노란색 페인트로 윈도우에 적용하고
		g.setColor(Color.yellow);
		g.fillRect(0, 0, 700, 600);		
		//그리자
		//g를 알게하라
		x+=5;
		g.setColor(Color.black);
		g.drawOval(x, y, w, h);
	}	
	
	public CircleThread(int x,int y,int w,int h,int interval,Graphics g){
		super(x,y,w,h,interval,g);	
	}
	
}
