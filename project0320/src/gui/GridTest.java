/*GridLayout ��ġ�����ڸ� ����غ���!!
�ڹ��� GUI ������Ʈ�� ũ�� 2������ �з��ȴ�.
1. ���� �����ϴ� �� (�����̳�)
ex) Frame, Panel
>>�����̳ʴ� �ٸ� ������Ʈ�� ��� �÷�������
	��, ��ġ�� ��� ������ ����ϴ� ��ü�̹Ƿ�,
	��� �����̳ʴ� setLayout �̶�� �޼��尡
	�����ǰ� �ִ�...
	���� �����ڰ� �ƹ��͵� �������� ������?
	Frame - BorderLayout 
				�׷��� �Ʊ� ���ʿ� ��չ�ư�� ������..
	Panel - FlowLayout

2. ������ ���Դ��ϴ� �� (�����������Ʈ)
ex)Button, TextField, Checkbox...
*/
package gui;
import java.awt.*; //��θ� ����

class GridTest{

	public static void main(String[] args){
		Frame frame=new Frame("�׸��� ����");
		//������ �����ڿ��� ���� ������ �ִ�
		frame.setVisible(true); //���̰�ó��
		frame.setSize(200,500);
		/*
		������ �ϴٺ���, �⺻�ڷ����� ��ü�ڷ�������
		����ȯ�̶����, �⺻�ڷ��������д� �� �� ����
		����� �����ؾ� �� ��찡 �ִ�.
		�̶� �����Ǵ� Ŭ������ �ٷ� Wrapper
		Ŭ�����ε�, �ڹ��� ��� �⺻�ڷ������� 
		1:1 �����ϴ� Wrapper Ŭ������ �ִ�.

		byte  --> Byte
		short --> Short
		int	    --> Integer
		long  --> Long

		float  --> Float
		double --> Double

		boolean --> Boolean
		char --> Character

		Wrapper Ŭ������ ����
		1) �⺻�ڷ����� ��ü�ڷ������� ����ȯ
		2) �⺻�ڷ����� ������� ���� �پ��ϰ�
			������ ����� ������ ��ü��������
			����÷� ���� ���� �޼���(����� ������)��
			�̿��Ͽ� ������ ó���ϱ� ���� ����...
		
		���� "21"�� �⺻�ڷ������� ��ȯ --> 21
		int a=Integer.parseInt("21");
		
		*/
		//Frame �� ����Ʈ�� BorderLayout �̹Ƿ�,
		//GridLayout �� �����غ���!!
		GridLayout grid=new GridLayout(5,2);
		frame.setLayout(grid);//�׸������� 
		for(int i=1; i<=10; i++){
			//�⺻�ڷ����� ��ü�ڷ������� ���Ž����ش�!!
			Button bt=new Button(Integer.toString(i));
			frame.add(bt);
		}
	}
}
