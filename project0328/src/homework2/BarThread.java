package homework2;

import java.io.FileInputStream;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import javax.swing.JOptionPane;
import javax.swing.JProgressBar;
import javax.swing.JTextField;

public class BarThread extends Thread{
	int count;
	JProgressBar bar;
	JTextField t_open;
	JTextField t_save;
	FileInputStream fis;
	FileOutputStream fos;
	
	public BarThread(int count,JProgressBar bar,JTextField t_open,JTextField t_save){
		this.count=count;
		this.bar=bar;
		this.t_open=t_open;
		this.t_save=t_save;
		start();
		copy();
	}
	
	//file.length //���Ͽ뷮
	//286:100% = 5:x%
	//����   ����       ����  ����
	//500=286x
	//500/286=286x/286
	//x=�ѿ뷮���� 100%x���������뷮
	public void copy(){
			
		String oriPath= t_open.getText();
		String destPath= t_save.getText();
		
		try {
			fis = new FileInputStream(oriPath);
			fos = new FileOutputStream(destPath);
			
			int data;
		
			while(true){
				data=fis.read();
				if(data==-1)break;
				fos.write(data);
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
		
				
			}
		}
	}
	
	@Override
	public void run() {
		while(true){
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println("�ȴ�");
		}
	}	
}