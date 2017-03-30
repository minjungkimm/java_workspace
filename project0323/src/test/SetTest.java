package test;

import java.util.Iterator;
import java.util.TreeSet;

public class SetTest {

	public static void main(String[] args) {
		TreeSet<String> set=new TreeSet<String>();
		//순서없는 객체들의 집합인 set 유형
		set.add("사과");
		set.add("딸기");
		//set은 add 로 한다
		Iterator<String> it=set.iterator();
		
		while(it.hasNext()){
			String e1=it.next();
			System.out.println(e1);
		}
	}

}
