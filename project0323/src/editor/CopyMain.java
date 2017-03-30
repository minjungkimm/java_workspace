package editor;

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
import javax.swing.JTextField;

public class CopyMain extends JFrame implements ActionListener{
	//��ü������ FlowLayout �ش�
	//��ư�� �ؽ�Ʈ�ʵ� ������
	JButton bt_open,bt_save,bt_copy;
	JTextField t_open,t_save;
	
	FileInputStream fis; //���� ������� �� �Է� ��Ʈ��
	FileOutputStream fos; //���� ������� �� ��� ��Ʈ��
	
	//����Ž���⸦ ó���ϴ� ��ü
	JFileChooser chooser;
	

	public CopyMain(){



		bt_open=new JButton("�������");
		bt_save=new JButton("������");
		bt_copy=new JButton("�������");
									
		t_open=new JTextField(30);
		t_save=new JTextField(30); //������ ���ϸ��� �츮�� ���ҰŴϱ� ��α�����
		
		setLayout(new FlowLayout());
		add(bt_open);
		add(t_open);
		add(bt_save);
		add(t_save);
		add(bt_copy);

		//��ư�� ������ ����
		bt_open.addActionListener(this);
		bt_save.addActionListener(this);
		bt_copy.addActionListener(this);

		//���� ������ �̸� �÷�����  //������ ��ȣ�ȿ� ��������Ʈ�� ������ ���丮 ���� ��������!!
		chooser = new JFileChooser("C:/Java_workspace2/project0323");
	
	
		setSize(475,150);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		//������ â�� ������ ���� �����ϴ� ��Ʈ���� �׿��� �ϴµ�
		//������â�� �����鼭 ���α׷� ����Ǿ����
		//������ �����ʿ� ��Ʈ�� ���̴� ���� �����ؾ��Ѵ�.. window Closing
	}
	
	public void actionPerformed(ActionEvent e){
		//e�� �� �����޴��� �ƴ�? //�ټҽ��� ��ư�Ӹ� �ƴ϶� �ٸ���ü���� ���밡���ϴϱ� ������Ʈ������..

		Object obj=e.getSource(); //�̺�Ʈ �ҽ��� ��ȯ �޴´�!!
		
		if(obj == bt_open){
			System.out.println("����");
			open(); //���� ��ư ������ �޼���
		}else if(obj == bt_save){
			System.out.println("����");
			 //���� ��ư ������ �޼���
			int state=chooser.showSaveDialog(this);
			//����� �ΰ����� �������� �ο����ش�
			//��?����ܾ ����ϴϱ�!!...			
			if(state==JFileChooser.APPROVE_OPTION){
			//�����θ� �ؽ�Ʈ�ʵ忡 �������!!!
				File file=chooser.getSelectedFile();
				//����Ŭ������ ������ ������ �޼��带
				//�̿��Ͽ� ��� ��ȯ!!
				String path=file.getAbsolutePath();
				t_save.setText(path);
			}
		}else if(obj == bt_copy){
			copy();
		}
	
	}//�׼��̺�Ʈ ����
	
	//���Ͽ���!!
	public void open(){
						//component parent ����
		int state = chooser.showOpenDialog(this);
		if(state == JFileChooser.APPROVE_OPTION){
			//System.out.println("you choose to open this file :");
			//�ν��Ͻ� ���
			File file=chooser.getSelectedFile();
			//����� �ν��Ͻ��� �̿��Ͽ� ������ ���
			String path=file.getAbsolutePath();
			//t_open.setText(chooser.getSelectedFile().getPath());
			//���� ��� �ؽ�Ʈ�ʵ忡 ����ϱ�
			t_open.setText(path);
		}

	}
	//�����ϱ�!!
	public void copy(){
		//���� ���Ͽ� ��Ʈ�� �����Ͽ�, �����͸� ���̸�����
		//���� �����ʹ� �������Ͽ� ��������!!
		//���� ������ ���۵Ǿ���Ѵ�!!

		
		String oriPath = t_open.getText(); //�Է��� �ؽ�Ʈ�ڽ� �ؽ�Ʈ ��������
		String destPath = t_save.getText(); //�������� ����Ƽ���̼�
		//���� ��Ʈ�� ó���� �����忡�� �Ѵ�!!!!!
		
		try{
			fis = new FileInputStream(oriPath);
			fos = new FileOutputStream(destPath); 
			int data; //�ƹ��͵� �����Ͱ� ���� ���¸� ����..
			//���忡�� �ʱ�ȭ �� ����
			while(true){
				data=fis.read();//���� �������� ���α׷����� 1byte �о����
				if(data==-1)break; //break ���� ������ �ʰ� �ؿ��� �Ѿ�ٸ�, �����Ͱ� ��ȿ�ϴ�!! //���� -1�� break ����������, -1�� ���ڴٴ� �� = ������ ������		
				fos.write(data);
			}

			JOptionPane.showMessageDialog(this,"����Ϸ�");
			//��Ʈ���� ����
			//try ���ȿ��� ���� ��� ������
			//���ܹ߻��� �ٷ� catch �����ΰ��ϱ� close ������� �ʴ´�!!!
			//fis.close();

		}catch(FileNotFoundException e){
			//�갡 ��ư� ��ġ�� ���? ��� ���ðž�?
			JOptionPane.showMessageDialog(this,"������ ã���� �����ϴ�.");
			//catch ���ȿ��� ���� ��� ������
			//fis.close();
		}catch(IOException e){
			JOptionPane.showMessageDialog(this,"IO �۾��� ������ �߻��ߴ�.");
		}finally{
			
			try{
				//��ü�� �޸𸮿� �ö�Դٸ�..
				if(fis!=null){
					fis.close();
				}
				if(fos!=null){
					fos.close();
				}
			}catch(IOException e){
			
			}

		 }
	}
	public static void main(String[] args) {
		new CopyMain();
	
	}

}
