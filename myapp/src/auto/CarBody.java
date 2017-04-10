/*아래의 클래스에서 멤버변수중 그 자료형이
객체형인 경우만 , has a관계라 한다!!
즉 관계라 하면 사물을 대상으로 한다..*/
package auto;

public class CarBody{
	//카바디의 멤버변수 총 3개, has a관계인 것은 이중 2개만
	int price; //int 는 초기화 값 0
	Handle h;
	Engine e;
	Wheel w; //객체자료형의 컴파일러에의한 default 초기화 값은? null
	//아무런 객체를 가리키고 있지 않은 레퍼런스 변수는 null로 초기화 됨
	//null 은?? 값이 없다는 뜻이다..
	public CarBody(){
		
		h=new Handle();
		e=new Engine();
		w=new Wheel();

	}
}
