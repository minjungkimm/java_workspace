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

//로그인 화면을 담당할 클래스 정의!!
public class LoginForm extends JPanel{
	//패널상속
	JPanel container; //전체border layout center,south
	JPanel p_center; //로그인 폼GridLayout
	JPanel p_south;// FlowLayout 버튼이 들어갈 예정
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
		bt = new JButton("로그인");
		
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
