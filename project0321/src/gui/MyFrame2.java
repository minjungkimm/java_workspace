package gui;
import java.awt.*;
import javax.swing.JPanel;
import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;

//�׼Ǹ����� ����߰�!!!-> �ϸ� not override ��� �߻�޼��� �ϼ��϶�!!
class MyFrame2 extends JFrame implements ActionListener , KeyListener{
					/*is a����*/        /*is a ����*/
	//������� has a ����
	JPanel p_north;
	JPanel p_west;
	JButton bt;
	JTextArea ta;
	JTextField tf; //t_input

	public MyFrame2(){
	//�����ڸ޼��� has a ������ �ϼ�
	bt=new JButton("Ŭ��");
	ta=new JTextArea(20,30);
	tf=new JTextField(20);
	p_north=new JPanel();
	p_west=new JPanel();
	
	p_north.add(ta);
	p_west.add(bt);
	
	add(p_north,BorderLayout.NORTH);
	add(p_west,BorderLayout.WEST);
	add(ta);
	add(tf);

	//����������� ���۾��� �����Ұ��ΰ�? ��ư�̿�!!
	//��ġ js������ addEventListener()
	//�� ���� �۾����� �����ϸ� �ȴ�
	//��ư�� �����ʿ��� ����//�μ��ȿ��� �������ΰ�ü���´�!!
	bt.addActionListener(this); 
	//������//�����������̴�!!

	setVisible(true);
	setSize(300,400);
	setDefaultCloseOperation(EXIT_ON_CLOSE);

	
	}
	
	//ActionListener�� ����ڰ� ����Ų �̺�Ʈ��
	//ActionEvent ���� �����ϰ�, �� �̺�Ʈ��
	//�����Ǿ��� �� � ó���� ������ �����ڰ�
	//�����ؾ� �ϱ� ������, ActionListener ��
	//������ Ȯ�������� ���� �߻�޼��带 ����
	//��ü�̾�� �ϰ�, �� �������̽��� ��ӹ޴� �ڰ�
	//� Ŭ������ �̹� �ڽ��� ����
	//�����Ƿ�, sun������ �߻�Ŭ������ �ƴ�
	//�������̽��� ���������μ� ���߻����
	//������ ���ذ� �� �ֵ��� �ߴ�!!!
									//Ŭ���ϸ� �μ����� ���´�
	//����������� ���۾��� �����Ұ��ΰ�? ��ư�̿�!!
	public void actionPerformed(ActionEvent e){
		System.out.println("�� ������?");
	}
	
	public static void main(String[] args){
		new MyFrame2();
	
	}
}
