/*김민정 사원이 만들게 될 MP3Player*/
package music;

//상속시 부모가 불완전한 추상클래스일 경우
//완전하게 코드를 완성할 의무는 자식에게 주어진다..
//빚과 재산을 동시에 받는 현실처럼
//코드상속과 의무도 함께 해야한다.. 자식에게 구현을 강제화 하기위해서
//**extends도 implements 도 is a 관계이다!!!!
//MP3Player 는 MusicPlayer 이면서, Jet 이다!!!
//is a 관계는 객체자료형 끼리 형변환이 가능하다!!!
public class MP3Player extends MusicPlayer implements Jet{
		//이퀄라이저를 이용한 시각화 기능
		public void equlizer(){
			System.out.println("오르락내리락");
		}
		
		//부모가 완성못한 메서드를 여기서 완성한다!
		//상속 받을 때 하위객체들이 이 기능만큼은 꼭 들어갔으면 좋겠으면
		//강제화 시키는 것 = 계획단계에서 들어간다..
		public void playMP3(){ //브레이스(바디)만 있으면 완성된것!!
			System.out.println("mp3 플레이중...");
		}
		public void setVolume(){
			System.out.println("볼륨을 조절중...");
		}
		public void fly(){
		}
}
