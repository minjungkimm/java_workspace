/*�޼��带��������
�����ڸ޼���!!
*/
class  Rose{
    int leaf=0;
    String color="red";
    
    public void fall(){
       leaf=0;
    }
}

class  UseRose{
	public static void main(){
	      Rose  r1=new Rose();  //(��) //�����Ⱥ��ϻ� �����ϴ� �޼���
		  //new �ڿ� ���� Rose(); ��
		  //�����ڸ޼���!! Ŭ������ ��ġ�ϴ� �޼�����̾���Ѵ�..
	      r1.fall();  //(��) 
	      r1.bloom(); //(��) //���������ʴ� �޼��带 ȣ����..
	}
} 
