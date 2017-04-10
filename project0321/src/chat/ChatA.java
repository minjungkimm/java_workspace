/*���� ä���� �����Ѵ�!!
**�̺�Ʈ ������ 3�ܰ�
1. ������ �����ʸ� �����Ͽ� ����(implements)�Ѵ�.
2. �߻� �޼��� ������
3. �����ʿ� ������Ʈ���� ����
*/
package chat;

import java.awt.*;
import javax.swing.JFrame;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;


class ChatA extends JFrame implements ActionListener,KeyListener{
	//�г� 1�� - ��ư , �ؽ�Ʈ������
	//������ ��ũ�Ѱ� �ؽ�Ʈ�ʵ�
	JTextArea area;
	JScrollPane scroll;
	JPanel p_south;
	JTextField t_input;
	JButton bt_open;
	ChatB chatB; //chatB�� has a ����
	ChatC chatC;
	
	public ChatA(){

		area=new JTextArea(20,30);
		scroll=new JScrollPane(area);
		p_south=new JPanel();
		t_input=new JTextField(20);
		bt_open=new JButton("����");
		
		//�ϴ� �гο� ��ư�� �ؽ�Ʈ�Է�â ������
		p_south.add(t_input);
		p_south.add(bt_open);
		//�ϴ��г��� �����ӿ� ������
		add(p_south,BorderLayout.SOUTH);
		
		add(scroll);
		
		//��� ������Ʈ�� �������� ����!!
		//�����ֱ� ������ ���� �غ�� ���¿��� �߰�
		bt_open.addActionListener(this);

		//Ű�����ʿ��� ����//�� ��ü�� �Ͱ� ������ �޸� ����!!
		t_input.addKeyListener(this);

		setVisible(true);
		setBounds(100,100,400,600);
		setDefaultCloseOperation(EXIT_ON_CLOSE);	
		
	}
	
	public void actionPerformed(ActionEvent e){
		//ChatB �ν��Ͻ� �����
		//������� ���� ������ �Ǿ� ChatB������ 
		chatB= new ChatB(this);
		chatC= new ChatC(this);
		t_input.requestFocus(); //Ŀ�� �ø���!!
		//setRequestFocus �޼��带 ���� �ٷ��Է°����ϰ�
		//setInable
	}
	
	public void keyPressed(KeyEvent e){
	
	}

	public void keyReleased(KeyEvent e){
		//e���� �̺�Ʈ������ ������������ ��������Ƿ�,
		//���߿� (�����Ͽ�)��� ��ƾ� �Ѵ�
		//int key=e.getKeyCode();
		//System.out.println(key); ������ Ű�� �� ���
		//����� Field ����ȴ�..
		/*
		key ���� ���͸� ���� �� 10�ΰ� �׽�Ʈ�� ����,
		�츮�� �˰ԵǾ���. ������, �츮�� �ΰ��̱� ������
		10���ٴ� ENTER ��� �ܾ �� �ͼ��ϴ�.
		�̷���, ������ ����� �ַ� ���ȴ�.
		�� �����, �� ���� ������ �ʴ� Ư¡�� �ִ� ��
		�ƴ϶�, ���α׷��ӿ��� ģ���� �ܾ��� �ǹ̸� 
		�ο��ϴ� ������ ���� ũ��!!
		*/
		int key=e.getKeyCode();
		if(key==KeyEvent.VK_ENTER){
			//System.out.println("�����ƾ�?");
			//���� AREA�� t_input�� ���� ����ϰ�
			//\n �� ������� �ٹٲ�!!!
			String msg=t_input.getText();
			area.append(msg+"\n");
			//��� ������
			t_input.setText("");
			//ChatB�� area���� t_input ���� ����Ѵ�.
			chatB.area.append(msg+"\n");
		}
		
	}
		
	public void keyTyped(KeyEvent e){
	
	}
	
	public static void main(String[] args){
		new ChatA();
	}
}
