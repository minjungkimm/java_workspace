package xml;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

public class ParseMain_OLD extends JFrame{
	JPanel p_w, p_e;
	JTable table;
	JButton bt_w_open,bt_w_save,bt_e_export;
	JTextArea area;
	JScrollPane w_scroll,e_scroll;
	Model model;
	SAXParserFactory factory;
	SAXParser parser;
	Handler handler;
	String path="C:/Java_workspace2/DataExchangeApp/data/car.xml";
	
	public ParseMain_OLD() {
		
		this.setLayout(new BorderLayout());
		//west
		p_w = new JPanel();
		bt_w_open = new JButton("XML열기");
		bt_w_save = new JButton("Oracle에 저장");
		table = new JTable(2,2);
		w_scroll = new JScrollPane(table);
		
		//east
		p_e = new JPanel();
		bt_e_export = new JButton("JSON으로 export");
		area = new JTextArea(15,30);
		e_scroll = new JScrollPane(area);
		
		
		p_w.add(bt_w_open);
		p_w.add(bt_w_save);
		p_w.add(w_scroll);
		p_w.setPreferredSize(new Dimension(350, 500));
		
		p_e.add(bt_e_export);
		p_e.add(e_scroll);
		p_e.setPreferredSize(new Dimension(350, 500));
		
		add(p_w,BorderLayout.WEST);
		add(p_e,BorderLayout.EAST);
		
		setVisible(true);
		setSize(800,500);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		//table.setModel(model=new Model());
		//table.updateUI();
	}
	
	/*public void loadxml() {
		
		SAXParserFactory factory = null;
		factory = SAXParserFactory.newInstance();
		
		
		
		try {
			SAXParser parser=factory.newSAXParser();
			parser.parse(new File(path), new Handler());
		} catch (ParserConfigurationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SAXException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}*/
	
	
	public static void main(String[] args) {
		new ParseMain_OLD();
	}	
}
