package homeworkk;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JProgressBar;
import javax.swing.JTextField;

public class CopyFile extends JFrame{

	JTextField t_open,t_save;
	JButton bt_open,bt_save;
	JProgressBar bar;
	JFileChooser chooser;
	int count;
	File file;
	CopyFile copyfile;
	
	public CopyFile(){
		copyfile=this;
		bar = new JProgressBar(0,100);
		bt_open = new JButton("����");
		t_open = new JTextField(30);
		bt_save = new JButton("����");
		t_save = new JTextField(30);
		
		bar.setMinimum(0);
		bar.setStringPainted(true);
		bar.setPreferredSize(new Dimension(450, 30));
		
		setLayout(new FlowLayout());
		
		add(bar);
		add(bt_open);
		add(t_open);
		add(bt_save);
		add(t_save);
		
		bt_open.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				open();
			}
		});
		
		bt_save.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				save();

			}
		});
		
		chooser = new JFileChooser("D:/");
		
		setVisible(true);
		setSize(480, 400);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	
	
	private void open() { 
		int state = chooser.showOpenDialog(this);
		if(state==JFileChooser.APPROVE_OPTION){
		File file = chooser.getSelectedFile();
		String path = file.getAbsolutePath();
		t_open.setText(path);
		}
	}
	
	private void save() {
		
		int state = chooser.showSaveDialog(this);
		if(state==JFileChooser.APPROVE_OPTION){
		File file = chooser.getSelectedFile();
		String path= file.getAbsolutePath();
		t_save.setText(path);
		//�޼���ȣ��
		System.out.println("���̺�����µȴ�");
		CopyThread ct = new CopyThread(bar,count, t_open, t_save,file,this);
		
		}
	}
	
	
	public static void main(String[] args) {
		new CopyFile();
		//���ν���δ� �̺�Ʈ ���� 
		//while ���� ���ο��� ���� �ȵ�

	}

}
