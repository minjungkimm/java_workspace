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
		Image img; //추상클래스 직접 new 안된다!! toolkit 이용
		String[] path={
		"C:/html_workspace/images/gong/g1.png",
		"C:/html_workspace/images/gong/g2.png",
		"C:/html_workspace/images/gong/g3.png",
		"C:/html_workspace/images/gong/g4.png",
		"C:/html_workspace/images/gong/g5.png"
		}; //버튼에 따라 index -1,+1
		//자바에서는 대량의 데이터 생성 , 중괄호 사용!!
		//사진 여러개 넣을거니깐 배열이랑 백터쓰세용
		
		int count=0;//배열의 index
	
	public PhotoGallery(){
			
		bt_prev=new JButton("◀");
		bt_next=new JButton("▶");
		p_north=new JPanel();
			
		//기본이미지 설정해놓자!!
		img=kit.getImage(path[count]);
		la_path=new Label(path[count]); //변수 , 배열로 가자
			//캔버스 메서드 생성
		can= new Canvas(){
			//1. 우리가 그림을 주도 해야하니깐 페인트 메서드 생성
			public void paint(Graphics g) {
			//2. 그림 붙히자	//옵저버는 캔버스-this
				g.drawImage(img, 0, 0,500,500,this);
				System.out.println("paint호출!!");
			}
		};
		
		//버튼마다 연결!!
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
		
		//경고창 띄우는법
		//JOptionPane.showMessageDialog(this,"나버튼");
		//ACTION EVENT 는 클릭 뿐만 아니라, 여러 행위를
		//아우르는 이벤트 객체이다. 따라서
		//버튼만 ACTION EVENT 를 일으키는게 아니다!!
		//그래서 e.getSource 를 호출하면, 어떤 컴포넌트가
		//이벤트를 일으켰는지 예측할 수 없으므로,
		//Object 형으로 반환해준다!!
		Object obj=e.getSource(); //이벤트를 일으키는 컴포넌트
		//큰객체자료형에서 작은자료형으로 손실일어난다.. 물어볼것이다
		JButton btn=(JButton)obj;
			
		 	//주소값 비교
		if(btn ==bt_prev){ //주소값이 왼쪽이라면..
								//alert 창과 동일하게 혼자서는 살수없다
								//윈도우(=JFrame)에 기생해서 산다
								//this. 는 윈도우 새로뜨는창은 다이얼러그박스
								//윈도우는 크기가 조정가능해야 하는데 불가
			prev();
			//JOptionPane.showMessageDialog(this, "이전");
		}else if(btn ==bt_next){
			next();
			//JOptionPane.showMessageDialog(this, "다음");
		}
	}
	
	//이전 사진 보여주기!!
	public void prev(){
		//이미지의 경로변경!!+라벨의 값도 변경
		count--;
		img=kit.getImage(path[count]);
		can.repaint();
		la_path.setText(path[count]);
	}
	//다음 사진 보여주기!!
	public void next(){
		count++;
		img=kit.getImage(path[count]);
		//개발자는 paint 메서드를 호출 할 수 없다..
		//paint 는 언제 호출되나??
		//유저가 해당 컴포넌트의 변경을 가할 때, 스스로 호출된다!!
		//따라서 버튼을 누르게 되면, 캔버스의 변경을 가한 적이 없기 때문에
		//paint 메서드는 호출되지 않는다..!!
		//해결책) 캔버스의 paint 메서드를 강제호출해야 하지만,
		//호출불가기 때문에 간접호출해야 한다!!! JVM 이 시스템한테 paint 호출
		//해달라고 요청해야 한다!! repaint()-->update()-->paint()
		//update 메서드는 기존화면을 싹 지운다.
		//paint 메서드가 그림을 다시 그린다.
		//따라서 image 용량이 큰 경우엔 우리눈에는 깜빡거리는 효과가 나타난다..
		can.repaint();
		//캔버스야 너 제발 다시그릴래?..
		//라벨의 변경을 가하자
		la_path.setText(path[count]);
	}
	
	
	public static void main(String[] args) {
		new PhotoGallery();
	}

}
