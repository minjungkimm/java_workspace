package File;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class FileExplorer extends JFrame{
	JPanel p_folder;
	JButton bt;
	ImageIcon icon;
	JLabel la;
	MyPanel mypanel;
	
	public FileExplorer(){
		icon = new ImageIcon("C:/Java_workspace2/project0327/res/folder_on.png");
		bt = new JButton(icon);
		p_folder = new JPanel();
		la = new JLabel("name");
		
		setLayout(new FlowLayout());
		p_folder.setLayout(new BorderLayout());
		
		p_folder.add(la,BorderLayout.NORTH);
		p_folder.add(bt,BorderLayout.CENTER);
		add(p_folder,BorderLayout.NORTH);
		
		
		bt.setBorderPainted(false);
		bt.setContentAreaFilled(false);
		bt.setFocusPainted(false);
		bt.setOpaque(false);
		
		
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(500, 600);
		
	}
	
		
	public static void main(String[] args) {
		new FileExplorer();
	}
}