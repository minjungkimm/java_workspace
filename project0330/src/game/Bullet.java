package game;

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
		//������ ����̴ϱ� ���⼭ �浹�׽�Ʈ ���
		//���� ���� �����ϸ�, �Ѵ� �ױ�
		for(int i=0;i<objectManager.list.size(); i++){
			GameObject obj=objectManager.list.get(i);
			if(obj.id==ObjectId.Enemy){
				if(obj.rect.intersects(this.rect)){
				//���װ� ������
				objectManager.list.remove(obj); //obj�� enemy �γ༮
				objectManager.list.remove(this); //�� bullet
				}
			}
		}
	}
	
	public void render(Graphics g){
		g.setColor(Color.yellow);
		Graphics2D g2=(Graphics2D)g;
		g2.fillOval(x, y, width, height); //�ð�ȭ�ϻ� �簢��rect �� ������ ����ٴϰ��ִ�..
	}	
}
