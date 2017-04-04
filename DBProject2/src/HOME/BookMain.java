package HOME;

import java.awt.BorderLayout;
import java.awt.Canvas;
import java.awt.Checkbox;
import java.awt.CheckboxGroup;
import java.awt.Choice;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionListener;
import java.awt.event.ItemListener;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

import book.DBManager;
import book.SubCategory;

public class BookMain extends JFrame implements ItemListener,ActionListener{
	Connection con;
	DBManager manager=DBManager.getInstance();
	//���Ŵ����� �ν��Ͻ�.. = ���Ŵ��� ������
	PreparedStatement pstmt;
	ResultSet rs;
	
	JPanel p_west; //���� �����
	JPanel p_content; //���� ���� ��ü
	JPanel p_north; //���� ���ø�� ����
	JPanel p_center; //Flow �� ����Ǿ� p_table, p_grid ��
	//��� ������� ���� �� �ִ�
	JPanel p_table; //JTable �� �ٿ��� �г�
	JPanel p_grid; //�׸��尡 �ٿ��� �г�
	Choice ch_top;
	Choice ch_sub;
	JTextField t_name;
	JTextField t_price;
	Canvas can;
	JButton bt_regist;
	CheckboxGroup group;
	Checkbox ch_table,ch_grid;
	Toolkit kit=Toolkit.getDefaultToolkit(); //�̰͵� ������ singleTon����
	Image img;
	JFileChooser chooser;
	File file;
	
	//html option ���� �ٸ��Ƿ�, choice ������Ʈ�� ���� �̸� �޾Ƴ���
	//�� �÷����� rs ��ü�� ��ü�� ���̴�..
	//����? ���̻� rs.last,rs.getRow �� ������� ����
	ArrayList<SubCategory> subcategory= new ArrayList<SubCategory>();
	
	public BookMain(){
		setLayout(new BorderLayout());
		
		p_west = new JPanel();
		p_content = new JPanel();
		p_north = new JPanel();
		p_center = new JPanel();
		
		p_table = new JPanel(); //���̺� �𵨸��� �ڷ��� ����
		p_grid = new JPanel(); //22
		
		ch_top = new Choice();
		ch_sub = new Choice();
		
		t_name = new JTextField(12);
		t_price = new JTextField(12);
		
		URL url = this.getClass().getResource("/deil.jpg");
	
		try {
			img =ImageIO.read(url);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			
		
		
	}//������
	
	
}
