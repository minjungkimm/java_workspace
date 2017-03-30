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


//로그인 화면을 담당할 클래스 정의!!
public class LoginForm extends JPanel implements ActionListener{
	GameWindow gameWindow; //얘가 주인이야..
	//패널상속시작
	JPanel container; //전체border layout center,south
	JPanel p_center; //로그인 폼GridLayout
	JPanel p_south;// FlowLayout 버튼이 들어갈 예정
	JLabel la_id,la_pw;
	JTextField t_id;
	JPasswordField t_pw;
	JButton bt;
	
	GamePanel gamePanel; //has a관계로 선언, 로그인 성공하면 게임 나오게끔
	
	public LoginForm(GameWindow gameWindow){
		this.gameWindow=gameWindow;
		container = new JPanel();
		p_center = new JPanel();
		p_south = new JPanel();
		la_id = new JLabel("ID");
		la_pw = new JLabel("PW");
		t_id = new JTextField("batman",15);
		t_pw = new JPasswordField("1234",15);
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
		
		bt.addActionListener(this);
		
		add(container);
		setPreferredSize(new Dimension(400, 150));
		setBackground(Color.PINK);
		
	}
	
	public void loginCheck(){
		String id=t_id.getText(); //배트맨 1234만 승인하자!!
		String pw=new String(t_pw.getPassword()); //char[] 배열반환
		if(id.equals("batman") && pw.equals("1234")){
			JOptionPane.showMessageDialog(this, "로그인 성공");
			gameWindow.setPage(1);
		}else{ JOptionPane.showMessageDialog(this, "로그인 정보가 올바르지 않습니다.");}
		//비밀번호나 아이디 둘중 하나만 틀린 것을 명시해준다는 것은 해킹을 유도하는 짓이나 마찬가지다...
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		loginCheck();
		
	}
	
}
