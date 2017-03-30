/*그림 그려질 목적으로 지원되는 객체인
 * Canvas 에 그림을 그려보자!!
 * 왜 캔버스에 그려야 하나? 캔버스는 컨테이너 처럼 아무것도 없다..
 * 비어있다 빈 도화지를 표현한 객체이므로..
 * */
package graphic;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.JFrame;

public class CanvasTest extends JFrame{
	Canvas can;//텅 빈 도화지
	Toolkit kit;//자바SE에서 이미지를 얻으려면
	//툴킷 객체를 이용해야 한다..(sun사가...)
	Image img; //추상클래스라서 new 못함!!
	public CanvasTest(){
		kit=Toolkit.getDefaultToolkit(); //인스턴스 얻기
		//이미지를 얻기위한 도우미, 이미지가 아니다!!
		img=kit.getImage("C:/html_workspace/images/dora.png");
		//윈도우만 역슬러시 쓰니깐, 우리는 이제 전부 일반슬러시로 쓰자!!
		//이미지는 컨버스에 그려지기전에 올려야된다!!
		//피곤하면 여기서 오버라이드 하자
		//선은 점과점의 연결
		can = new Canvas(){
			//paint 메서드는 사실상 행위에 불과하며
			//어떤 그림을 그릴지를 결정하는 객체가
			//Graphics 객체이다!!
			public void paint(Graphics g) {
								//image(추상클래스),x,y,관찰자
			//추상클래스중에서 api 객체에서 지원하는 클래스가 있나? 확인부터하자
			//무조건 자식을 new 하자는 생각 버리자
			//인스턴스면 new 메서드, 안되니깐 하는거니깐 클래스 메서드
				g.drawImage(img,0,0,200,200,this);
				//여기서 말하는 this 는 브레이스 안에서 this
			}
		};
		
		can.setBackground(Color.YELLOW);
		add(can);
		
		setSize(700,600);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		
	}
	
	public static void main(String[] args) {
		new CanvasTest();
	}
}
