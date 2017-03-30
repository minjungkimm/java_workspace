package test;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

public class MapTest {
	public static void main(String[] args) {
		HashMap<String,String> map = new HashMap<String,String>();
		//맵은 키값과 밸류값이 존재하며, 제너럴 타입(자료형)도 두개 다 존재한다
		map.put("min1126", "김민정");
		map.put("jun0627","김동준" );
		//맵은 add 가 아닌다 put 으로 넣는다
		
		Set<String> set=map.keySet(); //key 값을 가져온다
		Iterator<String> it=set.iterator();
		//집합체 안에 들어있는 항목에 접근하는 방법제공 (대롱)
		//어떤 요소를 반복적으로 꺼내는 작업 할때 사용한다...
		//인터페이스로 정의된 iterator - 반복자 이안에 있는 메서드 3개는
		//hasNext(), next() , remove()
		//다음요소가 있는지 블리언 값
		//다음요소에 대한 값
		//해당요소를 삭제
		
		while(it.hasNext()){
			String id=it.next(); //키값=아이디는 대롱에 다음값
			String value=map.get(id); //밸류값=맵에서 가져올값 (아이디를 통해)
			System.out.println(value); //밸류값을 프린트한다
		}
	}
}
