/*SUN���� �����ϴ� ������ Ŭ��������
������ ������ API��� �ϸ�, �� API ��ü����
���� ������ ������ API Document ��� �Ѵ�!!*/
package use;
class Test{
	//�ν��Ͻ� ����
	int a=3; //�⺻
	//Dog d; //import ���� ������ ��������!! //��ü
	String s; //import ���� �ʾƵ� �����ȳ�!! //��ü 
	//String Ŭ������ sun���� �����ϴ� �⺻ API ��ü��
	//�ϳ�����! ���� java.lang ��Ű���� ����ۼ� �� �ʹ���
	//�⺻������ �ʿ��� �͵��̹Ƿ�, �����ڰ� import ���� �ʾƵ� �ȴ�!!

	//static �޼��� , �ν��Ͻ� ������ ��������� class ��ü�Ѱܾ���
	public static void main(String[] args){
		Test t= new Test();
		//System.out.println(t.a);
		//��Ʈ�� Ŭ���� ���� //new ����
		//String str="korea";
		//char c=str.charAt(2);
		//System.out.println(c);
		
		String str="korea vs japan";
		//�κ������� substring
		//��ġ�� index Ư�������� ��ġ�� �˾Ƴ��� ���� index of 
		int index=str.indexOf(" ");
		//ù��°�� �߰ߵǴ� ���鹮���� index �� ��ȯ �޴´�
		//str.substring(7,7+5);
		System.out.println("������ index"+index);
		String result=str.substring(index-1, index+5);
		System.out.println(result);
		//System.out.println(c);
		
	}
}
