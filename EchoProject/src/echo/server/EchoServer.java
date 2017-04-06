/*���� ���α׷��̶�?
 * Ŭ���̾�Ʈ�� �޼����� �״�� �ٽ� �����ϴ�
 * ����� ����!! ä�� ���� 1�ܰ�
 * */
package echo.server;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class EchoServer{
	ServerSocket server;
	int port=7777;
	
	public EchoServer() {
		try {
			server = new ServerSocket(port);
			System.out.println("���� ����");
			
			Socket socket=server.accept(); //�����ڰ� ���� ������ //�ٸ������ ���� �����Ѵ�..
			InetAddress inet=socket.getInetAddress(); //��ȯ�� inetAddres
			String ip=inet.getHostAddress(); 
			//���Ѵ�⿡ ������.
			
			System.out.println(ip+"������ �߰�");
			
			//������ ��� ���Ѵ�
			//Ŭ���̾�Ʈ�� �����͸� �ޱ� ���� 
			//�Է� ��Ʈ�� ���!!
			//����Ʈ���-->���ڱ��-->���۱��
			BufferedReader buffr=new BufferedReader(new InputStreamReader(socket.getInputStream()));
			//3�ܰ� ���׷��̵� ���ٷ� ����!!!! //û���!! ����!!
			//���������� ���۸� �ݾ��ָ� ������..
			BufferedWriter buffw= new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
			//3�ܰ� ���׷��̵� ���ٷ� ����!!!! //���ϱ��!!
			
			//���⼭���� ĳġ�� ������ while �� �ɸ� 1�� ���Ӽ�����
			//��ȭ�� ������ ���������� , �ٸ� �������� ������ �Ұ����ϴ�
			
			/*��ȭ�� ��� ���������� , ����ΰ� �Ʒ��� while���ȿ�
			 * ���������Ƿ�, ���̻� �߰� �����ڿ� ���� ���������
			 * �Ұ��ϴ� ���: ���� ���� ���� ���� ����� ����*/
			while(true){
				//Ŭ���̾�Ʈ�� �� ���!!
				String msg;
				msg=buffr.readLine(); //���
				System.out.println("Ŭ���̾�Ʈ�� ���� ��:"+msg);
				
				//�޽��� �ٽ� ������
				buffw.write(msg+"\n"); //�� �� ������
				buffw.flush(); //���ۺ���
			
			}
		} catch (IOException e) {
			
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		new EchoServer();
	}
}
