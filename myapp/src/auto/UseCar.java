package auto;

public class UseCar{
	public static void main(String[] args){
		CarBody cb=new CarBody();
		
		cb.h=new Handle();
		cb.e=new Engine();
		cb.w=new Wheel(); //w가 null 이 안나오게//바퀴를 올림
		System.out.println(cb.w);

	}
}
