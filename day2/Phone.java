/*자바의 메서드에 대해 학습한다
1.매개변수 있는 함수
2.반환값 있는 함수 */
class Phone{
	//자바에는 함수 앞에 자료형이 와야함
	//매개변수 있는 메서드!!
	//this란? 인스턴스가 자기 자신을 가리키기 위한
	//레퍼런스 변수!!
	//this와 p의 차이는? p는 사용자정의 레퍼런스변수
	//this. 는 예약어인 레퍼런스변수!!
	public void call(int a){ //1번 매개변수 있는 함수
		System.out.println(this); //인스턴스내에서 나자신을 지칭
								  //this=p 주소값 출력
	}
	
	//void = 빈 , return 값이오면 void 쓰면 안된다..
	//반환값이 있는 메서드 정의
	//반환값이 있을 경우엔 반드시!!
	//그 반환값에 해당되는 자료형을 명시해야 한다..(메서드명 앞에...)
	public int getPrice(){ //2번 리턴값 있는함수
		return 5;
	}
	public static void main(String[] args){
		//Phone은 인스턴스 메서드만을 보유하고 있으므로,
		//메서드를 사용하기 위해서는 먼저 Phone의 인스턴스를 메모리에
		//생성함이 우선이다!!
		//p는 제3자가 나를 부르기 위한 방법
		Phone p = new Phone();
		p.call(70);
		
		System.out.println(p); //여기서 p는 주소값
		
		int y=p.getPrice();
		System.out.println(y); //y는 getPrice 리턴값 5를 출력
	}
}
