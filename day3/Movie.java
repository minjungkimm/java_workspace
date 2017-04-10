class  Movie{ 
	//멤버변수 2개 , 멤버메서드 3개 (생성자메서드 2개) , 실행부 1개
	String title;
	int price;

	public void Movie(int p){ 
	    price=p;
	}
	public void Movie(String t){ //자료형이 틀린 생성자 오버로딩
           title=t;
	}
	public static void show(){
	    System.out.println("movie start!!");
	}

	public static void main(String[] args){
    	Movie mv1=new Movie();//(가) //존재하지 않는 생성사 호출	
		mv1.show();   //(나)
	}
}
