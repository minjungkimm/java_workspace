package day10;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

class FileCopy{
	FileInputStream fis;

	public FileCopy(){
		try{
			fis=new FileInputStream("C:/htmdl_workspace/images/dorami.png");
			System.out.println("������ ��Ʈ�� �����߽��ϴ�.");
		}catch(FileNotFoundException e){
			System.out.println("������ ã�� �� �����ϴ�.");
		}
	}

	public static void main(String[] args){
		new FileCopy();
	}
}
