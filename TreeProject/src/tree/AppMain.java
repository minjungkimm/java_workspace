package tree;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTree;
import javax.swing.event.TreeSelectionEvent;
import javax.swing.event.TreeSelectionListener;
import javax.swing.filechooser.FileSystemView;
import javax.swing.tree.DefaultMutableTreeNode;

import org.apache.tika.exception.TikaException;
import org.apache.tika.metadata.Metadata;
import org.apache.tika.parser.ParseContext;
import org.apache.tika.parser.mp3.LyricsHandler;
import org.apache.tika.parser.mp3.Mp3Parser;
import org.apache.tika.sax.BodyContentHandler;
import org.xml.sax.SAXException;

import javazoom.jl.decoder.Decoder;
import javazoom.jl.decoder.JavaLayerException;
import javazoom.jl.player.Player;

public class AppMain extends JFrame implements TreeSelectionListener{
	JPanel p_west,p_center;
	JTree tree;
	JScrollPane scroll;
	DefaultMutableTreeNode root =null;
	JTextArea area;
	String path="C:/Java_workspace2/TreeProject/data/";
	String fileLocation;
	
	public AppMain() {
		p_west = new JPanel();
		p_center = new JPanel();
		
		//createNode(); //--이 메서드통해서 자식 만들어보자
		//createDirectory();
		createMusicDir();
		
		tree = new JTree(root);
		scroll = new JScrollPane(tree);
		
		//패널은 본연의 크기 보장해주니깐
		p_west.setLayout(new BorderLayout());
		p_west.setPreferredSize(new Dimension(200, 500));
		
		area = new JTextArea();
		p_west.add(scroll);
		
		add(p_west,BorderLayout.WEST);
		add(area);
		
		//tree와 리스너연결
		tree.addTreeSelectionListener(this);
		
		setSize(700,500);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	
	public void createNode(){
		//최상위 노드 생성하기!!
		root = new DefaultMutableTreeNode("과일");
		
		DefaultMutableTreeNode node1=null;
		DefaultMutableTreeNode node2=null;
		DefaultMutableTreeNode node3=null;
		
		node1= new DefaultMutableTreeNode("블루베리");
		node2= new DefaultMutableTreeNode("레몬");
		node3= new DefaultMutableTreeNode("수입산과일");
		
		root.add(node1);
		root.add(node2);
		root.add(node3);
		
		node3.add(new DefaultMutableTreeNode("리치"));
		
	}
	
	//윈도우의 구조를 보여주기 (파일 탐색기)
	public void createDirectory(){
		root = new DefaultMutableTreeNode("내컴퓨터");
		
		File[] drive = File.listRoots(); //경로
		//디스크 볼륨 정보를 표현해준다
		FileSystemView fsv=FileSystemView.getFileSystemView();
		
		for(int i=0; i<drive.length; i++){
			DefaultMutableTreeNode node = null;
			String volume=fsv.getSystemDisplayName(drive[i]);
			node = new DefaultMutableTreeNode(volume);
			root.add(node);
		}
	}
	
	public void createMusicDir() {
		root = new DefaultMutableTreeNode("쥬크박스");
		
		File file = new File(path);
		
		File[] child=file.listFiles();
		
		for(int i=0; i<child.length; i++){
			DefaultMutableTreeNode node=null;
			node = new DefaultMutableTreeNode(child[i].getName());
			root.add(node);
		}
	}
	
	//선택한 노드의 파일에 대한 정보 추출하기
	public void extract(String filename){
		
		  fileLocation = path+filename;

	       BodyContentHandler handler = new BodyContentHandler();
	       Metadata metadata = new Metadata();
	       FileInputStream fis = null;
	       try {
	    	   fis=new FileInputStream(new File(fileLocation));
	    	   
		  } catch (FileNotFoundException e) {
		   e.printStackTrace();
		  }
	   
	       
	       ParseContext pcontext = new ParseContext();
	       
	       //Mp3 parser
	       Mp3Parser  Mp3Parser = new  Mp3Parser();
	       
	       LyricsHandler lyrics;
	       
		  try {
		   Mp3Parser.parse(fis, handler, metadata, pcontext);
		     lyrics = new LyricsHandler(fis,handler);
		     
		     while(lyrics.hasLyrics()) {
		      //System.out.println(lyrics.toString());
		      area.append(lyrics.toString()+"\n");
		     }
		  } catch (IOException e) {
		   // TODO Auto-generated catch block
		   e.printStackTrace();
		  } catch (SAXException e) {
		   // TODO Auto-generated catch block
		   e.printStackTrace();
		  } catch (TikaException e) {
		   // TODO Auto-generated catch block
		   e.printStackTrace();
		  }
	       
	       
	       //System.out.println("Contents of the document:" + handler.toString());
	  		area.append("Contents of the document:" + handler.toString()+"\n");
	       //System.out.println("Metadata of the document:");
	  		area.append("Metadata of the document:"+"\n");
	       String[] metadataNames = metadata.names();

	       for(String name : metadataNames) {          
	        //System.out.println(name + ": " + metadata.get(name)); 
	    	  area.append(name + ": " + metadata.get(name)+"\n");  
	       }
	       
	       play();
	}
	
	//선택한 MP3 파일 재생, JLayer
	public void play(){
		
			FileInputStream fis;
			
			try {
				fis= new FileInputStream(new File(fileLocation));
				//Decoder decoder = new Decoder();
				Player playMp3 = new Player(fis);
				playMp3.play();
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (JavaLayerException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
	} 

	
	public void valueChanged(TreeSelectionEvent e) {
		//확인해보자 //jtree 가 이벤트주체이다!!
		System.out.println("트리눌렀어?");
		Object obj=e.getSource();
		JTree tree=(JTree) obj;
		DefaultMutableTreeNode node=(DefaultMutableTreeNode) tree.getLastSelectedPathComponent();
		//System.out.println(node.getUserObject()); //toString 메서드 자동동작한상태.. 
		//개발자가 뭔가찍으려하니동작함
		extract(node.getUserObject().toString());
		
	}
	
	public static void main(String[] args) {
		new AppMain();
	}

}
