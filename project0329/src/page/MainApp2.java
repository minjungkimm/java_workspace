package page;

import java.awt.*;

public class MainApp2 extends JFrame implements ActionListener{
	JButton [] menu = new JButton[3];
	JPanel p_north;
	URL[]url=new URL[3];
	String[] path ={"/login.png","/content.png","/etc.png"};
	ImageIcon[] icon = new ImageIcon[3];
	JPanel[] page = new JPanel[3];

	JPanel p_center;
	LoginForm loginform;
	Content content;
	Etc etc;

	public MainApp(){
		p_north = new JPanel();
		p_center = new JPanel();
		for(int i=0; i<path.length; i++){
			url[i]=this.getClass().getResource(path[i]);
			p_north.add(menu[i]);
			menu[i].addActionListener(this);
		}
	
		add(p_north,BorderLayout.NORTH);
		
		p_center = new 
		
	}

	public static void main(String[] args){
		new MainApp2();
	}
}
