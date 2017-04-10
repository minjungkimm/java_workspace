class Bird{
   String name=”난 새”;
   
   public void fly(){ //오버라이드
      System.out.println(”새가 날아요!!”);
   }
}
class Duck extends Bird{
    String name=”난 오리”;

    public void fly(){ //오버라이드
        System.out.println(”오리가 날아요!!”);
    }
}

class  UseTest{
public static void main(String[] args){
        Bird b=new Bird();(가)
        b.fly(); (나) //
        Duck d=new Duck(); (다) //올라가는 인스턴스 2개, Duck 이존재하려면 Bird 도 존재햐아되서
        d.fly(); (라) //d의 자료형은 Duck
		//상위자료형으로 하위객체를 받는것.. 
		//하위개념에 대해서 잘모를 때 상위개념으로 부름
		//강아지뽀미의이름 모르는데 조용히 시키고 싶으면 , 강아지 조용히좀
        Bird bb = new Duck(); (마)
        System.out.println(bb.name);
        bb.fly(); (바) //업그레이드 됐더라도 자식꺼라서 자식꺼 호출
}
}
