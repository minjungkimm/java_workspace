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
	
	public ChatB(ChatA a){

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

	public void KeyPressed(KeyEvent e){
	
	}
	
	public void KeyReleased(KeyEvent e){
		//e���� keyCode ���� ����
		ChatA chatA=new ChatA();
		int key=e.getKeyCode();
		if(key==KeyEvent.VK_ENTER){
			//����textarea�� input ���� �������
			//msg�� �ؽ�Ʈ��ǲ���� �����°�
			String msg=t_input.getText();
			//textarea�����ٺ�����.(�ؽ�Ʈ��ǲ����)
			chatA.area.append(msg+"\n");
		}
	}

	public void KeyTyped(KeyEvent e){
	
	}
	//���� ȣ���� �� �¾�Ƿ�, ���ν���� ����
}
