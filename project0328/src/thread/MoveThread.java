/*움직임 로직을 담게 될 쓰레드*/
package thread;

public class MoveThread extends  Thread {
	//개발자는 독립 실행할 코드를 run에 기재한다..
	//JVM이 run을 알아서 호출한다
	AniMain animain;
	public MoveThread(AniMain animain) {
		this.animain=animain;
	}
	@Override
	public void run() {
		while(true){
			try {
				Thread.sleep(100); //0.1초 간격으로
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			animain.move();
			
		}
	}

}
