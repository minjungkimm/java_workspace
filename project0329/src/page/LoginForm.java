package page;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

//�α��� ȭ���� ����� Ŭ���� ����!!
public class LoginForm extends JPanel{
	//�гλ��
	JPanel container; //��üborder layout center,south
	JPanel p_center; //�α��� ��GridLayout
	JPanel p_south;// FlowLayout ��ư�� �� ����
	JLabel la_id,la_pw;
	JTextField t_id;
	JPasswordField t_pw;
	JButton bt;
	
	public LoginForm(){
		container = new JPanel();
		p_center = new JPanel();
		p_south = new JPanel();
		la_id = new JLabel("ID");
		la_pw = new JLabel("PW");
		t_id = new JTextField(15);
		t_pw = new JPasswordField(15);
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
	
		add(container);
		setPreferredSize(new Dimension(700, 500));
		setBackground(Color.red);
		
	}
}
