public class Desk {
	int x; //인스턴스 소속 //멤버변수한해서 default 값 =0;
	static int y; //클래스 소속 //멤버변수한해서 default 값 =0;
	
	{ /*
		A - 안스턴스 초기화 블럭!!
		 - 이클래스로부터 인스턴스가 생성될때마다,
		 호출되는 영역, 즉 인스턴스의 초기화 담당!!
		 누군가가 new Desk 할때 동작된다
		 x의 default 값에 for문 돈다..
		*/
		for(int i=0;i<10;i++){
			x++;
		}
	}
	
		
	static { /*B static 초기화 블럭
		이 클래스의 바이트 코드가 static 으로 Load 될때
		호출되는 영역
		*/
		for(int i=0;i<20;i++){
			y++;
		}
	}
	
	public static void main(String[] args){
		//System.out.println(x); //C
		//x는 인스턴스변수인데, 초기화 되지않아서..
		//int a는 데스크자체가 아니라 데스크.x값이므로 10인거고
		//스택에 쌓인당
		int a=new Desk().x; //D
		//인스턴스 데스크가 가진 x의 값=10(for문돌아서 x값이 10으로초기화)
		System.out.println(a); //E
		System.out.println(y); //F
		
	}
}


