/*물고기들을 써보자!!*/

package use;
import animal.fish.Fish;
import animal.fish.Nimo;
//나와 다른 패키지에 있는 경로를 명시하는 방법

class UseFish{
	public static void main(String[] args){
		Fish f1=new Fish("삼치");
		Nimo n1=new Nimo();
		System.out.println(f1.equals(n1));

		Object obj=f1;
		//형변환 해보자!! 같은 자료형끼리 가능하다
		//Fish 와 Nimo 는 같은 자료형이다!!
		//f1=n1; //부모와자식=큰자료형과작은자료형
		//n1=(Nimo)f1;
		//super, this 는 인스턴스!!! 내에서 사용하자
		//System.out.println(super.name);
		n1.swim(); //니모가 수영쳐요!!
	}
}
