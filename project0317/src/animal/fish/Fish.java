package animal.fish;

public class Fish{
	String name="난 물고기";
	
	//상속관계에서 부모 클래스가 인수있는 생성자를
	//명시할 경우, 디폴트 생성자를 사용하지 않게 되므로,
	//에러가 발생할 수 있다.
	public Fish(String name){
	
	}
	/*
	public Fish(){
		int x=3;
		super(); //super(); 는 항상 숨겨져있지만 자동으로 나와있다
		//그러나 개발자가 직접 명시한다면,
		//부모를 태어나게 해야 자식이 있으니깐 가장 먼저 있어야한다
		//부모의 생성보다 우선되는 코드는 존재할 수 없다.. sun의 정책
		//위사항은 틀린것의 예시!!!
		
	}
	*/
	public void swim(){
		System.out.println("니모가 수영쳐요!!");
	}	
}
