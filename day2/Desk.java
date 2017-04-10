class Desk{
	//멤버변수 이면서, 인스턴스 변수
	//String color="red";
	//인스턴스 변수라서, 인스턴스가 생성되면서 만들어지는 변수인데..
	//Desk 를 한번도 생성한적이 없으므로.. 밑에 안통함
	//그러나..
	static String color="red";
	//클래스 변수로 만들면 main 메서드도 static , 클래스변수도 static
	//이므로 같은 클래스 원본 안이므로 가능해진다..
	public static void main(String[] args){
		color="yellow";
		System.out.println(color);
	}
}
