/*å 1���� ǥ���ϴ� UI ������Ʈ*/
package HOME;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class BookItem extends JPanel{
	Canvas can; //�̹����� �׷���
	JLabel la_name,la_price;
	
	//ĵ������ �̹����� �׸���, �Ű������� �� �����ޱ�..
	//�Ͼ����� �����Ҷ� �̹���, �̸� , ���� �����ޱ�..
	public BookItem(Image img,String name,String price) {
		can = new Canvas(){
			@Override
			public void paint(Graphics g) {
				g.drawImage(img, 0, 0, 120,120,this);
				//������ this
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
