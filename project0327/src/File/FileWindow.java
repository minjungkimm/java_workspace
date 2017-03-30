/*
 * Ŭ������ �ڵ��� ���뼺 ������ ���� ����̴�.
 * */
package File;

//��Ű���� �������� ���丮�� �����ϴ� ���
//�ڹٿ����� Ŭ�����н��� �̹����� �������� �ִ�.
//������ Ŭ�� bulid path
import java.awt.FlowLayout;
import java.io.File;
import java.util.ArrayList;

import javax.swing.JFrame;

public class FileWindow extends JFrame{
	MyIcon folder_on,folder_off;

	
	public FileWindow(){
		
		setLayout(new FlowLayout());
		//�̹��� �������� �����ϵ�, ���ҽ� ������ ����..
		//Uniformed Resource Locator : 
		//URL url=this.getClass().getResource("/folder_on.png");
		folder_on = new MyIcon(this.getClass().getResource("/folder_open.png"),50,50);
		folder_off = new MyIcon(this.getClass().getResource("/folder_on.png"),50,50);
		//���������κ��� �̹����� ���ͼ� ��üȭ�� �̹����� �����Ѵ�..
		//Image scaledImg=folder_on.getImage();
		
		//ũ�⸦ �������� �� ��������� �̹��� ��ü�� �ٽ� ��ȯ����
		//Image result=scaledImg.getScaledInstance(50, 50, Image.SCALE_SMOOTH);
		//ũ�⸦ �����ϴµ� �ε巴�� �������ٰ��̴�..
		
		//�������� �̹����� �����ܿ� �ٽ� �ݿ�
		//folder_on.setImage(result);
		
		ArrayList<String>list = getDirList();
		
		for(int i=0; i<list.size(); i++){
			String dirName=list.get(i);
			//����� ������ �׽�Ʈ
			MyPanel mp=new MyPanel(dirName, folder_off);
			add(mp);
		}
		
		setSize(600,500);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	
	}
	
	//���ϴ� ����� ���� ���丮/���� ���ϱ�
	public ArrayList getDirList(){
		File file = new File("c:/");
		
		File[] fileList=file.listFiles();
		ArrayList<String> dirList=new ArrayList<String>();
		
		//���丮�� �����!!
		for(int i=0; i<fileList.length; i++){
			if(fileList[i].isDirectory()){
				//���丮�� �߰ߵ� �� ���� ����Ʈ�� �߰�
				dirList.add(fileList[i].getName());
			}
		}
		return dirList;
	}
	
	public static void main(String[] args) {
		new FileWindow();

	}
}
