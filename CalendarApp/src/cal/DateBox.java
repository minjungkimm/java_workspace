/*각 날짜를 표현하는 커스터마이징 컴포넌트*/
package cal;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class DateBox extends JPanel{
	MainFrame mainFrame;
	JLabel la;
	
	public DateBox(MainFrame mainFrame) {
		this.mainFrame=mainFrame;
		
		this.setLayout(new  BorderLayout());
		la = new JLabel();
		
		add(la, BorderLayout.NORTH);
		
		//나와 마우스 리스너 연결
		this.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				pop();
			}
			
		});
		
		setPreferredSize(new Dimension(120, 120));
		setBackground(Color.YELLOW);
	}
	
	
	//마우스 클릭시 실행될 메서드
	public void pop(){
		int yy=mainFrame.yy;
		int mm=mainFrame.mm;
		int dd=Integer.parseInt(la.getText());
		
		JOptionPane.showMessageDialog(mainFrame, yy+"-"+(mm+1)+"-"+dd);
		
		//나만 색상주고 나아닌 애들은 x
		for(int i=0; i<mainFrame.box.length; i++){
			if(mainFrame.box[i]!=this){
				mainFrame.box[i].setBackground(Color.CYAN);
			}else{
				mainFrame.box[i].setBackground(Color.PINK);
			}
		}
			
	}
	
}
