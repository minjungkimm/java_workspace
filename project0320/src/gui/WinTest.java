/*
�ڹپ��ε� GUI(Graphic User Interface):
(�׷��������� ���ø����̼��� ����� �� �ֵ���
�����ϴ� ȯ��!!)
���ø����̼��� ������ �� �ִ�.
�׸��� �ڹٸ� ���� ���� �� �ִ� ��ȸ, �����̴�.

��� �׷��� ���α׷��� ������󿡼� ����ǹǷ�,
�ڹٿ��� �����츦 ���� ���� �����!!
*/
package gui;

import java.awt.Frame;
import java.awt.Button;
import java.awt.TextField;
import java.awt.FlowLayout; //��ġ������
import java.awt.Color;
import java.awt.Checkbox;
import java.awt.Choice;
import java.awt.CheckboxGroup;
import java.awt.TextArea;

class WinTest{
	public static void main(String[] args){
		Frame frame=new Frame();
		//������Ʈ�� �ʹ� ������� ��������Ƿ�
		//�� ������ �ذ��ϱ� ���� ���̾ƿ���
		//�����Ѵ�.. (�̵��� ������)
		FlowLayout flow=new FlowLayout();
		frame.setLayout(flow);

		//�������ؼ� �����ϸ� cmd �� �ƹ��͵� ����������
		//�������� ����Ʈ�� ������ �ʴ� �Ӽ�����
		//���� ���̰� ó������!!
		frame.setVisible(true);
		//â�̳����� ������ ũ�⸦ �����������
		frame.setSize(800,800);
		frame.setTitle("����������");

		Button bt; //��ü�� default ���� null
						//�޸𸮿ø��ٰ� �ϸ� �����ں���!!
		bt=new Button("�չ�ư");
		
		frame.add(bt);

		//�ؽ�Ʈ �Է¹ڽ� ����         //����ĭ��
		TextField txt=new TextField(20);

		frame.add(txt);

		//�����쿡 ���� ����!!
		//���� ó������ ��ü�� ���� ��ó��
		/*
		�ڹ��� ��� ��ü�� �ᱹ �Ϲ�,�߻�,�������̽�
		�� �ϳ��̴�.
		����, ó������ ��ü�� ������ �ᱹ �޸𸮿�
		�÷��� ����϶�� �ذ� �̱� ������..
		�� �� ��� ���̽��� ���ϴ��� ���� ������ �� 
		�� ��ü�� �°� �޸𸮿� �ø���!!
		1) �Ϲ� - new ����
		2) �߻� - �ڽ��� new ����
		3) �������̽� - implements �� �ڽ��� new ����
		�ٵ�, �� ����� 2,3���� �� �ڽĵ��� new ���� �ʴ���
		�����ϴ� ����� api ���� �����ϴ� ��찡 �� ����...
		*/
		Color c=new Color(0,0,255);
		frame.setBackground(c);

		//üũ�ڽ� ����
		Checkbox ch1=new Checkbox("����");
		Checkbox ch2=new Checkbox("����");
		Checkbox ch3=new Checkbox("����");
		Checkbox ch4=new Checkbox("�");
		
		frame.add(ch1);
		frame.add(ch2);
		frame.add(ch3);
		frame.add(ch4);

		//html�� select �� �ڹٿ����� Choice �� �Ѵ�
		//��� ���� �ٳ���

		Choice choice=new Choice();

		choice.add("���"); 

		frame.add(choice); //�����ӿ� ����!!

		//radio box �̿��Ͽ� ���ฦ üũ�Ѵ�!!
		//����) java������ Radio �� ��ü�� ����!!
		//Checkbox�� �׷�ȭ ���Ѿ��Ѵ�..

		CheckboxGroup cbg=new CheckboxGroup();

		Checkbox c1=new Checkbox("��",cbg,false);
		Checkbox c2=new Checkbox("��",cbg,true);
		
		frame.add(c1);
		frame.add(c2);

		//TextArea ����
		
		TextArea txa=new TextArea("Hello",5,40);
		frame.add(txa);
	}
}
