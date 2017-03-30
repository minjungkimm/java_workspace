/*동시 수행하고 싶은 코드는 개발자가 결정해야
 * 하기 때문에 쓰레드를 재정의 해야 한다*/
package thread; 
public class MyThread extends Thread {
	/*개발자는 독립적으로 수행하고 싶은 코드를 쓰레드의
	 * run 메서드안에 작성하면 된다*/
	//setTimeout 과 비슷한 느낌
	@Override
	public void run() {
		while(true){ //실행부가 닫는브레이스 만나면 죽으니깐
							//닫는브레이스 닫지않게 끝없는 반복문 돌리기
							//run 두개 , 둘다 while 문 돌린다하면 하나에서만 
							//while 문이 도는게 아니라 둘다 돈다
		try {
			Thread.sleep(1000);//1초 쉬다가 와!!!!
		} catch (InterruptedException e) {
			e.printStackTrace();
		} 
		System.out.println("★"); //복귀해서 찍고 다시 와일문 돌아가면 1초쉬고 반복
		}
	}
}
