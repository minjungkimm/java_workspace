package homework;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JProgressBar;
import javax.swing.JTextField;
//runnable ���� -> run �޼��� ������..
public class CopyMain extends JFrame implements ActionListener,Runnable{
	JProgressBar bar;
	JButton bt_open,bt_save,bt_copy;
	JTextField t_open,t_save;
	JFileChooser chooser; //�̸� new�Ѵ����� �ʿ��� �޼��常 �ҷ����� ��
	File file; //�о���� ����,�������
	Thread thread; //���縦 ������ ���� ������
	//���θ޼���� �츮�� �˰��ִ� ����ζ� �Ҹ��� ���ø����̼��� ���
	//����ϴ� ������ �����Ѵ� , ���� ���� ���ѷ����� 
	//�����¿� ��Ʈ���� ����
	long total; //���� ������ ��ü �뷮 //8byte �ش�Ǵ� long
	
	public CopyMain(){
		bar = new JProgressBar();
		
		bt_open = new JButton("����");
		bt_save = new JButton("����");
		bt_copy = new JButton("�������");
		
		t_open = new JTextField(30);
		t_save = new JTextField(30);
		
		chooser = new JFileChooser("C:/Java_workspace2"); //����Ʈ ���͸�
		
		bar.setPreferredSize(new Dimension(400, 50));
		bar.setStringPainted(true);
		bar.setBackground(Color.yellow);
		bar.setString("0%");
		
		setLayout(new FlowLayout());
		
		add(bar);
		
		add(bt_open);
		add(t_open);
		add(bt_save);
		add(t_save);
		
		add(bt_copy);
		
		//��ư�������ʿ���
		bt_open.addActionListener(this);
		bt_save.addActionListener(this);
		bt_copy.addActionListener(this);
		
		setVisible(true);
		setSize(450,200);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		//���׿������� ���� �ڵ�(��������������)�� ª������ = (if,else if ���� ��ü����(�������� ��������))
		//()�ȿ� �Ǵ������� �´�
		//��ư
		//�̺�Ʈ ����Ų �̺�Ʈ�ҽ�(�̺�Ʈ ��ü)
		Object obj = e.getSource();
		
		if(obj==bt_open){
			open();
		}else if(obj==bt_save){
			save();
		}else if(obj==bt_copy){
			//������ ���� ���縦 �������� ���� 
			//�����忡�� ��Ű��
			//������ �����ڿ� Runnable ������ü��
			//�μ��� ������ , Runnable ��ü����
			//�������� run()�޼��带 �����Ѵ�
			thread = new Thread(this);
			//�츮�� ���� run�� �����ϰ�����
			thread.start(); //���ν���������ִ� run����
		}
	}
	
		public void open(){
			//component �� �ٱ��� ������Ʈ ���ϴ� ��
			//(������â) this �� ������
			int result=chooser.showOpenDialog(this);
			if(result==JFileChooser.APPROVE_OPTION){
				file=chooser.getSelectedFile();
				t_open.setText(file.getAbsolutePath());
				total = file.length();
			}
		}
		
		public void save(){
			
			int result=chooser.showSaveDialog(this);
			if(result==JFileChooser.APPROVE_OPTION){
				File file=chooser.getSelectedFile();
				t_save.setText(file.getAbsolutePath());
			}
		}
		
		public void copy(){
			
			FileInputStream fis=null;
			FileOutputStream fos=null;
			
			try {
				
				fis=new FileInputStream(file); //���Ͽ� ���븦 �žҴ�!!
				fos=new FileOutputStream(t_save.getText()); //������� ����
				
				int data;
				int count=0;
				//������ ��Ʈ���� ���� ������ �б�!!
					while(true){
						data=fis.read();//1byte �� �б� //read�� Ƚ���� �� �뷮
						if(data==-1)break;
						count++;
						fos.write(data);//1byte�� ���
						int v=(int)getPercent(count); //count�ְ� long v�� �޴´�
						//(int) �ǵ��� ��������ȯ�� ��ý�Ŵ!!
						//���α׷����ٿ� ����
						bar.setValue(v);
						bar.setString(v+"%");
					}
					//while �� �Ϸ�Ǹ� ���糡���� ����Ϸ� â ����!!
					JOptionPane.showMessageDialog(this, "����Ϸ�");
				} catch (FileNotFoundException e) {
					e.printStackTrace();
				}  catch (IOException e) {
					e.printStackTrace();
				}finally{
					if(fis!=null){
						try {
							fis.close();
						} catch (IOException e) {
							e.printStackTrace();
						}
					}
					if(fos!=null){
						try {
							fos.close();
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
			}
			
		}	
		
	@Override
	public void run() {
		copy();
		
	}
	
	//���� ������ ���ϱ� ����
	//������= 100%*�����о���ε�����/��üũ��
	public long getPercent(int currentRead){
		return (100*currentRead)/total;
		//int�� long���� �ϴ°� �ս��� �� �Ͼ��..
	}
	
	public static void main(String[] args) {
		new CopyMain();

	}

}
