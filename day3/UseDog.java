

class UseDog{
	public static void main(String[] args){
		//강아지 인스턴스 1개 생성!!
		Dog d1=new Dog();

		System.out.println(d1.name);
		System.out.println(d1.getName());
		//선언이 아니라, 사용하고자 하는거니깐 "" 안에넣기
		d1.setName("누렁이","진돗개"); //바꾸고 호출하기!!
		System.out.println(d1.getName());		
	}
}
