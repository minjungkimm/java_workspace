/*
GUI���� ������Ʈ�� ���� ���ϴ� ��ġ��
���� ���ؼ��� ��ġ�� �˾ƾ� �Ѵ�.
�ڹ� gui ������ �� 5���� ��ġ�� �����Ѵ�.

1.FlowLayout(��)
2.BorderLayout(��)
3.GridLayout
4.GridBagLayout
5.CardLayout
*/

package gui;
import java.awt.*;

class BorderTest{
	public static void main(String[] args){
		//BorderLayout �� ��������, ���Ͷ��
		//������ ��踦 ���� ���̾ƿ��̴�!!
		Frame frame=new Frame();

		//�������� �ڽ��� ������ ��ġ�����ڸ�
		//�����ϴ� �޼��带 ������!!
		//������ �����ʰ� �ٷ� �����ϸ�, ��ȸ������ ���
		//���������ϴ� ������ ����, ������ �����̱� ������..
		frame.setLayout(new BorderLayout());
		
		frame.setSize(500,400);
		frame.setVisible(true);
		//���ʿ� ��ư ��������!!
		Button bt_north=new Button("����");
		Button bt_east=new Button("����");
		Button bt_south=new Button("����");
		Button bt_west=new Button("����");
		Button bt_center=new Button("�߾�");

		frame.add(bt_north,BorderLayout.NORTH);
		frame.add(bt_east,BorderLayout.EAST);
		frame.add(bt_south,BorderLayout.SOUTH);
		frame.add(bt_west,BorderLayout.WEST);
		frame.add(bt_center,BorderLayout.CENTER);
	}
}
