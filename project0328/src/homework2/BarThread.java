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
	
	//file.length //파일용량
	//286:100% = 5:x%
	//외항   내항       내항  외항
	//500=286x
	//500/286=286x/286
	//x=총용량분의 100%x현재읽은용량
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
			System.out.println("된다");
		}
	}	
}