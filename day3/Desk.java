public class Desk {
	int x; //�ν��Ͻ� �Ҽ� //����������ؼ� default �� =0;
	static int y; //Ŭ���� �Ҽ� //����������ؼ� default �� =0;
	
	{ /*
		A - �Ƚ��Ͻ� �ʱ�ȭ ��!!
		 - ��Ŭ�����κ��� �ν��Ͻ��� �����ɶ�����,
		 ȣ��Ǵ� ����, �� �ν��Ͻ��� �ʱ�ȭ ���!!
		 �������� new Desk �Ҷ� ���۵ȴ�
		 x�� default ���� for�� ����..
		*/
		for(int i=0;i<10;i++){
			x++;
		}
	}
	
		
	static { /*B static �ʱ�ȭ ��
		�� Ŭ������ ����Ʈ �ڵ尡 static ���� Load �ɶ�
		ȣ��Ǵ� ����
		*/
		for(int i=0;i<20;i++){
			y++;
		}
	}
	
	public static void main(String[] args){
		//System.out.println(x); //C
		//x�� �ν��Ͻ������ε�, �ʱ�ȭ �����ʾƼ�..
		//int a�� ����ũ��ü�� �ƴ϶� ����ũ.x���̹Ƿ� 10�ΰŰ�
		//���ÿ� ���δ�
		int a=new Desk().x; //D
		//�ν��Ͻ� ����ũ�� ���� x�� ��=10(for�����Ƽ� x���� 10�����ʱ�ȭ)
		System.out.println(a); //E
		System.out.println(y); //F
		
	}
}


