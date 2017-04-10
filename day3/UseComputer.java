class UseComputer { //객체자료형 , 기본자료형
	public void setting(Computer c , int s){
		c.speed=s;
		s=50; //(다)
	}
	
	public static void main(String[] args) {
		int k=500; //(가) //stack 에 500쌓임
		
		UseComputer uc = new UseComputer();
		Computer com = new Computer();//(바) //call by ref

		com.speed=100;
					//주소값 , 500
		uc.setting(com , k); //(나) //call by ref, call by value
		
		System.out.println(com.speed); //(라)
		System.out.println(k); //(마)
		
	}
}