package test;

import java.util.Iterator;
import java.util.TreeSet;

public class SetTest {

	public static void main(String[] args) {
		TreeSet<String> set=new TreeSet<String>();
		//�������� ��ü���� ������ set ����
		set.add("���");
		set.add("����");
		//set�� add �� �Ѵ�
		Iterator<String> it=set.iterator();
		
		while(it.hasNext()){
			String e1=it.next();
			System.out.println(e1);
		}
	}

}
