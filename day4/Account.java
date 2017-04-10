//은행 계좌를 정의한다!!
/*데이터를 보호하기 위한 자바의 보안 관련 4가지
접근제한자!!
보안이 강도 순서대로
(public 보안아님)
public < protected < default < private 
개발자가 접근제한자를 지정하지 않으면 default 접근제한자가 적용된다..
주의) default 접근제한자는 명시해서는 안되고 그냥
		냅두면 된다.. (아무것도 안쓰는게 디폴트!!)
public : 보안이 아니다!! 모든 클래스가 접근할 수 있다!!
protected : 상속관계에 있는 클래스가 접근 허용 
				(+같은 패키지 내에 있는 클래스)	

default : 같은 패키지내에 있는 클래스만 접근 허용
				같은 디렉토리 내에서만 접근가능!!

private : 외부의 모든 클래스의 접근을 불허한다!!
			멤버메서드만이 접근 가능..

은닉화란?
- 클래스 안에 데이터를 담는 변수에 대한 접근을
	private 으로 제한을 가하고, 이 변수에 대해
	제어할 수 있는 방법을 메서드를 통해 제공하는
	클래스 작성 기법을 은닉화, 캡슐화(encaptualation)라 한다..

	ex)리모컨 안에 전기판을 플라스틱으로 막지 않으면
	1. 내부가 보존되지 않고 - 플라스틱 외부로 보존되게 (데이터 보존)
	2. 사용자가 사용할 수 없다 (컨트롤 할수 없다) - 고무파킹 버튼으로 컨트롤 가능하게 (컨트롤 가능)

*/

class Account{
	String num="132-456-777";
	String name="김민정";
	private int money=10000;
	
	//public void test(){
	//	money=dd;
	//} <- 멤버메서드 내에서는 접근 가능
	
	//데이터의 직접 접근은 막고, 이 데이터에 대한
	//사용은 개발자가 제공하는 메서드에 의해
	//제어할 수 있도록 허용해주자
	//변수사용 1.변경 2.값을 얻어감
	//객체지향 언어에서, private 을 막아놓은 변수를
	//제어할 수 있도록 정의되는 메서드들은
	//전세계 개발자들간의 명명규칙을 따라 정의
	//해야 한다...
	//값 변경을 위한 메서드를 setter 라 한다
	//값 반환받기 위한 메서드를 getter 라 한다.
	//setter/getter 표기 규칙
	//단어와 단어가 만나면 뒷단어의 첫철자를
	//대문자로 표기해야한다..

	public void setMoney(int money){
		//멤버변수의 money를 money 로..
		this.money=money;
	} 
	public  int getMoney(){
		//money 값 반환해줘야함
		return money;
	} 
	//기존의 네임을 변경을 위한 매개변수 필수!!
	public void setName(String name){
		//메서드를 통해서 접근하면 우리가 브레이스
		//안에서 어떤 동작을 줄수있음
		if(money<0){
			alert("안됩니다.");
		}
		this.name=name;
	}

	public String getName(){
	
		return name;
	}
}
