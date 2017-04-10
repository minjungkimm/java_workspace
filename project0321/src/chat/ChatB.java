/*���� ä���� �����Ѵ�!!*/
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



class ChatB extends JFrame implements ActionListener,KeyListener{
	//�г� 1�� - ��ư , �ؽ�Ʈ������
	//������ ��ũ�Ѱ� �ؽ�Ʈ�ʵ�
	JTextArea area;
	JScrollPane scroll;
	JPanel p_south;
	JTextField t_input;
	ChatA chatA;
	ChatC chatC;
	
	public ChatB(ChatA a,ChatC c){

		area=new JTextArea(20,30);
		scroll=new JScrollPane(area);
		p_south=new JPanel();
		t_input=new JTextField(20);
		chatA=a;
		
		//�ϴ� �гο� ��ư�� �ؽ�Ʈ�Է�â ������
		p_south.add(t_input);
		//�ϴ��г��� �����ӿ� ������
		add(p_south,BorderLayout.SOUTH);
		
		add(scroll);
		//������� �غ� �Ϸ�� �� �̺�Ʈ �߰�
		t_input.addKeyListener(this);

		setVisible(true);
		setBounds(400,100,400,600);
		//������Ŭ������۷��̼� ������ �������� �ٰ��� ���α׷�
		//�������� �����ؼ�..
	}

	public void actionPerformed(ActionEvent e){
		//ChatB �ν��Ͻ� �����
		//������� ���� ������ �Ǿ� ChatB������ 
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
			chatA.area.append(msg+"\n");
		}
		
	}

	public void keyTyped(KeyEvent e){
	
	}
	//���� ȣ���� �� �¾�Ƿ�, ���ν���� ����
}
