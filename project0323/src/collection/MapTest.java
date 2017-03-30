/*컬렉션 프레임웍 중 순서없는 객체들을
 * key-value 쌍으로 관리하는 Map 을 학습한다
 * */
package collection;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

public class MapTest {
	public static void main(String[] args) {
		HashMap<String,String> map=new HashMap<String,String>();
		//복주머니가 있으면, 그 안에 있는 것을 꺼낼 때는 순서가 없지만
		//물체 하나하나에 key 값이 붙어있다.. key 값이 문자로 갈지 숫자로 갈지 정해야함
		//실제 value 값도 정해야한다..
		map.put("min1126", "김민정");
		map.put("jun0627", "김동준");
		map.put("hyun0110", "김현직");
		
		
		//String obj=map.get("jun0627"); //key 값으로 객체를 탐색할수있다..
		//System.out.println(obj);
		//모든객체를 출력하라!!
		//HashMap 도 순서가 없다 순서있게 만들자!!
		Set<String> set=map.keySet(); //key값을 다가져온다
									//entrySet() 을 쓰면 key,value값 둘다가져옮
		Iterator<String>it= set.iterator();
		
		while(it.hasNext()){
			String id=it.next(); 
			String value=map.get(id);
			System.out.println(value);
		}
	}

}
