/*�ڹ��� �׷��� ��ü���� awt���� ����������
awt �� OS�� ���� �� ����� �޶����� ������ �ֱ� ������
�̸� ������ GUI ������Ʈ ��Ű���� swing �̴�, �δ㰮�� ����
awt�� ���α׷� ����� �޶����� ���� ����, ���� ��Ű�����
Ŭ�������� �� �޶�����!!

����)awt�� ���� �������� �ʴ� �κ��̳�
	(��ġ������ ��)
�̺�Ʈ �����ÿ� ������ ���ȴ�..
���)GUI ���α׷��� awt + swing ����
*/
/*
���߽� ����Ģ
1.Ŭ����
	- ���� �ܾ�� �ݵ�� �빮�ڷ� �����϶�!!
	- 2���̻��� ���վ��� ��� ��Ÿ����� �̿��϶�!!
2.�޼���
    - �޼������ �ݵ�� �ҹ��ڷ� �����϶�!!
3.����
	- �ҹ��ڷ� ���� �� ��
	- Ư�����ڷ� �������� �� ��
	(���� - �����(_), $�� ����)
	-���ڷ� ���� �Ұ� (ex : 2x=3)
4.���
	- ��� �빮�ڷ� ǥ���� ��
	*��Ӿ��� ������ �ȳ�����, �ٸ������ڰ� �Ϲݺ������� �˰�
	ȥ���Ѵ�!!!
5.���۷��� ���� ���� �� �ҹ��ڷ� �� ��

*/
package gui;
import javax.swing.JFrame;
import javax.swing.JPasswordField;
import java.awt.FlowLayout;
import javax.swing.JButton;

class SwingTest{
	public static void main(String[] args){
		JFrame frame;
		JPasswordField t_pass;
		
		frame=new JFrame("�� ������ ������");
		t_pass=new JPasswordField(20);
		JButton bt=new JButton("�� ������");
		
		//���������� ���̾ƿ������� �ٲٱ�
		frame.setLayout(new FlowLayout());
		frame.add(t_pass);
		frame.add(bt);

		//������ â�� ������, ���α׷� �� ���μ���
		//�� ���̴� �޼��� ȣ��
		//������ ������ ���� �ݵ�� �־�����!!
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		frame.setSize(300,400);

		frame.setVisible(true);		
		
	}
}
