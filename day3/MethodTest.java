/*자바언어는 자료형이 총 4개이다
객체자료형도 자료형이다!!
1.기본 자료형
	-기본 자료형을 메서드의 인수로 넘길 때는
	 호출 시 똑같은 값이 복사되어, 값만 넘어간다
	 따라서 해당 값을 보유한 변수는 영향을
	 안받는다!! (call by value) 값만 넘어간다..

2.객체 자료형
	-메서드 호출시 인수로 넘길 데이터가 객체형일 경우
	그 주소값이 넘어가므로, 해당 객체는
	영향을 받는다!! (call by reference)
*/
class MethodTest{
	
	public void test1(Food food){
		food.name="김치볶음밥";
	}
	public static void main(String[] args){
		Food f1=new Food();
		MethodTest mt=new MethodTest();
		//메서드선언위함..
		mt.test1(f1);
		System.out.println(f1.name);
	}
}
