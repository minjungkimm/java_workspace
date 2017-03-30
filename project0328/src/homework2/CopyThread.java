package homework2;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import javax.swing.JOptionPane;
import javax.swing.JProgressBar;
import javax.swing.JTextField;

public class CopyThread extends Thread{
	JProgressBar bar;
	int count;
	JTextField t_open;
	JTextField t_save;
	
	FileInputStream fis;
	FileOutputStream fos;
	
	public CopyThread(JProgressBar bar,int count,JTextField t_open,JTextField t_save){
		this.bar=bar;
		this.count=count;
		this.t_open=t_open;
		this.t_save=t_save;
		
		System.out.println("������ȴ�");
		start();
		copy();
	}
	
	public void copy(){
		
		//����� ������ �ٷ� ������ �Ѿ������?
		String oriPath= t_open.getText();
		String destPath= t_save.getText();
		
		System.out.println("���������ȵȴ�?");
		try {
			fis = new FileInputStream(oriPath);
			fos = new FileOutputStream(destPath);
			
			int data;
		
			while(true){
				data=fis.read();
				if(data==-1)break;
				fos.write(data);
				System.out.println("��Ʈ�����ȴ�");
			}
		
			//JOptionPane.showMessageDialog(this,"����Ϸ�");
			
		} catch (FileNotFoundException e) {
			System.out.println("������ ã�� �� �����ϴ�.");
		} catch (IOException e){
			System.out.println("������ ���� �� �����ϴ�.");
		} finally{
			try {
				if(fis!=null){fis.close();}
				if(fos!=null){fos.close();}
			} catch (IOException e) {
				System.out.println("���밡�������ʾҽ��ϴ�!!");
				
			}
		}
	}
	
	public void run(){
		while(true){
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			count++;
			bar.setValue();
			bar.setMaximum();
		}
	}
}
