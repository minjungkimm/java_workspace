/*���ϰ� ���õ� �۾��� �����ִ� ���뼺�ִ�
 * Ŭ���� �����Ѵ�*/
package util.file;

public class FileUtil{
	/*�Ѱܹ��� ��ο��� Ȯ���� ���ϱ�*/
	//static ó����������!!
	public static String getExt(String path) {
		//c://aa/ddd/test....aa.jpg
		int last = path.lastIndexOf(".");
		return path.substring(last+1,path.length());
		
	}
}
