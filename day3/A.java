/*
override 100%�� ���� ��ġ
overloading �޼��� �̸��� ��ġ (��ȯ�� ���x)
*/
public class A {

	public void doit() {
	}
	//���ʿ��� ��ȯ���� �޸��Ͽ��� ������, �����ε����� ������
	public String doit() {  
		return ��a��;
	}
	//�޼������ �����ϰ�, �μ��ڷ������� ���������� 
	//��ȯ������ �����Ͽ���..(��ȯ������ �����ϸ� �ȵ�)
	public double doit(int x) {
		return 1.0;
	}

}
