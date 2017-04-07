package echo.server;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class ServerMain extends JFrame implements ActionListener{
	JPanel p_north;
	JTextField t_port;
	JButton bt_start;
	JTextArea area;
	JScrollPane scroll;
	int port=7777;
	ServerSocket server; //���Ӱ����� ����
	
	Thread thread; //�����͸����� ���� //���������� ������!
	BufferedReader buffr;
	BufferedWriter buffw;
	
	public ServerMain() {
		p_north = new JPanel(); //��ȯ.. int-> String����
		t_port = new JTextField(Integer.toString(port),10);//����Ʈ���� �տ����ڿ��� �־���
		bt_start = new JButton("����");
		area = new JTextArea();
		scroll = new JScrollPane(area);
		
		p_north.add(t_port);
		p_north.add(bt_start);
		add(p_north,BorderLayout.NORTH);
		add(scroll);
		
		//����
		bt_start.addActionListener(this);
		
		setVisible(true);
		setBounds(600,100,300,400);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		thread = new Thread(){
			@Override
			public void run() {
				//�ܵ������� ������ ���� run �޼���
				startServer();
			}
		};
		thread.start();
	}
	
	//���� ���� �� ����
	//������ ���� - checked Exception ����ó�� ����
	//				- runtime Exception ����ó�� �Ȱ���
	private void startServer() {
		bt_start.setEnabled(false); //��Ȱ��ȭ!!
		//0. ��ư�� ������ ���ӵǰ� ����
		//1. Ŭ���̾�Ʈ�� ������ �����Ѵ�
		//��Ʈ���� int �� �ٲ��..
		//port ���� ���ڸ� ���� , �����ڰ� ���ƺ���!!
		/*��Ÿ�� ���� (�������� �ʴ� ����)
		: ���α׷��� ���ư��� ���߿� ������ �߻����� ��
		ó���ϴ� ��..��*/
		try {
			port=Integer.parseInt(t_port.getText());
			server = new ServerSocket(port);
			area.append("���� �غ��..\n");
			//����
			Socket socket = server.accept(); 
			/*����ζ� �Ҹ��� ���ξ������ ����
			 * ���ѷ����� ���, Ȥ�� ���� ���¿� 
			 * ������ �ؼ��� �ȵȴ�..
			 * ��? ����δ� �������� �̺�Ʈ�� �����ϰų�,
			 * ���α׷��� ��ؾ��Ѵ�. 
			 * ���ѷ����� ��⿡ ������, ������ ������ �� �� ����
			 * ����Ʈ�� ���ߺо߿����� �̿Ͱ��� �ڵ��
			 * �̹� ������ Ÿ�Ӻ��� �����߻���*/
			//������ GUI ��������ʾƼ�, ������ �̺�Ʈ�� ������ ������
			//�ʿ������...
			area.append("��������..\n");
			
			//Ŭ���̾�Ʈ�� ��ȭ�� �ϱ� ���� ������ ���̹Ƿ�,
			//������ �Ǵ� ���� ��Ʈ���� ������!!
			buffr = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			buffw = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
			
			//Ŭ���̾�Ʈ�� �޼��� �ޱ�
			String data;
			//��� ����!!
			while(true){
				data=buffr.readLine(); //�ޱ�
				area.append("Ŭ���̾�Ʈ�� ��:"+data+"\n");
				
				buffw.write(data+"\n"); //������ //�����ǳ� �ٹٲ�
				buffw.flush(); //���ۺ���
			}
			
		} catch (NumberFormatException e1) {
			JOptionPane.showMessageDialog(this, "��Ʈ�� ���ڷ� �־��ּ���");
			e1.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
	
	public static void main(String[] args) {
		new ServerMain();
	}
}
