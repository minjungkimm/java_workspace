package homeworkk;

import java.io.File;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import javax.swing.JLabel;
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
	File file;
	CopyFile copyfile;
	
	public CopyThread(JProgressBar bar,int count,JTextField t_open,JTextField t_save,File file,CopyFile copyfile){
		this.bar=bar;
		this.count=count;
		this.t_open=t_open;
		this.t_save=t_save;
		this.file=file;
		this.copyfile=copyfile;
		
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
		
			//JOptionPane.showMessageDialog(copyfile,"����Ϸ�");
			
		} catch (FileNotFoundException e) {
			System.out.println("������ ã�� �� �����ϴ�.");
		} catch (IOException e){
			System.out.println("������ ���� �� �����ϴ�.");
		} finally{
			try {
				if(fis!=null){fis.close();}
				if(fos!=null){fos.close();}
			} catch (IOException e) {
				System.out.println("���밡�������ʴ´�");	
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
			bar.setValue(count);
			bar.setMaximum((int)(file.length()));
			//bar.setMaximum((int)(file.length()/1024));
			
		}
	}
}
