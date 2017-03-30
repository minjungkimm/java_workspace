package project0330;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

/*플레이어의 움직임을 제어하자*/
public class KeyBoard extends KeyAdapter{
	Player player;
	Bullet bullet;
	
	public KeyBoard(Player player) {
		this.player=player;
	}
	
	@Override
	//키보드 누르면
	public void keyPressed(KeyEvent e) {
		int key=e.getKeyCode();
		switch(key){//소괄호안의 값에대해 조건 판단
			case KeyEvent.VK_LEFT:
				player.velX=-2;break; //끊지않으면 넘어가서수행됨
			case KeyEvent.VK_RIGHT:
				player.velX=2;break;
			case KeyEvent.VK_UP:
				player.velY=-2;break;
			case KeyEvent.VK_DOWN:
				player.velY=2;break;
			case KeyEvent.VK_SPACE:
				//총알 생성코드 //원래는 플레이어 메서드를 불러내고, ...
				//bullet = new Bullet(x, y, width, height);
				player.fire();break;
		}
	}
	
	@Override
	//키보드 손떼면
	public void keyReleased(KeyEvent e) {
		int key=e.getKeyCode();
		switch(key){//소괄호안의 값에대해 조건 판단
			case KeyEvent.VK_LEFT:
				player.velX=0;break; //끊지않으면 넘어가서수행됨
			case KeyEvent.VK_RIGHT:
				player.velX=0;break;
			case KeyEvent.VK_UP:
				player.velY=0;break;
			case KeyEvent.VK_DOWN:
				player.velY=0;break;
		
		}
		
	}
}
