package homework;

public class MyMin extends Thread{

	AniMin animin;
	
	public MyMin(AniMin animin){
		//쓰레드로 움직이는데 움직이는 속도와 원의 크기가 달라야 한다..
		this.animin=animin;
	}
	
	public void run(){
			while(true){
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			animin.move(5,5,100,100);
	
			}
	}
}
