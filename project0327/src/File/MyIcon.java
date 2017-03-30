/*
 * 아이콘 생성시 그 크기를 조정하려면
 * 코드가 복잡하므로, 앞으로 재사용 가능성을 염두해두고
 * 나만의 재조정 이미지 아이콘을 새로 정의해본다..*/
package File;

import java.awt.Image;
import java.net.URL;

import javax.swing.ImageIcon;

public class MyIcon extends ImageIcon{
	
	public MyIcon(URL url,int width,int height) {
		super(url);
		
		//아이콘으로부터 이미지를 얻어와서 객체화한 이미지를 조정한다..
		Image scaledImg=this.getImage();
		//크기를 재조정한 후 결과적으로 이미지 객체를 다시 반환받자
		Image result=scaledImg.getScaledInstance(width, height, Image.SCALE_SMOOTH);
		//크기를 조정하는데 부드럽게 셋팅해줄것이다..
		
		//재조정된 이미지를 아이콘에 다시 반영
		this.setImage(result);
	}
}
