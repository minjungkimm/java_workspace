package gui;
import java.awt.*;
//import java.awt.Label;
// �� �ϼ��ϰ� ��ġ��
class minTest{
	public static void main(String[] args){
		Frame frame=new Frame();
		//������ ����
		//BorderLayout border=new BorderLayout();
		//frame.setLayout(border);
		//������ ��ü�� �������̾ƿ����� ����
		frame.setVisible(true);
		//���̰� ó��
		frame.setSize(400,150);
		//��ư�� ������ ũ�⸦ ������ �� �ִ°��� FlowLayout �����߱⶧��
		Button bt1=new Button("�α���");
		Button bt2=new Button("ȸ������");		
		
		Panel p1=new Panel();
		p1.add(bt1);
		p1.add(bt2);

		frame.add(p1,BorderLayout.SOUTH);
		
		GridLayout grid=new GridLayout(2,6,50,10);

		TextField txt1=new TextField(20);
		TextField txt2=new TextField(20);
		
		txt2.setEchoChar('*');

		Panel p2=new Panel();
		
		Label lb1=new Label("ID");
		Label lb2=new Label("PW");

		//lb1.add("ID");
		//lb2.add("PW");

		p2.add(lb1);
		p2.add(txt1);
		p2.add(lb2);
		p2.add(txt2);
		
		p2.setLayout(grid);
		
		
		frame.add(p2,BorderLayout.CENTER);

		

	}
}
