/*�������� �Ẹ��!!*/

package use;
import animal.fish.Fish;
import animal.fish.Nimo;
//���� �ٸ� ��Ű���� �ִ� ��θ� ����ϴ� ���

class UseFish{
	public static void main(String[] args){
		Fish f1=new Fish("��ġ");
		Nimo n1=new Nimo();
		System.out.println(f1.equals(n1));

		Object obj=f1;
		//����ȯ �غ���!! ���� �ڷ������� �����ϴ�
		//Fish �� Nimo �� ���� �ڷ����̴�!!
		//f1=n1; //�θ���ڽ�=ū�ڷ����������ڷ���
		//n1=(Nimo)f1;
		//super, this �� �ν��Ͻ�!!! ������ �������
		//System.out.println(super.name);
		n1.swim(); //�ϸ� �����Ŀ�!!
	}
}
