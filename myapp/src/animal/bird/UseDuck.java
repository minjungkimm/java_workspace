package animal.bird;

class UseDuck{
	public static void main(String[] args){
		Duck d=new Duck();
		//부모가 존재해야 자식도 존재하니깐..
		//Duck 이 올라가면, 부모인 Bird 도 올라간다
		d.fly();

		System.out.println(d.name);
	}
}
