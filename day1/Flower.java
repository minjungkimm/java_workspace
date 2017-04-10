/*
꽃을 정의해보자!!
속성들 : 색상, 향기 (변수)
동작들 : 핀다, 진다 (함수 지만, 명칭은 메서드)
*/
class Flower{
	String color="빨강";
	String scent="향기";
	int leaf=20;
	boolean isMan=true; 
	
	//피는 행위를 표현한 메서드
	public void open(){
		System.out.println("꽃이핍니다.");
	}
	
	//지는 행위를 표현한 메서드
	public void close(){
		System.out.println("꽃이집니다.");
	}
}
