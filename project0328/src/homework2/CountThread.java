package homework2;

import javax.swing.JLabel;

public class CountThread extends Thread{
	JLabel la;
	int interval;
	int count;
	
	public CountThread(JLabel la,int interval){
		this.la=la;
		this.interval=interval;
		
		this.start();
	}
	
	public void run(){
		//특정 라벨의 값을 1씩 증가시키되 , 지정한 속도대로...
		while(true){
			try {
				Thread.sleep(interval);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			count++;
			la.setText(Integer.toString(count));
		}
	}
}
