package page;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class MainApp extends JFrame implements ActionListener{
	JButton [] menu=new JButton[3];
	JPanel p_north;
	URL[] url= new URL[3];
	String[] path={"/login.png","/content.png","/etc.png"};
	ImageIcon[] icon = new ImageIcon[3];
	
	
	//페이지들을 has a 관계로 보유한다..
	JPanel p_center; //페이지들이 최종적으로 붙을 FlowLayout 의 패널
	LoginForm loginform;
	Content content;
	Etc etc;
	
	JPanel[] page = new JPanel[3];
	
	public MainApp(){
		p_north = new JPanel();
		p_center = new JPanel();
		for(int i=0; i<path.length; i++){
			url[i]=this.getClass().getResource(path[i]);
			menu[i]= new JButton(new ImageIcon(url[i]));
			p_north.add(menu[i]);	
			menu[i].addActionListener(this); //컴포넌트와 리스너 연결
		}
		
		add(p_north,BorderLayout.NORTH);
		
		p_center = new JPanel();
		p_center.setLayout(new FlowLayout());
		
		//부모의 자료형으로 자식을 가리킬수 있다!!!
		page[0] = new LoginForm();//로그인 폼 생성
		page[1] = new Content();
		page[2] = new Etc();
		
		//컨텐츠 생성 //패널을 두개 붙힌 상태라서, 공존하기위해서 배치관리자를 FlowLayout으로 한 패널이 있고 그위에 둘을 붙혀야 한다..
		p_center.add(page[0]);
		p_center.add(page[1]); //이것도 패널이다!! 갖다붙히자
		p_center.add(page[2]);
		add(p_center);
		//setPreferredSize(new Dimension(700, 500));
		
		
		setSize(700,600);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		Object obj = e.getSource();
		for(int i=0; i<menu.length; i++){
			if(obj == menu[i]){
				 page[i].setVisible(true);
			}else{	 
				page[i].setVisible(false);
			}
		}
		
	}
	
	public static void main(String[] args) {
		new MainApp();

	}

}
