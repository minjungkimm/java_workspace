package homework;

import java.awt.Graphics;

abstract public class CountThread extends Thread{
	int x;
	int y;
	int width;
	int height;
	int interval;
	Graphics g;
	
	public CountThread(int x,int y,int width,int height,int interval,Graphics g){
		this.x=x;
		this.y=y;
		this.width=width;
		this.height=height;
		this.interval=interval;
		this.g=g;
		
		start();
		
	}
	
	abstract public void render();
	
	@Override
	public void run(){
		while(true){
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			render();
		}
	}
}
