package homework;

import java.awt.Color;

public class RectThread extends ShapeThread {

		public RectThread(){
			super(x, y, w, h, interval, g);
		}
		
		public void render(){
			g.setColor(Color.yellow);
			g.fillRect(0, 0, 700, 600);
			
			//���ϴ� ���� �׸���
			g.setColor(Color.RED);
			x+=2;
			g.drawRect(x, y, w, h);
		}
}
