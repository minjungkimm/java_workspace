package game;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

/*�� Ŭ������ sun���� ��ü������ UI ������Ʈ�� �ƴϱ� ������,
 * ȭ�鿡 �׷����� ����...
 * ���� JPanel �� �׷�������, JPanel �� Graphics ��ü��
 * ���䷱���� �� ��ü�� �����ؾ� �Ѵ�*/
public class Player extends GameObject{
	//x,y,width,height ���� �������� ��ȭ��
	//�����ϱ� ���� �޼���!!(��� ���� - ��� ��ȭ)
	//���� �߷µ� �ִ´ٸ� float g; = �߷��� �Ҽ������� ǥ���ؾ� �ڿ�������ϱ�..
	public Player(ObjectManager objectManager,ObjectId id,int x,int y,int width,int height){
		super(objectManager,id,x,y,width,height);
	
	}
	
	//�Ѿ� �߻������� �����Ѵ�..
	public void fire(){
		Bullet bullet = new Bullet(objectManager,ObjectId.Bullet,x, y, 10, 10);
		//������ ��簴ü�� ���� �� tick �� render �� ���������Ѵ�!!
		objectManager.addObject(bullet);
	}
	
	//���ΰ� �������ڸ��� .. 
	public void tick(){
		x+=velX;
		y+=velY;
		//System.out.println("tick()");
		//���� �簢���� x,y ��ǥ�� �ٲ㺸��
		rect.setBounds(x, y, width, height);
		//�簢�� ������ �� �ֵ��� ����, �簢���� ���� ����ٴϰ� ���� ����ȭ��Ŵ..
	}
	
	//��ȭ�� ���� ȭ�鿡 �׷����� �� �޼���
	public void render(Graphics g){
		g.setColor(Color.WHITE); //����Ʈ�� �ٲٱ�
		//g.drawRect(x, y, width, height);
		//System.out.println("render()");
		Graphics2D g2=(Graphics2D)g;
		g2.draw(rect); //�簢�� �ð�ȭ ��Ű�� ()�ȿ� ���ǻ簢��������		
	}
}
