package collection;

import java.util.Iterator;
import java.util.TreeSet;

/*컬렉션 프레임웍의 유형 2가지중
 *순서없는 객체들의 집합 인 set 유형을 알아보자!!*/
public class setTest {

	public static void main(String[] args) {
		//Set 자식들 중 TreeSet을 사용해본다
		TreeSet<String> set =new TreeSet<String>();
		//추상이 컬렉션을 갖고있기 때문에 add
		set.add("사과");
		set.add("딸기");
		set.add("오렌지");
		//순서없는 것의 반복문이 가능할까? 해보자!!
		//순서없는 것을 순서있게 만든다!! 
		//이걸 가능하게 하는 도우미객체!!
		//**중복되어있는 이름에 대해서는 어떤 패키지 선택할지 창이 뜰수있다..
		//컬렉션 프레임웍의 객체 중 순서없는 객체를 사용하다보면,
		//대량의 처리시 반복문을 직접 사용 할 수 없다는 어려움에 부딪힌다..
		//해결책) 순서없는 것을 --> 순서있게 만들자
		// 	Enumeration(옛날꺼), Iterator(요즘꺼)
		
		//반목문에는 for,while 문이 있다..
		//for문은 시작과 끝값을 수치로 알고 있을때
		//유용하다 1~~256까지
		//while 문은 소괄호안이 true 동안 동작한다
		/* 개발자가 예측할 수 없는 범위가 있을 때 !! 유용하게 쓰인다!!
		 int i=0;
		 
		   while(true){
			i++;
			if(i>=256){
				break;
				}
		}*/		
		Iterator<String> it=set.iterator();
		//위에 트리셋과 별도로 제너럴 타입 또 지정해줘야함
		//if(it.hasNext()==true){}
		while(it.hasNext()){ //hasnext 가 true 인경우만
			String e1=it.next(); //다음 요소에 접근!!
			//다음요소가 있니? 있다! 다음요소로 옮겨가고 그 요소를 반환시킨다!!
			//다음요소가 있니? 없다.. 다음요소가 없으므로 while 문에서 빠져나온다!!
			//순서가 없으니깐 랜덤으로 될것이다.. 순서가 중요하지 않은개발에 사용된다!!
			System.out.println(e1);
		}	
	}

}
