class UseComputer { //��ü�ڷ��� , �⺻�ڷ���
	public void setting(Computer c , int s){
		c.speed=s;
		s=50; //(��)
	}
	
	public static void main(String[] args) {
		int k=500; //(��) //stack �� 500����
		
		UseComputer uc = new UseComputer();
		Computer com = new Computer();//(��) //call by ref

		com.speed=100;
					//�ּҰ� , 500
		uc.setting(com , k); //(��) //call by ref, call by value
		
		System.out.println(com.speed); //(��)
		System.out.println(k); //(��)
		
	}
}