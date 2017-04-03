package game;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.Random;

public class Enemy extends GameObject{
	Random r = new Random();//랜덤 클래스 추가
	int max;
	int min;
	
	public Enemy(ObjectManager objectManager,ObjectId id, int x, int y, int width, int height) {
		super(objectManager,id, x, y, width, height);
		velX=-1; //적군이 다가오게하자
		max = GamePanel.HEIGHT*GamePanel.SCALE-50;
		min =50;
	}

	@Override
	public void tick() {
		x+=velX;	
		//화면 좌측 끝에 도달하면 다시 우측부터 시작하게..
		if(x<0){
			//(int Bound)
			y=r.nextInt(max - min+1)+min;
			x=GamePanel.WIDTH*GamePanel.SCALE;
			
		}
		rect.setBounds(x, y, width, height);
	}

	@Override
	public void render(Graphics g) {
		g.setColor(Color.RED);
		Graphics2D g2=(Graphics2D)g;
		g2.draw(rect); //사각형 시각화 시키자 ()안에 나의사각형을넣자
	}
	
}
