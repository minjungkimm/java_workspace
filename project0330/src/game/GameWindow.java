package game;

import javax.swing.JFrame;

public class GameWindow extends JFrame{
		GamePanel gamePanel;
		
	public GameWindow() {
		gamePanel = new GamePanel();
		add(gamePanel);
		
		//�гο� ���α׷��������� ��Ŀ�� �ø���
		gamePanel.setFocusable(true);
		
		pack();
		setVisible(true);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	
	public static void main(String[] args) {
		new GameWindow();
	}
}