/*
나와는 다른 위치에 존재하는 horse 를 사용해보자!!
자바는 나와는 다른 패키지에 있는 클래스를 참조시 오직 classpath 환경변수만 참조한다.
따라서 아래의 import 문에 animal.Horse 라 한다면,
Horse 의 경우 그 앞에 환경변수의 값이 생략되어 있다고
이해하면 된다..
class path 의 목적은 자바의 슬로건을 표현하기 위함이다!!!
모든 OS에서 중립적(으로 돌아가기 위함..)이기 위해
*/
package use;
//패키지 직전 디렉토리 경로는 숨겨야 한다!! 자바는디렉토리.디렉토리하자!!
//그리고 숨겨버린 경로는 OS 에 등록한다.. 
import animal.Horse;
class UseHorse{
	public static void main(String[] args){
		//실행할때는 기계어 bin 에 있는 .class
		Horse h = new Horse();
		System.out.println("UseHorse 실행");
		
	}
}
