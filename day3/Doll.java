class Doll{
	static String name="���";
	int price;
	
	public Doll(int p){
		price=p;
	}

	public static void main(String[] args){
		Doll.name="�׵𺣾�";  //(��) ����
		Doll d=new Doll();    //(��) ������ ��������
		d.name="�̹�";         //(��) ������ �Ǹ� ����
	}	
}
