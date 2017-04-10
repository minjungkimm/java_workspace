class UseLion{
	//클래스안에서 존재하므로 메서드
	public static void main(String[] args){
		//사자 2마리의 인스턴스를 생성하자!!
		//거푸집인 class 로부터 생성되는 단위 = 인스턴스
		int		a	   = 3;		//오른쪽전체를 <객체>
		Lion lion1 = new Lion();
		Lion lion2 = new Lion();
		//실행하면 움직인다..
		System.out.println(a);
		//변수가 객체의 주소값을 담고있을 경우
		//이러한 변수를 가리켜 레퍼런스 변수 reference(언급,참조)라 한다
		//참조 변수는 객체자체를 보유한 것이 아니라, 
		//단지 그 객체가 heap 영역 중 어느 위치에 있는지 
		//그 주소값만을 담고있다
		System.out.println();
	}
}
