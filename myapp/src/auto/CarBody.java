/*�Ʒ��� Ŭ�������� ��������� �� �ڷ�����
��ü���� ��츸 , has a����� �Ѵ�!!
�� ����� �ϸ� �繰�� ������� �Ѵ�..*/
package auto;

public class CarBody{
	//ī�ٵ��� ������� �� 3��, has a������ ���� ���� 2����
	int price; //int �� �ʱ�ȭ �� 0
	Handle h;
	Engine e;
	Wheel w; //��ü�ڷ����� �����Ϸ������� default �ʱ�ȭ ����? null
	//�ƹ��� ��ü�� ����Ű�� ���� ���� ���۷��� ������ null�� �ʱ�ȭ ��
	//null ��?? ���� ���ٴ� ���̴�..
	public CarBody(){
		
		h=new Handle();
		e=new Engine();
		w=new Wheel();

	}
}
