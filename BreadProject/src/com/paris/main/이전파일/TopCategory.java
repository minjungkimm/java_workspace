/*탑 카테고리 레코드 한건을 담는 DTO VO 객체*/
package com.paris.main;

public class TopCategory {
	private int topcategory_id;
	private String top_name;
	
	public int getTopcategory_id() {
		return topcategory_id;
	}
	public void setTopcategory_id(int topcategory_id) {
		this.topcategory_id = topcategory_id;
	}
	public String getTop_name() {
		return top_name;
	}
	public void setTop_name(String top_name) {
		this.top_name = top_name;
	}
	
}
