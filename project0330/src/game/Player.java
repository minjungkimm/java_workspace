package game;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

/*이 클래스는 sun에서 자체제작한 UI 컴포넌트가 아니기 때문에,
 * 화면에 그려질수 없다...
 * 따라서 JPanel 에 그려지려면, JPanel 의 Graphics 객체의
 * 레페런스를 이 객체가 보유해야 한다*/
public class Player extends GameObject{
	//x,y,width,height 등의 물리량의 변화를
	//제어하기 위한 메서드!!(사람 비유 - 운동량 변화)
	//만약 중력도 넣는다면 float g; = 중력은 소수점까지 표현해야 자연스러우니깐..
	public Player(ObjectManager objectManager,ObjectId id,int x,int y,int width,int height){
		super(objectManager,id,x,y,width,height);
	
	}
	
	//총알 발사행위를 정의한다..
	public void fire(){
		Bullet bullet = new Bullet(objectManager,ObjectId.Bullet,x, y, 10, 10);
		//세상의 모든객체는 생성 후 tick 과 render 로 움직여야한다!!
		objectManager.addObject(bullet);
	}
	
	//주인공 등장하자마자 .. 
	public void tick(){
		x+=velX;
		y+=velY;
		//System.out.println("tick()");
		//나의 사각형의 x,y 좌표를 바꿔보자
		rect.setBounds(x, y, width, height);
		//사각형 움직일 수 있도록 변경, 사각형이 나를 따라다니게 값을 동기화시킴..
	}
	
	//변화된 값을 화면에 그려지게 할 메서드
	public void render(Graphics g){
		g.setColor(Color.WHITE); //페인트색 바꾸기
		//g.drawRect(x, y, width, height);
		//System.out.println("render()");
		Graphics2D g2=(Graphics2D)g;
		g2.draw(rect); //사각형 시각화 시키자 ()안에 나의사각형을넣자		
	}
}
