/*Account 클래스를 사용하려는 악의의 클래스!!*/
class HackAccount{
	public static void main(String[] args){
		//Account 클래스의 인스턴스에 나쁜짓 하기
		Account acc=new Account();
		//acc.money=-10000; //변수로 접근하는 방법
		//System.out.println("잔고는"+acc.money);
		acc.setMoney(-1000); //메서드로 접근하는 방법
		//반영 여부를 출력해보자!!
		int total=acc.getMoney();
		System.out.println(total);
	}
}
