class Bird{
   String name=���� ����;
   
   public void fly(){ //�������̵�
      System.out.println(������ ���ƿ�!!��);
   }
}
class Duck extends Bird{
    String name=���� ������;

    public void fly(){ //�������̵�
        System.out.println(�������� ���ƿ�!!��);
    }
}

class  UseTest{
public static void main(String[] args){
        Bird b=new Bird();(��)
        b.fly(); (��) //
        Duck d=new Duck(); (��) //�ö󰡴� �ν��Ͻ� 2��, Duck �������Ϸ��� Bird �� ������ƵǼ�
        d.fly(); (��) //d�� �ڷ����� Duck
		//�����ڷ������� ������ü�� �޴°�.. 
		//�������信 ���ؼ� �߸� �� ������������ �θ�
		//�������ǹ����̸� �𸣴µ� ������ ��Ű�� ������ , ������ ��������
        Bird bb = new Duck(); (��)
        System.out.println(bb.name);
        bb.fly(); (��) //���׷��̵� �ƴ��� �ڽĲ��� �ڽĲ� ȣ��
}
}
