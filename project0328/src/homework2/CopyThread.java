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
		
		System.out.println("쓰레드된다");
		start();
		copy();
	}
	
	public void copy(){
		
		//여기로 오지만 바로 끝나고 넘어가버린다?
		String oriPath= t_open.getText();
		String destPath= t_save.getText();
		
		System.out.println("시작조차안된다?");
		try {
			fis = new FileInputStream(oriPath);
			fos = new FileOutputStream(destPath);
			
			int data;
		
			while(true){
				data=fis.read();
				if(data==-1)break;
				fos.write(data);
				System.out.println("스트림도된다");
			}
		
			//JOptionPane.showMessageDialog(this,"복사완료");
			
		} catch (FileNotFoundException e) {
			System.out.println("파일을 찾을 수 없습니다.");
		} catch (IOException e){
			System.out.println("파일을 읽을 수 없습니다.");
		} finally{
			try {
				if(fis!=null){fis.close();}
				if(fos!=null){fos.close();}
			} catch (IOException e) {
				System.out.println("빨대가닫히지않았습니다!!");
				
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
