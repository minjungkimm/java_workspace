/*
GUI에서 컴포넌트를 내가 원하는 위치에
놓기 위해서는 배치를 알아야 한다.
자바 gui 에서는 총 5개의 배치를 지원한다.

1.FlowLayout(★)
2.BorderLayout(★)
3.GridLayout
4.GridBagLayout
5.CardLayout
*/

package gui;
import java.awt.*;

class BorderTest{
	public static void main(String[] args){
		//BorderLayout 은 동서남북, 센터라는
		//방위와 경계를 갖는 레이아웃이다!!
		Frame frame=new Frame();

		//프레임은 자신이 설정할 배치관리자를
		//결정하는 메서드를 가진다!!
		//변수를 넣지않고 바로 생성하면, 일회성으로 사용
		//변수생성하는 이유는 재사용, 값변경 위함이기 때문에..
		frame.setLayout(new BorderLayout());
		
		frame.setSize(500,400);
		frame.setVisible(true);
		//북쪽에 버튼 유착하자!!
		Button bt_north=new Button("북쪽");
		Button bt_east=new Button("동쪽");
		Button bt_south=new Button("남쪽");
		Button bt_west=new Button("서쪽");
		Button bt_center=new Button("중앙");

		frame.add(bt_north,BorderLayout.NORTH);
		frame.add(bt_east,BorderLayout.EAST);
		frame.add(bt_south,BorderLayout.SOUTH);
		frame.add(bt_west,BorderLayout.WEST);
		frame.add(bt_center,BorderLayout.CENTER);
	}
}
