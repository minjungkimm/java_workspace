/*
 * OS가 여러 프로세스들을 동시에 수행하면서
 * 관리할 수 있듯, (multi - tasking 멀티태스킹)
 * 하나의 자바프로그램 내에서 세부적 실행단위를 만들어 
 * 동시에 수행시킬 수 있다 이러한 세부적 실행단위를 
 * 쓰레드라 한다.
 * 자바는 개발자가 정의하지 않아도, 이미 기본적으로
 * 제공되는 실행용 쓰레드가 있으며, 이러한 쓰레드를 가리켜
 * 메인쓰레드라 한다..
 * 결국 자바는 쓰레드 기반이다...
 * 우리가 주도해서 메인 실행부 외에 다른 실행을 할 쓰레드를 만들어보자..
 * */
package thread;

public class ThreadTest {
	
	//메인쓰레드 말고 개발자가 원하는 사용자정의 쓰레드 하나 만들어서
	//원하는 동시 작업을 시켜보자
	MyThread thread; 
	
	public ThreadTest(){ //2번 실행 
		thread = new MyThread(); //쓰레드 생성
		//메인 쓰레드와는 독립적으로 실행될 수 있는
		//세부 실행단위를 생성했다
		//쓰레드가 어떤 일을 할지는 개발자가 결정해야 하기때문에..
		//쓰레드 재정의 해야 한다 - 상속받자
		//run 호출해야 실행하지!
		thread.start();// 실행
		//run을 start 하여서 맡기는 것이 아니라, 직접 실행을 하게되면
		//메인실행부가 직접 메서드를 실행하기 때문에 , 메인실행부가 런을 실행하고
		//와서 흰별을 수행하러 오는 , 즉 혼자서 두가지일을 하는경우가 됨
		//우리가 메인실행부와 쓰레드를 따로 두는 경우는 각자 멀티태스킹을 위해!!
		while(true){
			try {
				Thread.sleep(500); //0.5초
			} catch (InterruptedException e) {
				e.printStackTrace(); //실시간 감시프로그램이나 채팅에 유용하다..
			}
			System.out.println("☆"); //3번 실행
		}
	}

	public static void main(String[] args) {
		new ThreadTest(); //1번 메인부 실행
	}
}
