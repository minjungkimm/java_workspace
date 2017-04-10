package gui;

import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JPanel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;
import java.awt.*;


//�ӻ����� �ʰ�.. ���ǹݿ��ǰ� �ڵ�
//���� 300 , ���� 400
//���̴� ���� swing
//�Ⱥ��̴� ���� awt
//�� 4���� ���۳�Ʈ
//���� �ۼ��� Ŭ������ �����찡 �Ǿ���ȴ�.. ���� �������!!
//��ü �߽� ����
class MyFrame extends JFrame implements ActionListener , KeyListener{
		//������� �����ϸ�, has a ����
		JPanel p_north;
		JButton bt;
		JTextArea area;
		JTextField t_input;

	//�� �����찡 �¾ �� ���� ��ǰ�鵵
	//���� �¾��!! ������ ��������� ��ǰ�� �پ�;� �ϴϱ�!!
	//����޼���
    public MyFrame(){
		p_north=new JPanel();
		bt=new JButton("Ŭ��");
		area=new JTextArea(20,30);
		t_input=new JTextField(10);
		
		
		p_north.add(bt);
		p_north.add(t_input);

		//�г��� ���� ���ʿ� ������!!
		add(p_north,BorderLayout.NORTH);
		add(area);

		//����������� ���۾��� �����Ұ��ΰ�? ��ư�̿�!!
		//��ġ js������ addEventListener()
		//�� ���� �۾����� �����ϸ� �ȴ�
		//��ư�� �����ʿ��� ����//�μ��ȿ��� �������ΰ�ü���´�!!
		bt.addActionListener(this);
		t_input.addKeyListener(this); 
		//������//�����������̴�!!

		//this. �� ��ǻ� �������ִ�.. 
		setVisible(true);
		setSize(300,400);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	//KeyListener �� �߻�޼��带 �������̵�����

	//Ű ������
	public void keyPressed(KeyEvent e){
		System.out.println("keyPressed");
	}
	//Ű�� ������ ������� ��
	public void keyReleased(KeyEvent e){
		System.out.println("keyReleased");
	}
	//Ÿ�ڸ� ĥ��
	public void keyTyped(KeyEvent e){
		System.out.println("keyTyped");
	}

	public void actionPerformed(ActionEvent e){
		System.out.println("�� ������?");
	}

	public static void main(String[] args){
		new MyFrame();

	}
}
