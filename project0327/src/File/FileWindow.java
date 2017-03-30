/*
 * 클래스는 코드의 재사용성 때문에 나온 기술이다.
 * */
package File;

//패키지를 기준으로 디렉토리를 접근하는 방법
//자바에서는 클래스패스에 이미지도 넣을수가 있다.
//오른쪽 클릭 bulid path
import java.awt.FlowLayout;
import java.io.File;
import java.util.ArrayList;

import javax.swing.JFrame;

public class FileWindow extends JFrame{
	MyIcon folder_on,folder_off;

	
	public FileWindow(){
		
		setLayout(new FlowLayout());
		//이미지 아이콘을 생성하되, 리소스 폴더로 부터..
		//Uniformed Resource Locator : 
		//URL url=this.getClass().getResource("/folder_on.png");
		folder_on = new MyIcon(this.getClass().getResource("/folder_open.png"),50,50);
		folder_off = new MyIcon(this.getClass().getResource("/folder_on.png"),50,50);
		//아이콘으로부터 이미지를 얻어와서 객체화한 이미지를 조정한다..
		//Image scaledImg=folder_on.getImage();
		
		//크기를 재조정한 후 결과적으로 이미지 객체를 다시 반환받자
		//Image result=scaledImg.getScaledInstance(50, 50, Image.SCALE_SMOOTH);
		//크기를 조정하는데 부드럽게 셋팅해줄것이다..
		
		//재조정된 이미지를 아이콘에 다시 반영
		//folder_on.setImage(result);
		
		ArrayList<String>list = getDirList();
		
		for(int i=0; i<list.size(); i++){
			String dirName=list.get(i);
			//제대로 붙을지 테스트
			MyPanel mp=new MyPanel(dirName, folder_off);
			add(mp);
		}
		
		setSize(600,500);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	
	}
	
	//원하는 경로의 하위 디렉토리/파일 구하기
	public ArrayList getDirList(){
		File file = new File("c:/");
		
		File[] fileList=file.listFiles();
		ArrayList<String> dirList=new ArrayList<String>();
		
		//디렉토리만 골라내자!!
		for(int i=0; i<fileList.length; i++){
			if(fileList[i].isDirectory()){
				//디렉토리가 발견될 때 마다 리스트에 추가
				dirList.add(fileList[i].getName());
			}
		}
		return dirList;
	}
	
	public static void main(String[] args) {
		new FileWindow();

	}
}
