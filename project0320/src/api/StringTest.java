package api;

class StringTest{

	public static void main(String[] args){
		//String �� �Һ��̴� (immutable)
		String str="korea"; //���� (������ ���ÿ� ������) 
		str=str+"fighting"; //�ڸ���+������ (���ο� ���� ������)
		//���� ���� �����ϴ� ���̹Ƿ�, �ּҰ��� ���� ����..
		
		for(int i=1;i<100;i++){
			str=str+i; //for�� ���鼭 ó�����¿��� ������ �ƴ�
			//100���� ���ڿ� ��ü�� �����Ǵ°�..
			//���⼭ korea �� �����ɰ�����
			//���������� ��ǻ��� String �ѹ� �����Ǹ�
			//���� ������� �ʴ� �����!!
			//����� ������� �ʴ´�!!!
		}
		//�ذ�å!) String�� �̿��Ͽ� ���� ���ڿ���
		//�����Ϸ��� �Ҷ��� ��� �ؾ��ϳ�?
		//���氡���� ���ڿ��� ó�����ִ� api �̿�
		StringBuffer sb=new StringBuffer();
		//StringBuffer�� �߰��� ���̸�, ���ο� ���ڿ� �����
		//�������� �ʴ´�.. �� 1���� ���߰���..
		sb.append("korea");
		sb.append("fighting");
		sb.append("and");
		sb.append("forever");
		
		//sb�� String���� �ƴϱ� ������,
		//println �μ��� ������ (�ڵ���ȯ�Ǳ� ������)
		//������� �����Ѵٸ�, String ������ ��ȯ�ؾ� �Ѵ�!!!
		//...Object ��� �ֻ��� ��ü�� ������
		//�޼��� �� ��ü�� String ���� ��ȯ���ִ�
		//�޼��尡 �ִ�.. �ٷ� toString()
		System.out.println(sb.toString());
	}
}
