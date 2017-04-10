/*변수명,메서드명,클래스명은 상당히 신중을
기해서 정하게 된다.
메서드 정의 시 그 내용이 비슷할 경우, 메서드명 중복
금지 원칙을 고수한다면 개발자는 내용이 비슷함에도
불구하고 새로운 이름을 계속 지어나가야 한다.
이 경우 이름을 짓는데 너무 많은 시간을 할애하게 된다.
sun에서는 오버로딩을 허용해 줌으로서 해결하게 해준다
오버로딩(OverLoading)이란? 하나의 클래스내에서 메서드명을 얼마든지
중복 정의할 수 있는 메서드 정의 기법을 의미한다..
주의)) 완전히 100% 똑같으면 구분이 안되기 때문에
컴파일 에러 난다....
결국 메서드의 인수자료형 및 인수의 갯수로 구분해야 한다!!!!!!!
*/

class Rabbit{
	//뛰는 동작을 표현하는 메서드
	public void run(){
		System.out.println("뛴다");
	}
	public void run(int v){
		System.out.println("천천히 뛴다");		
	}
	public void run(String v, int a){
		System.out.println("더 천천히 뛴다");		
	}
}
