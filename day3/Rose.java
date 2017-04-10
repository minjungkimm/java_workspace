/*메서드를공부하자
생성자메서드!!
*/
class  Rose{
    int leaf=0;
    String color="red";
    
    public void fall(){
       leaf=0;
    }
}

class  UseRose{
	public static void main(){
	      Rose  r1=new Rose();  //(가) //눈에안보일뿐 존재하는 메서드
		  //new 뒤에 오는 Rose(); 는
		  //생성자메서드!! 클래스와 일치하는 메서드명이어야한다..
	      r1.fall();  //(나) 
	      r1.bloom(); //(다) //존재하지않는 메서드를 호출중..
	}
} 
