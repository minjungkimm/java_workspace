//강아지 클래스의 인스턴스를 오직 1개만 만들어보기
//두번째에서는 에러가 나서 막는다!!

//SingleTon Pattern 개발 패턴 중 하나임!!
/*
 * Java SE,
 * Java EE 고급기술 (Java SE를 포함하여 
 * 				기업용 어플리케이션 제작에 사용됨)
 * 
 * Java SE 와 규모가 차이난다
 * Java EE가 다루고자 하는 규모는 대규모..
 * 
 * 미국에서 90년대 초반에 개발자 4명이서 개발서적을 출간
 * Gang of four 
 * "Design Pattern" --> 전세계 개발자들이 공통적으로 갖는것이 있다..
 *  (설계         습관) : 어플리케이션 개발 시 중요한 역할을 하였다..
 *  전산분야에서 큰 획을 그었다
 *  
 *  용어의 획일화 를 시켜 서로 다른 나라의 개발 습관을 통일시켰다..
 *  ex) 객체의 인스턴스를 오직 1개만 만드는 패턴 --> "싱글 턴 패턴"
 * */
package oracle;

public class Dog {
	//인스턴스변수라서 static 영역에서는 지금 볼수없다...
	//원천적으로는 강아지의 레퍼런스 변수 알아야 하는데 , 정해져 있지않다..
	//올라가질않아서!!..
	// private Dog instance; 얘 마저도 static 으로하자
	static private Dog instance;
	//은행이 닫으면, 아무도 이용불가하지만 , 단말기 부여한다
	
	//new 에 의한 생성을 막자!!
	private Dog(){
		
	}
	
	static public Dog getInstance() {
		if(instance==null){
			instance = new Dog();
		}
		return instance;
	}
	
}
