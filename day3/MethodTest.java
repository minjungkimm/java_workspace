/*�ڹپ��� �ڷ����� �� 4���̴�
��ü�ڷ����� �ڷ����̴�!!
1.�⺻ �ڷ���
	-�⺻ �ڷ����� �޼����� �μ��� �ѱ� ����
	 ȣ�� �� �Ȱ��� ���� ����Ǿ�, ���� �Ѿ��
	 ���� �ش� ���� ������ ������ ������
	 �ȹ޴´�!! (call by value) ���� �Ѿ��..

2.��ü �ڷ���
	-�޼��� ȣ��� �μ��� �ѱ� �����Ͱ� ��ü���� ���
	�� �ּҰ��� �Ѿ�Ƿ�, �ش� ��ü��
	������ �޴´�!! (call by reference)
*/
class MethodTest{
	
	public void test1(Food food){
		food.name="��ġ������";
	}
	public static void main(String[] args){
		Food f1=new Food();
		MethodTest mt=new MethodTest();
		//�޼��弱������..
		mt.test1(f1);
		System.out.println(f1.name);
	}
}
