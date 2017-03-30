/*버퍼 기반 스트림
 * 한줄 씩 스트림을 빨아들인다
 buffered 가 앞에 붙는다*/

package io;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class MemoEditor extends JFrame{
	JPanel p_north;
	JButton bt_open,bt_save;
	ImageIcon icon; //일반 클래스
	JTextArea area;
	JScrollPane scroll;
	//파일을 대상으로 입력해야 하므로..
	FileInputStream fis;
	FileOutputStream fos;
	//문자기반의 입력스트림 // 더 넓은 빨대 착용
	InputStreamReader reader; //fis 위에 //reader 이다..
	//문자기반의 출력스트림 // 더 넓은 빨대 착용
	OutputStreamWriter writer; //fos 위에 //writer 이다..
	PrintWriter writer2; //문자기반의 출력스트림 //위에꺼가 깨져서 프린트라이트 사용함
	
	BufferedReader buffer; //버퍼처리된 문자기반 입력스트림 //채팅할 때 쓴다 , 한글안깨져야 하고, 엔터치면 저장되어야한다..
	//리더 계열을 잡아먹는다

	String ori="C:/Java_workspace2/project0327/res/memo.txt"; //원본
	String dest="C:/Java_workspace2/project0327/res/memo_copy.txt"; //다른 파일의 저장경로

	public MemoEditor(){
		p_north = new JPanel();
		icon = new ImageIcon("C:/Java_workspace2/project0327/res/folder_on.png");
		bt_open = new JButton(icon);
		bt_save = new JButton("저장");
		
		area = new JTextArea(20,30);
		scroll = new JScrollPane(area);
		
		
		p_north.add(bt_open);
		p_north.add(bt_save);
		
		bt_open.setBorderPainted(false);
		bt_open.setContentAreaFilled(false);
		bt_open.setFocusPainted(false);
		bt_open.setOpaque(false);
		
		add(p_north,BorderLayout.NORTH);
		add(scroll);
		
		//버튼 2개 내부익명으로 가자~!
		bt_open.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				open();
				
			}
		});
		
		bt_save.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				save();
				
			}
		});
		
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
		setSize(700, 600);
		
		
	}
	
	//열기 메서드
	public void open(){
		try { //특정 파일에 빨대를 팍 꽂은 상태
			fis = new FileInputStream(ori);
			//문자기반 스트림에는 문자인 코딩속성을 지정할 수 있다.
			reader = new InputStreamReader(fis,"utf-8");
			//fis 위에 문자기반 스트림을 !!
			buffer = new BufferedReader(reader); //reader 계열을 잡아먹는다.. 
			//문자기반 스트림인 reader 위에 buffer 를 //한줄을 잡아먹는 메서드 readline (String) 을잡아먹는다
			
			String data; //int 는 기본자료형 , string 은 객체자료형을 원한다!!
			int count=0; //read 횟수를 알기위해!!
			
			while(true){
				data=buffer.readLine(); //fis 사용시 1byte 읽어들인다!! // reader 를 사용하니 2byte 씩 처리한다!!
				count++; //read 한 다음에 카운트 증가
				
				//객체니깐 data가 null 일때..
				if(data==null)break;
				area.append(data+"\n");
				
				//if(data==-1)break;
				//char형으로바꾸고 캐릭터형으로 스트링객체로
				//area.append(Character.toString((char)data));
				
			}
			System.out.println("count="+count);
			
		} catch (FileNotFoundException e) {
			JOptionPane.showMessageDialog(this, "파일이 존재하지 않습니다."); // - 사용자를 위한 에러 로그!!
			e.printStackTrace(); //printStackTrace 에러가 스택구조로 쌓여있는것을 추적한다.. 하지않으면 console에 에러가 
			//나타나지않아 개발자가 확인 불가 - 개발자를 위한 에러 로그 정보..
		} catch (IOException e) {//addSurrounding try통해 추가함..
			e.printStackTrace();
		}
		
		
		
	}
	
	//저장 메서드
	public void save(){
		try {
			//FileOutputStream 은 지정한 경로의 파일을 
			//생성해버린다. (크기는 0바이트인 빈 파일)
			//기존에 파일이 있다면 날려버리고 재배치됨..
			fos = new FileOutputStream(dest);
			//문자기반은 코딩속성 지정가능하다!!
			//writer = new OutputStreamWriter(fos,"utf-8");
			writer2 = new PrintWriter(fos);
			writer2.write(area.getText());
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} finally { //하나를 닫아도 다 닫히지만, 명시적으로는 전부 다 닫아주자..
			//열어놓은 스트림은 전부 닫는처리 //순서는 중요치 않다.
			if(writer2!=null){
					writer2.close();
				}
			if(fos!=null){
					try {
						fos.close();
					} catch (IOException e) {
						e.printStackTrace();
				}
			}
		}
	}
	
	public static void main(String[] args) {
		new MemoEditor();

	}

}
