

class UseDog{
	public static void main(String[] args){
		//������ �ν��Ͻ� 1�� ����!!
		Dog d1=new Dog();

		System.out.println(d1.name);
		System.out.println(d1.getName());
		//������ �ƴ϶�, ����ϰ��� �ϴ°Ŵϱ� "" �ȿ��ֱ�
		d1.setName("������","������"); //�ٲٰ� ȣ���ϱ�!!
		System.out.println(d1.getName());		
	}
}
