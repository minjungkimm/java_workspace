/*String 에 자세히 알아보기*/
package use;


class StringTest1{
	public static void main(String[] args){
		//implicit(묵시적,암시적) 생성법 
		//마치 일반변수처럼 생성하는 기법
		String s1="korea"; //상수풀에 생성되어 모여짐
		String s2="korea"; //중복사항이없고, 하나만들어놓으면 그걸다시이용
		System.out.println(s1.equals(s2)); //equals 연산자사용!! 
		System.out.println(s1==s2); 
		//묵시적 사용법으로 String 객체를 생성하면
		//Constant Pool(상수풀)에 객체가 생성되므로
		//이미 존재하는 문자열 객체일 경우 중복생성하지 않는다..
		//따라서 아래의 비교 연산자는 주소비교였다

		//explicit(명시적) 생성법
		//new에 의한 객체생성법을 그대로 사용한 기법
		String s3=new String("korea"); //레퍼런스 변수 - 주소값 출력 - 서로다름
		String s4=new String("korea");
		
		System.out.println(s3==s4);
	}

}
