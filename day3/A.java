/*
override 100%는 모든게 일치
overloading 메서드 이름만 일치 (반환형 상관x)
*/
public class A {

	public void doit() {
	}
	//불필요한 반환형만 달리하였기 때문에, 오버로딩으로 불인정
	public String doit() {  
		return “a”;
	}
	//메서드명은 동일하고, 인수자료형으로 구분했으나 
	//반환명으로 구분하였다..(반환명으로 구분하면 안됨)
	public double doit(int x) {
		return 1.0;
	}

}
