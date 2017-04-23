/*상품 한건의 디스플레이를 표현한 클래스*/
package client;

import java.awt.BorderLayout;
import java.awt.Canvas;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;

import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JPanel;

public class Product extends JPanel implements ActionListener{
	ClientMain clientMain;
	Canvas can;
	JButton bt_buy;
	BufferedImage image;
	URL url; //자원의 위치에 대한 객체 //일반클래스
	
	//캔버스 이미지의 크기
	int width=120;
	int height=150;
	
	public Product(URL url,ClientMain clientMain){
		//이미지부터 생성후 그릴수있다
		//웹서버에서 이미지를 땡겨오자
		this.url=url;
		this.clientMain=clientMain;
		
		try {
			image=ImageIO.read(url);
		} catch (IOException e) {
			e.printStackTrace();
		}
		can = new Canvas(){
			@Override
			public void paint(Graphics g) {
				g.drawImage(image, 0, 0, width , height, this);
			}
		};
		
	
		
		bt_buy = new JButton("구매");
		setLayout(new BorderLayout());
		
		add(can);
		add(bt_buy,BorderLayout.SOUTH);
		
		//버튼과 리스너 연결
		bt_buy.addActionListener(this);
		
		//패널의 사이즈
		setPreferredSize(new Dimension(width+4, height+45));
	}
	
	public void buy() {
		//나 살래요!~
		//누가 무엇을 
		String msg="requestType=buy&prodcut_id=87&id=batman";
		clientMain.ct.send(msg);
	}
	
	public void actionPerformed(ActionEvent e) {
		buy();
	}
}
