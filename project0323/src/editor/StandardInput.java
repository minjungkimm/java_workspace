/*1.��Ʈ���� ���⼺�� ���� �з�
 * - �Է�, ���
 * 
 * 2.��Ʈ���� ������ ó������� ���� �з�
 * (1)byte ��� ��Ʈ��  
 *  - (����� �� 1byte �� ó��) 
 * (2)���� ��� ��Ʈ��
 * 	 - (����½� 2byte �� ��� ������ �� �ִ� ��Ʈ��)
 *  ����!!) 2byte �� �аų� , ���°� �ƴϴ�!!
 *  ���� ��� ��Ʈ���� ����Ģ
 *  �Է½�Ʈ�� - ~~Reader ����. 
 *  ��½�Ʈ�� - ~~Writer ����.
 *  
 * (3)���� ��Ʈ��
 *  - ()
 * 
 * */
package editor;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class StandardInput {
	
	public static void main(String[] args) {
		//��Ʈ�� ���!!
		InputStream is = System.in;
		InputStreamReader reader=null;
		reader = new InputStreamReader(is);
		//reader �� byte ����� �ξ�� �Ѵ�!!
		
		int data;
		
		try {
			data=reader.read(); //1byte 
			//read �޼����while �������� ���� ���ڸ� �о����
			//System.in �� System.out �� ��ǥ����
			//ǥ�� �Է�,    ǥ����� �̴�..
			//in�� out �̶�� ������ ��ü��?
			//��ü, println(); �̶�� �޼��� ���̴� �������� �������� ���кҰ�
			System.out.print((char)data); //ln�� �ǹ��ϴ� �� �ٹٲ�
		} catch (IOException e) {
			e.printStackTrace();
		}
	
	}
}
