/*
������ ���� ��Ģ
1) Ŭ������� ���� �� ��!
2) ��ȯ���� ���� �� ��!
*/
class Ghost{
	
	String type;
	String color;

	//��Ǫ������ �ͽ��� �����Ҷ� � ��Ÿ�Ϸ�
	//���������� �Ʒ��� �޼��忡�� ����
	public void setInit(String type,String color){
		this.type=type;
		this.color=color;

	}

	public static void main(String[] args){
		
		Ghost g1=new Ghost();
		g1.setInit("�ֿ�","white");
		System.out.println(g1.type);
		System.out.println(g1.color);
	
	}
}
