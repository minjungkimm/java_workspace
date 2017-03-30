/*���ӿ� ������ ��� �ܾ ���� y���� ���� ����,
 * �뷮���� ��������� �ϱ� ������
 * �ᱹ ���뼺�� ���� �ڵ����� Ŭ������ ����
 * */
package game.word;

import java.awt.Graphics;

public class Word {
	String name; //�� ��ü�� ��� �� �ܾ�
	int x;
	int y;
	int velX; 
	int velY; //�ܾ ������ �ӵ�
	//������ ���鶧�� ������ interval�� �ϳ��� �ش�. �������� ���Ͽ�
	
	//�� �ܾ �¾�� ���߾�� �� �ʱ�ȭ��
	public Word(String name, int x, int y) {
		this.name=name;
		this.x=x;
		this.y=y;
	}
	
	//�� ��ü�� �ݿ��� ������ ��ȭ�ڵ�
	public void tick(){
		y+=5;
	}
	
	//�� �ݿ��� �����͸� �̿��Ͽ� ȭ�鿡 �׸���
	public void render(Graphics g){
		g.drawString(name, x, y);
	}
}
