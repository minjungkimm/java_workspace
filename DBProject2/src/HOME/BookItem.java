/*책 1권을 표현하는 UI 컴포넌트*/
package HOME;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class BookItem extends JPanel{
	Canvas can; //이미지를 그려줄
	JLabel la_name,la_price;
	
	//캔버스로 이미지를 그리고, 매개변수로 그 변수받기..
	//북아이템 생성할때 이미지, 이름 , 가격 정보받기..
	public BookItem(Image img,String name,String price) {
		can = new Canvas(){
			@Override
			public void paint(Graphics g) {
				g.drawImage(img, 0, 0, 120,120,this);
				//관찰자 this
			}
		};//
		
		la_name = new JLabel(name);
		la_price = new JLabel(price);
		
		add(can);
		add(la_name);
		add(la_price);
		
		can.setPreferredSize(new Dimension(120, 120));
		
		setPreferredSize(new Dimension(120, 180));
		setBackground(Color.GRAY);
		
	}//
	
}
