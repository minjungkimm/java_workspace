package test;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

public class MapTest {
	public static void main(String[] args) {
		HashMap<String,String> map = new HashMap<String,String>();
		//���� Ű���� ������� �����ϸ�, ���ʷ� Ÿ��(�ڷ���)�� �ΰ� �� �����Ѵ�
		map.put("min1126", "�����");
		map.put("jun0627","�赿��" );
		//���� add �� �ƴѴ� put ���� �ִ´�
		
		Set<String> set=map.keySet(); //key ���� �����´�
		Iterator<String> it=set.iterator();
		//����ü �ȿ� ����ִ� �׸� �����ϴ� ������� (���)
		//� ��Ҹ� �ݺ������� ������ �۾� �Ҷ� ����Ѵ�...
		//�������̽��� ���ǵ� iterator - �ݺ��� �̾ȿ� �ִ� �޼��� 3����
		//hasNext(), next() , remove()
		//������Ұ� �ִ��� ���� ��
		//������ҿ� ���� ��
		//�ش��Ҹ� ����
		
		while(it.hasNext()){
			String id=it.next(); //Ű��=���̵�� ��տ� ������
			String value=map.get(id); //�����=�ʿ��� �����ð� (���̵� ����)
			System.out.println(value); //������� ����Ʈ�Ѵ�
		}
	}
}
