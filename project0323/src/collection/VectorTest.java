package collection;
/*참고) List 계열을 사실 우리가 흔히 써왔던 배열과 거의같다
 * 
 * 			   배열		        			  List
 * 크기:  반드시 명시   				선택사항,유연함
 * 대상:  자바기본자료형+객체형   오직객체형
 * 
 * */

import java.util.Vector;

public class VectorTest {

	public static void main(String[] args) {
			//컬렉션 프레임웍 객체에 
			//Generic Type 을 명시하면, 객체가 섞이는 것을
		    //컴파일 타임에 방지해준다!!
		   //Type= 자료형 , 자료형 자리가 넓어지는 것!!
			Vector <String> v=new Vector<String>();
			//암시적 생성법 (스트링 객체)
			v.add("사과");
			v.add("딸기");
			v.add("바나나");
			v.add("오렌지");
			
			for(int i=0; i<v.size(); i++){
			//String obj=(String)v.get(i); //그래서 필요없어진 자료형을 빼준다..
			String obj=v.get(i); //Generic Type 을 선언하면, get 에대면
													//오브젝트에서-> 스트링형으로 바껴져있다.. 
			//버튼과 string 은 맞지않는 타입이다..
			//담을 때는 문제가 없지만 다른 타입이 중간에 낄경우
			//사용할때 에러가 생긴다!!
			//라벨을 붙혀주자!!
			}
		
	}

}
