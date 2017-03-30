package game.word;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;


//�α��� ȭ���� ����� Ŭ���� ����!!
public class LoginForm extends JPanel implements ActionListener{
	GameWindow gameWindow; //�갡 �����̾�..
	//�гλ�ӽ���
	JPanel container; //��üborder layout center,south
	JPanel p_center; //�α��� ��GridLayout
	JPanel p_south;// FlowLayout ��ư�� �� ����
	JLabel la_id,la_pw;
	JTextField t_id;
	JPasswordField t_pw;
	JButton bt;
	
	GamePanel gamePanel; //has a����� ����, �α��� �����ϸ� ���� �����Բ�
	
	public LoginForm(GameWindow gameWindow){
		this.gameWindow=gameWindow;
		container = new JPanel();
		p_center = new JPanel();
		p_south = new JPanel();
		la_id = new JLabel("ID");
		la_pw = new JLabel("PW");
		t_id = new JTextField("batman",15);
		t_pw = new JPasswordField("1234",15);
		bt = new JButton("�α���");
		
		container.setLayout(new BorderLayout());
		p_center.setLayout(new GridLayout(2, 2));
		p_center.add(la_id);
		p_center.add(t_id);
		p_center.add(la_pw);
		p_center.add(t_pw);
		p_south.add(bt);
		
		
		container.add(p_center);
		container.add(p_south,BorderLayout.SOUTH);
		
		bt.addActionListener(this);
		
		add(container);
		setPreferredSize(new Dimension(400, 150));
		setBackground(Color.PINK);
		
	}
	
	public void loginCheck(){
		String id=t_id.getText(); //��Ʈ�� 1234�� ��������!!
		String pw=new String(t_pw.getPassword()); //char[] �迭��ȯ
		if(id.equals("batman") && pw.equals("1234")){
			JOptionPane.showMessageDialog(this, "�α��� ����");
			gameWindow.setPage(1);
		}else{ JOptionPane.showMessageDialog(this, "�α��� ������ �ùٸ��� �ʽ��ϴ�.");}
		//��й�ȣ�� ���̵� ���� �ϳ��� Ʋ�� ���� ������شٴ� ���� ��ŷ�� �����ϴ� ���̳� ����������...
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		loginCheck();
		
	}
	
}
