/*
메서드는 함수이므로, 일반적인 언어의 함수의 적용되는 원리는 
자바의 메서드에도 동일하게 적용된다.
따라서 반환값, 매개변수의 개념이 같다
메서드는 변수를 제어하는데 많이 쓴다.
*/
class Dog{
	//static 에서 non-static은 확인할수 없다
	//그러나 non-static에서는 static을 확인할수 있다 (자기가 태어난 클래스 원본이므로)
	String name="뽀미";
	String type="말티즈";
	
	//강아지 이름을 스스로 바꿀수 있는 메서드
	//인스턴스!!!
	//return 값이 없으면, void !!!
	//인스턴스라서 원본이 아니라, 옮겨간 인스턴스에서 바뀜
	//자바에서 매개변수를 넣을때는 자!료!형! 잊지말자!!!
	public void setName(String n,String t){
		this.name=n;
		this.type=t;	
	}

	/*자바와 같은 일반적인 응용프로그램에서는
	(c,c# 등의 대부분 언어)
	return 값이 있는 함수의 경우, 반드시 해당
	리턴값에 알맞는 자료형을 메서드명 앞에
	명시해야 한다..!! */

	public String getName(){
		//리턴값이 있다는 건 데이터값 자체!!!
		//리턴값이 있는 메서드를 불러라!!
		//return 되어서 name="뽀미"; 로가기때문에
		//void 는 데이터값이 없다..
		return name;
	}
}
