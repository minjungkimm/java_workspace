package collection;
/*����) List �迭�� ��� �츮�� ���� ��Դ� �迭�� ���ǰ���
 * 
 * 			   �迭		        			  List
 * ũ��:  �ݵ�� ���   				���û���,������
 * ���:  �ڹٱ⺻�ڷ���+��ü��   ������ü��
 * 
 * */

import java.util.Vector;

public class VectorTest {

	public static void main(String[] args) {
			//�÷��� �����ӿ� ��ü�� 
			//Generic Type �� ����ϸ�, ��ü�� ���̴� ����
		    //������ Ÿ�ӿ� �������ش�!!
		   //Type= �ڷ��� , �ڷ��� �ڸ��� �о����� ��!!
			Vector <String> v=new Vector<String>();
			//�Ͻ��� ������ (��Ʈ�� ��ü)
			v.add("���");
			v.add("����");
			v.add("�ٳ���");
			v.add("������");
			
			for(int i=0; i<v.size(); i++){
			//String obj=(String)v.get(i); //�׷��� �ʿ������ �ڷ����� ���ش�..
			String obj=v.get(i); //Generic Type �� �����ϸ�, get �����
													//������Ʈ����-> ��Ʈ�������� �ٲ����ִ�.. 
			//��ư�� string �� �����ʴ� Ÿ���̴�..
			//���� ���� ������ ������ �ٸ� Ÿ���� �߰��� �����
			//����Ҷ� ������ �����!!
			//���� ��������!!
			}
		
	}

}
