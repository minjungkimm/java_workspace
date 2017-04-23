package client;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.Socket;
import java.net.URL;
import java.net.UnknownHostException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class ClientMain extends JFrame implements ActionListener{
	JPanel p_center,p_south;
	JTextArea area;
	JScrollPane scroll;
	JTextField t_input;
	JButton bt;
	String[] path={
			"a.jpg",
			"b.jpg",
			"c.jpg",
			"d.jpg",
			"e.jpg",
			"f.jpg",
			"g.jpg",
			"h.jpg",
	};
	
	Socket socket;
	String ip="localhost";
	int port=7878;
	ClientThread ct;
	
	public ClientMain() {
		p_center = new JPanel();
		p_south = new JPanel();
		area = new JTextArea();
		scroll= new JScrollPane(area);
		t_input = new JTextField(40); //flow �� �ɱ׶�����
		bt = new JButton("����");
		
		area.setBackground(Color.PINK);
		scroll.setPreferredSize(new Dimension(580, 200));
		
		//��ǰ �����ϱ�!!
		createProduct();
		
		p_center.add(scroll);
		p_south.add(t_input);
		p_south.add(bt);
		
		add(p_center);
		add(p_south,BorderLayout.SOUTH);
		
		//��ư�� �����ʿ���
		bt.addActionListener(this);
		
		//�Է¹ڽ��� ������ ����
		t_input.addKeyListener(new KeyAdapter() {
			public void keyReleased(KeyEvent e) {
				int key=e.getKeyCode();
				if(key==KeyEvent.VK_ENTER){
					String msg=t_input.getText();
					ct.send("requestType=chat&msg="+msg+"&id=batman");
					t_input.setText("");
				}
			}
		});
		
		setVisible(true);
		setSize(650, 700);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
	}
	
	//��ǰ �̹����� ���������� ��������!!
	public void createProduct() {	
		
		try {
			for(int i=0; i<path.length; i++){ //��ġ ����
			URL url = new URL("http://localhost:9090/data/"+path[i]);
			Product product = new Product(url,this);
			//p_center �� �پ���Ѵ�
			p_center.add(product);
			}
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
		
	}
	
	//���� �޼��� ����
	public void connect() {
		try {
			socket = new Socket(ip, port);
			
		    ct = new ClientThread(socket,area);
			//���Ӱ� ���ÿ� �����嵵 ����
			ct.start();
			
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		connect();
	}
	
	public static void main(String[] args) {
		new ClientMain();
	}
}
