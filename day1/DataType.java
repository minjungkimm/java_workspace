/*자바도 크게 데이터의 유형을 3가지로 지원한다.
1.문자 char 2(byte)
2.숫자  정수 - byte < short < int < long
					1			2		4		  8
	     실수 - float < double
					4			8
3.논리값 - boolean 1(byte)
*/
class DataType{

	public static void main(String[] args){
		//byte b=-129; //1byte 
		char c='A'; //내부적으로 십진수로 변환됨
		char t=65; //개발자가 십진수로 변환해줌
		//여기서 알수 있는것!
		//자바를 포함한 자료형을 지원하는 대부분의
		//응용 프로그래밍 언어에서 사실상
		//문자형은 없는 것이다!! 즉 전부, 사실
		//문자형이란 곧 숫자였다!!
		int x=3;
		char b=-5;

		//char 형으로는 숫자연산에 사용하지 말자
		//원칙대로 문자를 담는 용도로 쓰자!!
		//char형은 마이너스를 지원하지 않는다.
		//왜?? 키코드값을 보관하기 위함이다..
		//음수를 지원할 필요가 없기 때문에..

		System.out.println(t);
		
	}
}
