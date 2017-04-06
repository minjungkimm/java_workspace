/*
 * �ڹٸ� �̿��Ͽ� ������ ���α׷��� �ۼ��Ѵ�
 * ��ȭ�� �޴� ���̴�.
 * */
package echo.server;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

public class MyServer {
	//��ȭ�� ���������� ������ �˷��ֱ� ���� ��ü!!
	//�� ���� ��ȭ�� ��������..
	//������ Ŭ���̾�Ʈ�� ã�ƿ��� ��ٸ��Ƿ�
	//Ŭ���̾�Ʈ�� ����� ��Ʈ��ȣ�� �����ϸ� �ȴ�
	//��Ģ�� ��Ʈ��ȣ�� �����Ӱ� ���ϸ� �ȴ�
	//����1) 0~1023 �� �̹� �ý����� �����ϰ� ������ , ������
	//����2) ������ ���α׷����� ������
	//	����Ŭ 1521, mysql 3306, web 80
	ServerSocket server;
	int port=8888;
	Socket socket;
	public MyServer() {
							//��ȣ�ȿ� �� port
		try {
			server = new ServerSocket(port);
			System.out.println("���� ����"); //�������ߴ�, ���� ���������ʾҴ�
			
			//Ŭ���̾�Ʈ�� ������ ��ٸ���
			//������ ���������� ���Ѵ�� �� ������
			//������... ��ġ read() �迭�� ����
			while(true){
				socket=server.accept();
				System.out.println("������ �߰�");
				
				//������ �̿��Ͽ� �����͸� �ް����ϴ� ���
				//�Է½�Ʈ����, �����͸� �������� �ϴ� ��쿡��
				//��½�Ʈ��
				InputStream is = socket.getInputStream();
				InputStreamReader reader=null; //FileReader �� ���ϴ��!!, ��Ʈ�������
				//inputStreamReader �������
				
				reader = new InputStreamReader(is);
				//�ڵ��Ӽ��� ���߽� ��������
				
				int data;
				while(true){
					data=reader.read(); //2byte �о���� 
					System.out.print((char)data);
				}
			}
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		new MyServer();

	}

}
