/*
 * �ڹٿ����� ���丮�� �����ϱ� ���� Ŭ������
 * ������ �������� �ʰ�, ���丮�� ���Ϸ� ����
 * ��� : java.io.File Ŭ������ ����+ ���丮����
 * 		   ó���Ѵ�...
 * */
package File;

import java.io.File;

public class FileTest {

	public static void main(String[] args) {
		//C����̺��� ������ �����ϴ� ���
		//���丮 �� ������ ����غ���!!
		File file = new File("c:/");
		
		//���� ���丮 �� ������ �������
		File[] dir=file.listFiles();
		//���丮 ��ü�� �޾Ҵ�..
		
		for(int i=0; i<dir.length; i++){
			//���丮 �Ѹ���
			if(dir[i].isDirectory()){
			System.out.println(dir[i].getName());
			}
		}
	}
}
