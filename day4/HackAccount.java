/*Account Ŭ������ ����Ϸ��� ������ Ŭ����!!*/
class HackAccount{
	public static void main(String[] args){
		//Account Ŭ������ �ν��Ͻ��� ������ �ϱ�
		Account acc=new Account();
		//acc.money=-10000; //������ �����ϴ� ���
		//System.out.println("�ܰ��"+acc.money);
		acc.setMoney(-1000); //�޼���� �����ϴ� ���
		//�ݿ� ���θ� ����غ���!!
		int total=acc.getMoney();
		System.out.println(total);
	}
}
