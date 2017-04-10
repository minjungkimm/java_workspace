class Doll{
	static String name="라라";
	int price;
	
	public Doll(int p){
		price=p;
	}

	public static void main(String[] args){
		Doll.name="테디베어";  //(가) 가능
		Doll d=new Doll();    //(나) 컴파일 에러사항
		d.name="미미";         //(다) 나번이 되면 가능
	}	
}
