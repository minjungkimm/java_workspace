package project0330;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

/*�÷��̾��� �������� ��������*/
public class KeyBoard extends KeyAdapter{
	Player player;
	Bullet bullet;
	
	public KeyBoard(Player player) {
		this.player=player;
	}
	
	@Override
	//Ű���� ������
	public void keyPressed(KeyEvent e) {
		int key=e.getKeyCode();
		switch(key){//�Ұ�ȣ���� �������� ���� �Ǵ�
			case KeyEvent.VK_LEFT:
				player.velX=-2;break; //���������� �Ѿ�������
			case KeyEvent.VK_RIGHT:
				player.velX=2;break;
			case KeyEvent.VK_UP:
				player.velY=-2;break;
			case KeyEvent.VK_DOWN:
				player.velY=2;break;
			case KeyEvent.VK_SPACE:
				//�Ѿ� �����ڵ� //������ �÷��̾� �޼��带 �ҷ�����, ...
				//bullet = new Bullet(x, y, width, height);
				player.fire();break;
		}
	}
	
	@Override
	//Ű���� �ն���
	public void keyReleased(KeyEvent e) {
		int key=e.getKeyCode();
		switch(key){//�Ұ�ȣ���� �������� ���� �Ǵ�
			case KeyEvent.VK_LEFT:
				player.velX=0;break; //���������� �Ѿ�������
			case KeyEvent.VK_RIGHT:
				player.velX=0;break;
			case KeyEvent.VK_UP:
				player.velY=0;break;
			case KeyEvent.VK_DOWN:
				player.velY=0;break;
		
		}
		
	}
}
