package project0330;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

public class Bullet extends GameObject{

	
	public Bullet(ObjectManager objectManager,ObjectId id,int x,int y,int width,int height) {
		super(objectManager,id,x,y,width,height);
		velX=4;	
	}
	
	public void tick(){
		x+=velX;
		rect.setBounds(x, y, width, height);
		//물리량 계산이니깐 여기서 충돌테스트 계산
		//적과 내가 교차하면, 둘다 죽기
		for(int i=0;i<objectManager.list.size(); i++){
			GameObject obj=objectManager.list.get(i);
			if(obj.id==ObjectId.Enemy){
				if(obj.rect.intersects(this.rect)){
				//너죽고 나죽자
				objectManager.list.remove(obj); //obj가 enemy 인녀석
				objectManager.list.remove(this); //나 bullet
				}
			}
		}
	}
	
	public void render(Graphics g){
		g.setColor(Color.yellow);
		Graphics2D g2=(Graphics2D)g;
		g2.fillOval(x, y, width, height); //시각화일뿐 사각형rect 는 언제나 따라다니고있다..
	}	
}
