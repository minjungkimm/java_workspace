package xml;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.SAXException;

public class ParseMain extends JFrame implements ActionListener{
	JPanel p_w, p_e;
	JTable table;
	JButton bt_w_open,bt_w_save,bt_e_export;
	JTextArea area;
	JScrollPane w_scroll,e_scroll;
	Model model;
	SAXParserFactory factory;
	SAXParser parser;
	Handler handler;
	String path;
	File file;
	JFileChooser chooser;
	Connection con;
	
	public ParseMain() {
		
		this.setLayout(new BorderLayout());
		//west
		p_w = new JPanel();
		bt_w_open = new JButton("XML열기");
		bt_w_save = new JButton("Oracle에 저장");
		table = new JTable();
		w_scroll = new JScrollPane(table);
		chooser = new JFileChooser("C:/Java_workspace2/DataExchangeApp/data");
		//east
		p_e = new JPanel();
		bt_e_export = new JButton("JSON으로 export");
		area = new JTextArea(15,30);
		e_scroll = new JScrollPane(area);
		
		p_w.add(bt_w_open);
		p_w.add(bt_w_save);
		p_w.add(w_scroll);
		p_w.setPreferredSize(new Dimension(400, 500));
		
		p_e.add(bt_e_export);
		p_e.add(e_scroll);
		p_e.setPreferredSize(new Dimension(400, 500));
		
		
		add(p_w,BorderLayout.WEST);
		add(p_e,BorderLayout.EAST);
		
		bt_w_open.addActionListener(this);
		bt_w_save.addActionListener(this);
		bt_e_export.addActionListener(this);
		
		setVisible(true);
		setSize(800,500);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
	}
	
	public void loadxml() {
		table.removeAll();
		model = new Model();
		
		int result=chooser.showOpenDialog(this);
		if(result==JFileChooser.APPROVE_OPTION){
			file = chooser.getSelectedFile();
			path=file.getAbsolutePath();
			System.out.println(path);
		}
		
		
		factory = SAXParserFactory.newInstance();
		
		try {
			
			SAXParser parser=factory.newSAXParser();
			parser.parse(new File(path), new Handler(model));
			
		} catch (ParserConfigurationException e) {
			e.printStackTrace();
		} catch (SAXException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		table.setModel(model);
		table.updateUI();
		

		
	}
	
	public void save() {
		//오라클 테이블에 파일이름과 동일하게 테이블 생성하기 위한 파일 이름
		int last = path.lastIndexOf("\\");
		int comlast=path.lastIndexOf(".");
		String fileName=path.substring(last+1,comlast);
		System.out.println("결과는?"+fileName);
		
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		
		StringBuffer sql=new StringBuffer();
		sql.append("create sequnce seq_?");
		sql.append(" increment by 1");
		sql.append(" start with 1 ");
		
		sql.append("create table ?");
		sql.append(" ( seq_?_id NOT NULL,");
		sql.append(" name varchar2(20) NOT NULL,");
		sql.append(" age number,");
		sql.append(" gender varchar2(10),");
		sql.append(" primary key(seq_?_id)");
		sql.append(" ) ");
		
		System.out.println(sql.toString());
		
		try {
			pstmt=con.prepareStatement(sql.toString());
			pstmt.setString(1,fileName);
			pstmt.setString(2,fileName);
			pstmt.setString(3,fileName);
			rs=pstmt.executeQuery();
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void export(){

		//area.append();
	}
	
	public void actionPerformed(ActionEvent e) {
		Object obj=e.getSource();
		if(obj==bt_w_open){
			loadxml();
		}else if(obj==bt_w_save){
			save();
		}else if(obj==bt_e_export){
			export();
		}
	}
	
	public static void main(String[] args) {
		new ParseMain();
	}	
}
