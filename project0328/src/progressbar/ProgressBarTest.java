package progressbar;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JProgressBar;

public class ProgressBarTest extends JFrame{
	JProgressBar[] bar = new JProgressBar[3]; //공간만 올린 상태..
	MyBar[] mb = new MyBar[3];
	int[] interval = {100,500,1000};
	
	JButton bt;
	int count;
	
	public ProgressBarTest() {
		setLayout(new FlowLayout());
		for(int i=0; i<bar.length; i++){
			bar[i] = new JProgressBar();
			mb[i] = new MyBar(bar[i],interval[i]);
			bar[i].setPreferredSize(new Dimension(450, 40));
			add(bar[i]);	
			}
		
		bt = new JButton("작동");
		
		add(bt);
		
		bt.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
			
			}
		});
	
		setSize(500,450);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
	}
	
	public static void main(String[] args) {
		new ProgressBarTest();
	}

}
