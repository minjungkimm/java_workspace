class DataType{ 
	
	public static void main(String[] args){
		//자바스크립트와는 달리, 변수 선언시 개발자가 메모리 용량을 결정하게 된다..
		//byte b=3;
		//int x=7;

		/*
		cpu는 연산수행시, 피연산자의 데이터 자료형이 반드시 동일할때만 연산을 수행한다.
		따라서, 아래와 같이 자료형이 동일하지 않은 경우엔 개발자에게 허락을 맡지 않고, 자동으로 
		형을 변환해버린다..
		단, 자동형변환은 데이터의 손실이 발생하지 않는다는 보장하에서만 실시된다..
		*/
		//x=b; //(가)
		//	b=(byte)x; //(나)강제형 변환
		//강제 형변환은 작은 자료형에 큰 자료형의 데이터를 대입하고자 할때, 데이터의 손실이 예상될 수 있으므로
		//컴파일러에게 감안하겠다는 의사표현이다!! 
		//이때 사용되는 소괄호()를 cast연산자라 한다

		float x=3.14f;
	}
}
	

