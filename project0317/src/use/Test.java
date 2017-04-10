/*SUN에서 제공하는 수많은 클래스들의
집합을 가리켜 API라고 하며, 이 API 객체들의
대한 설명서를 가리켜 API Document 라고 한다!!*/
package use;
class Test{
	//인스턴스 변수
	int a=3; //기본
	//Dog d; //import 하지 않으면 에러난다!! //객체
	String s; //import 하지 않아도 에러안남!! //객체 
	//String 클래스도 sun에서 제공하는 기본 API 객체중
	//하나였다! 또한 java.lang 패키지는 언어작성 시 너무나
	//기본적으로 필요한 것들이므로, 개발자가 import 하지 않아도 된다!!

	//static 메서드 , 인스턴스 변수를 끌어오려면 class 객체넘겨야함
	public static void main(String[] args){
		Test t= new Test();
		//System.out.println(t.a);
		//스트링 클래스 선언 //new 빼고
		//String str="korea";
		//char c=str.charAt(2);
		//System.out.println(c);
		
		String str="korea vs japan";
		//부분추출은 substring
		//위치는 index 특정문자의 위치를 알아내는 것은 index of 
		int index=str.indexOf(" ");
		//첫번째로 발견되는 공백문자의 index 를 반환 받는다
		//str.substring(7,7+5);
		System.out.println("공백의 index"+index);
		String result=str.substring(index-1, index+5);
		System.out.println(result);
		//System.out.println(c);
		
	}
}
