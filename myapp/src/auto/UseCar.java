package auto;

public class UseCar{
	public static void main(String[] args){
		CarBody cb=new CarBody();
		
		cb.h=new Handle();
		cb.e=new Engine();
		cb.w=new Wheel(); //w�� null �� �ȳ�����//������ �ø�
		System.out.println(cb.w);

	}
}
