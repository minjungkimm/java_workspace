//나와는 다른 위치에 존재하는 클래스를 사용해본다!!
//주의!! 자바는 클래스 위치를 알기위해
//classpath 만을 쳐다본다!!
package use;
import animal.bird.Duck;
//누군가 이 클래스를 사용하고자 한다면 public 을 달아 접근가능하게 하되, 지금은 아니다.
class UseDuck{
	public static void main(String[] args){
		Duck d=new Duck();
	}
}
