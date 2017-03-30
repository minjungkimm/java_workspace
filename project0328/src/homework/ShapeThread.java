package homework;

import java.awt.Graphics;

/*���̴�, �簢���̴�, � ������ ǥ���� ��ü�̴�
 * ��� �� Ŭ������ �ڽ����� ����..
 * ��? ������ Ư¡�� �����Ƿ�..*/
abstract public class ShapeThread extends Thread {
	int x;
	int y;
	int w;
	int h;
	int interval;
	Graphics g;
	
	
	public ShapeThread(int x,int y,int w, int h,int interval,Graphics g){
		this.x=x;
		this.y=y;
		this.x=x;
		this.h=h;
		this.interval=interval;
		this.g=g;
		
		start();
		
	}

	abstract public void render();
	
	@Override
	public void run() {
		while(true){
			try {
				Thread.sleep(interval);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			render();
		}
	}	
	
}
