class  Movie{ 
	//������� 2�� , ����޼��� 3�� (�����ڸ޼��� 2��) , ����� 1��
	String title;
	int price;

	public void Movie(int p){ 
	    price=p;
	}
	public void Movie(String t){ //�ڷ����� Ʋ�� ������ �����ε�
           title=t;
	}
	public static void show(){
	    System.out.println("movie start!!");
	}

	public static void main(String[] args){
    	Movie mv1=new Movie();//(��) //�������� �ʴ� ������ ȣ��	
		mv1.show();   //(��)
	}
}
