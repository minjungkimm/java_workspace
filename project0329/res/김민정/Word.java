package game.word;

import java.awt.Graphics;

//���ӿ� ������ ��� �ܾ ����
//y���� ���� ���� ����, �뷮���� ������ �ϱ� ������..
//�ᱹ ���뼺�� ���� �ڵ������� Ŭ������ ����.
public class Word {
	String name; //�� ��ü�� ��Ե� �ܾ�
	int x;
	int y;
	int velX;
	int velY; //�ܾ ������ �ӵ�..
	
	//�� �ܾ �¾ �� ���߾�� �� �ʱ�ȭ ��
	public Word(String name,int x,int y) {
		this.name=name;
		this.x=x;
		this.y=y;
	}
	
	//�� ��ü�� �ݿ��� ������ ��ȭ�ڵ�
	public void tick(){ //���ν���ο��� ������ ȣ��Ǿ���
		y+=5;
	}
	
	//�� �ݿ��� �����͸� �̿��Ͽ� ȭ�鿡 �׸���
	public void render(Graphics g){ //���ν���ο��� ������ ȣ��Ǿ���
		g.drawString(name,x,y);
		//�� �ܾ ���� �� �ʱ�ȭ �Ǿ����
	}
	
}
