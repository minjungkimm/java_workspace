/*String �� �ڼ��� �˾ƺ���*/
package use;


class StringTest1{
	public static void main(String[] args){
		//implicit(������,�Ͻ���) ������ 
		//��ġ �Ϲݺ���ó�� �����ϴ� ���
		String s1="korea"; //���Ǯ�� �����Ǿ� ����
		String s2="korea"; //�ߺ������̾���, �ϳ����������� �װɴٽ��̿�
		System.out.println(s1.equals(s2)); //equals �����ڻ��!! 
		System.out.println(s1==s2); 
		//������ �������� String ��ü�� �����ϸ�
		//Constant Pool(���Ǯ)�� ��ü�� �����ǹǷ�
		//�̹� �����ϴ� ���ڿ� ��ü�� ��� �ߺ��������� �ʴ´�..
		//���� �Ʒ��� �� �����ڴ� �ּҺ񱳿���

		//explicit(�����) ������
		//new�� ���� ��ü�������� �״�� ����� ���
		String s3=new String("korea"); //���۷��� ���� - �ּҰ� ��� - ���δٸ�
		String s4=new String("korea");
		
		System.out.println(s3==s4);
	}

}
