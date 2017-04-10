package api;

class UseWrapper{
	public static void main(String[] args){
		Integer i=new Integer("3");
		//문자 "3"을 통해 정수 3을 만든다
		//i=5; //레퍼런스변수라서 원래는 이와 같은 모습 불가능
		       //Wrapper 클래스한해서 가능
			   //기본자료형을 객체자료형으로 받았으므로,
			   //unBoxing (객체자료형에 기본자료형을 받음!!)

		int x=3;
		x=i; //객체자료형을 기본자료형으로 받았으므로,
			   //Boxing (기본자료형에 객체자료형 받음!!)
	}
}
