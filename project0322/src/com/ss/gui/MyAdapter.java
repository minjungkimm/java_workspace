package com.ss.gui;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class MyAdapter extends WindowAdapter{
	//윈도우 어댑터의 자식으로 만들어라!!
	//추상클래스이지만, 구현강제하는 메서드가 없다!! 
	//오버라이딩(우리는 어댑터가 가진7개를 갖고있는 것이다, 그중에서 업그레이드 해서 사용할것만 오버라이딩) 할려고!!
	//그리고 브레이스 완성시켜놨으므로, 모두 구현강제하지 않고
	//필요한 메서드만 오버라이딩 하자!! 

	/*어댑터가 이미 7개를 모두 오버라이드 했기 때문에
	 우리가 구현강제를 받지 않는 상태이다
	 이중에서 원하는 메서드를 또 오버라이드하자!!!*/
	public void windowClosing(WindowEvent e) {
		System.exit(0);//프로그램 종료
	}		
}
