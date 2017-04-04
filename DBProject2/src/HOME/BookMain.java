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
	//디비매니져의 인스턴스.. = 디비매니저 생성자
	PreparedStatement pstmt;
	ResultSet rs;
	
	JPanel p_west; //좌측 등록폼
	JPanel p_content; //우측 영역 전체
	JPanel p_north; //우측 선택모드 영역
	JPanel p_center; //Flow 가 적용되어 p_table, p_grid 를
	//모두 존재시켜 놓을 수 있다
	JPanel p_table; //JTable 이 붙여질 패널
	JPanel p_grid; //그리드가 붙여질 패널
	Choice ch_top;
	Choice ch_sub;
	JTextField t_name;
	JTextField t_price;
	Canvas can;
	JButton bt_regist;
	CheckboxGroup group;
	Checkbox ch_table,ch_grid;
	Toolkit kit=Toolkit.getDefaultToolkit(); //이것도 일종의 singleTon패턴
	Image img;
	JFileChooser chooser;
	File file;
	
	//html option 과는 다르므로, choice 컴포넌트의 값을 미리 받아놓자
	//이 컬렉션은 rs 객체를 대체할 것이다..
	//장점? 더이상 rs.last,rs.getRow 로 고생하지 말자
	ArrayList<SubCategory> subcategory= new ArrayList<SubCategory>();
	
	public BookMain(){
		setLayout(new BorderLayout());
		
		p_west = new JPanel();
		p_content = new JPanel();
		p_north = new JPanel();
		p_center = new JPanel();
		
		p_table = new JPanel(); //테이블 모델만들어서 자료형 지정
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
			
		
		
	}//생성자
	
	
}
