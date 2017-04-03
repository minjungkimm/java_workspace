/*
강아지 클래스의 인스턴스를 오직 1개만 만들어보자
두번째만들면 에러가 나서 막는다
*/
package HOME;
	
public class Dog {
	//인스턴스 변수라서 Static 영역에서는 지금 볼수없다
	//원천적으로는 강아지의 레퍼런스 변수 알아야 하는데,
	//정해져있지않다.. 올라가있지않아서..
	static private Dog instance;

	//생성자가 private 이라서 클래스내에서만
	//접근가능상태
	private Dog(){

	}

	static public Dog getInstance(){
		if(instance==null){
			instance = new Dog();
		
		}
		return instance;
	}
}
