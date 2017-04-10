package day10;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

class FileCopy{
	FileInputStream fis;

	public FileCopy(){
		try{
			fis=new FileInputStream("C:/htmdl_workspace/images/dorami.png");
			System.out.println("파일을 스트림 생성했습니다.");
		}catch(FileNotFoundException e){
			System.out.println("파일을 찾을 수 없습니다.");
		}
	}

	public static void main(String[] args){
		new FileCopy();
	}
}
