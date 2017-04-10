/*
생성자 정의 규칙
1) 클래스명과 동일 할 것!
2) 반환형을 두지 말 것!
*/
class Ghost{
	
	String type;
	String color;

	//거푸집에서 귀신을 생성할때 어떤 스타일로
	//생성할지를 아래의 메서드에서 결정
	public void setInit(String type,String color){
		this.type=type;
		this.color=color;

	}

	public static void main(String[] args){
		
		Ghost g1=new Ghost();
		g1.setInit("주온","white");
		System.out.println(g1.type);
		System.out.println(g1.color);
	
	}
}
