package homework;

import java.awt.Color;
import java.awt.Graphics;

//���� ǥ���� ��ü �� �� ������
public class CircleThread extends ShapeThread{
	//���� �θ����� �ִ�
	
	//�θ� �������̵�(���׷��̵�) �ߴ�..
	public void render(){
		//����� ����Ʈ�� �����쿡 �����ϰ�
		g.setColor(Color.yellow);
		g.fillRect(0, 0, 700, 600);		
		//�׸���
		//g�� �˰��϶�
		x+=5;
		g.setColor(Color.black);
		g.drawOval(x, y, w, h);
	}	
	
	public CircleThread(int x,int y,int w,int h,int interval,Graphics g){
		super(x,y,w,h,interval,g);	
	}
	
}
