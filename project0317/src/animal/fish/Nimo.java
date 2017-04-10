/*
자바의 자료형은 총 4개이며, 객체자료형도 자료형이다
따라서 기본 자료형에서의 형변환의 원칙이 
객체자료형에도 적용된다!!*/
package animal.fish;

public class Nimo extends Fish{
						  /*is a 관계 : 상속관계가 같은 자료형으로 만든다*/
	public String name="난 니모야";
	
	public Nimo(){
		super("참치");
	}
	
	public void swim(){
		System.out.println(super.name+"가 수영쳐요!!");
	}
}
