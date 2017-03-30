package graphic;

import java.awt.BorderLayout;
import java.awt.Canvas;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Label;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class PhotoGallery extends JFrame implements ActionListener{
		Canvas can;
		JPanel p_north;
		Label la_path;
		JButton bt_prev;
		JButton bt_next;
		Toolkit kit=Toolkit.getDefaultToolkit();
		Image img; //�߻�Ŭ���� ���� new �ȵȴ�!! toolkit �̿�
		String[] path={
		"C:/html_workspace/images/gong/g1.png",
		"C:/html_workspace/images/gong/g2.png",
		"C:/html_workspace/images/gong/g3.png",
		"C:/html_workspace/images/gong/g4.png",
		"C:/html_workspace/images/gong/g5.png"
		}; //��ư�� ���� index -1,+1
		//�ڹٿ����� �뷮�� ������ ���� , �߰�ȣ ���!!
		//���� ������ �����Ŵϱ� �迭�̶� ���;�����
		
		int count=0;//�迭�� index
	
	public PhotoGallery(){
			
		bt_prev=new JButton("��");
		bt_next=new JButton("��");
		p_north=new JPanel();
			
		//�⺻�̹��� �����س���!!
		img=kit.getImage(path[count]);
		la_path=new Label(path[count]); //���� , �迭�� ����
			//ĵ���� �޼��� ����
		can= new Canvas(){
			//1. �츮�� �׸��� �ֵ� �ؾ��ϴϱ� ����Ʈ �޼��� ����
			public void paint(Graphics g) {
			//2. �׸� ������	//�������� ĵ����-this
				g.drawImage(img, 0, 0,500,500,this);
				System.out.println("paintȣ��!!");
			}
		};
		
		//��ư���� ����!!
		bt_prev.addActionListener(this);
		bt_next.addActionListener(this);
		
		add(can,BorderLayout.CENTER);
		add(la_path,BorderLayout.NORTH);
		p_north.add(bt_prev);
		p_north.add(bt_next);
		add(p_north,BorderLayout.SOUTH);
		
		setVisible(true);
		setSize(600, 650);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
	}
	
	public void actionPerformed(ActionEvent e) {
		
		//���â ���¹�
		//JOptionPane.showMessageDialog(this,"����ư");
		//ACTION EVENT �� Ŭ�� �Ӹ� �ƴ϶�, ���� ������
		//�ƿ츣�� �̺�Ʈ ��ü�̴�. ����
		//��ư�� ACTION EVENT �� ����Ű�°� �ƴϴ�!!
		//�׷��� e.getSource �� ȣ���ϸ�, � ������Ʈ��
		//�̺�Ʈ�� �����״��� ������ �� �����Ƿ�,
		//Object ������ ��ȯ���ش�!!
		Object obj=e.getSource(); //�̺�Ʈ�� ����Ű�� ������Ʈ
		//ū��ü�ڷ������� �����ڷ������� �ս��Ͼ��.. ������̴�
		JButton btn=(JButton)obj;
			
		 	//�ּҰ� ��
		if(btn ==bt_prev){ //�ּҰ��� �����̶��..
								//alert â�� �����ϰ� ȥ�ڼ��� �������
								//������(=JFrame)�� ����ؼ� ���
								//this. �� ������ ���ζߴ�â�� ���̾󷯱׹ڽ�
								//������� ũ�Ⱑ ���������ؾ� �ϴµ� �Ұ�
			prev();
			//JOptionPane.showMessageDialog(this, "����");
		}else if(btn ==bt_next){
			next();
			//JOptionPane.showMessageDialog(this, "����");
		}
	}
	
	//���� ���� �����ֱ�!!
	public void prev(){
		//�̹����� ��κ���!!+���� ���� ����
		count--;
		img=kit.getImage(path[count]);
		can.repaint();
		la_path.setText(path[count]);
	}
	//���� ���� �����ֱ�!!
	public void next(){
		count++;
		img=kit.getImage(path[count]);
		//�����ڴ� paint �޼��带 ȣ�� �� �� ����..
		//paint �� ���� ȣ��ǳ�??
		//������ �ش� ������Ʈ�� ������ ���� ��, ������ ȣ��ȴ�!!
		//���� ��ư�� ������ �Ǹ�, ĵ������ ������ ���� ���� ���� ������
		//paint �޼���� ȣ����� �ʴ´�..!!
		//�ذ�å) ĵ������ paint �޼��带 ����ȣ���ؾ� ������,
		//ȣ��Ұ��� ������ ����ȣ���ؾ� �Ѵ�!!! JVM �� �ý������� paint ȣ��
		//�ش޶�� ��û�ؾ� �Ѵ�!! repaint()-->update()-->paint()
		//update �޼���� ����ȭ���� �� �����.
		//paint �޼��尡 �׸��� �ٽ� �׸���.
		//���� image �뷮�� ū ��쿣 �츮������ �����Ÿ��� ȿ���� ��Ÿ����..
		can.repaint();
		//ĵ������ �� ���� �ٽñ׸���?..
		//���� ������ ������
		la_path.setText(path[count]);
	}
	
	
	public static void main(String[] args) {
		new PhotoGallery();
	}

}
