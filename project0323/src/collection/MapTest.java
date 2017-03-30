/*�÷��� �����ӿ� �� �������� ��ü����
 * key-value ������ �����ϴ� Map �� �н��Ѵ�
 * */
package collection;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

public class MapTest {
	public static void main(String[] args) {
		HashMap<String,String> map=new HashMap<String,String>();
		//���ָӴϰ� ������, �� �ȿ� �ִ� ���� ���� ���� ������ ������
		//��ü �ϳ��ϳ��� key ���� �پ��ִ�.. key ���� ���ڷ� ���� ���ڷ� ���� ���ؾ���
		//���� value ���� ���ؾ��Ѵ�..
		map.put("min1126", "�����");
		map.put("jun0627", "�赿��");
		map.put("hyun0110", "������");
		
		
		//String obj=map.get("jun0627"); //key ������ ��ü�� Ž���Ҽ��ִ�..
		//System.out.println(obj);
		//��簴ü�� ����϶�!!
		//HashMap �� ������ ���� �����ְ� ������!!
		Set<String> set=map.keySet(); //key���� �ٰ����´�
									//entrySet() �� ���� key,value�� �Ѵٰ�����
		Iterator<String>it= set.iterator();
		
		while(it.hasNext()){
			String id=it.next(); 
			String value=map.get(id);
			System.out.println(value);
		}
	}

}
