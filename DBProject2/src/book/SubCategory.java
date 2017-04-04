/*객체 지향 언어인 자바에서는 현실의 사물을
클래스로 정의하지만 , DATABASE 에서는 현실의 사물을
Entity 라는 객체개념으로 표현한다.
결국 객체를 표현하는 방법만 다를 뿐 개념은 같다
현실 반영이라는 개념은 같다

객체지향언어에서 클래스가 인스턴스를 생성해내는
거푸집이라면 , database 분야에서
테이블은 레코드를 저장할 수 있는 틀로 봐도
무방 이때 하나의 레코드는 결국 하나의 객체로
봐야한다...
결론) 테이블에 존재하는 상품 레코드수가 총 5개라면,개발자는 
이 각각이 레코드를 5개의 인스턴스로 각각 받으면 된다!!

아래의 클래스는 로직 작성용이 아니라 , 
한건의 레코드를 담기 위한 저장공간용도로만 사용할 클래스이다.
어플리케이션 설계분야에서 이러한 목적의 클래스를 가리켜
VO, DTO 라한다
Value Object = 값만 담긴 객체
Data Transfer Object = 값은 전달하기 위한 객체

변수명도 무조건 테이블과 일치시켜야함
*/
package book;
//로직이 없는 클래스!! Dummy 클래스
//오직 데디터 담는 그릇용!! 배열과 차이점은?
//[][][] 공간을 만들어야 한다..  
//배열은 자료형이 섞일 수가 없다.. 객체가 아니라서 한계가 있다
//객체는 가능해진다!! 배열과 객체는 차원이 다른 방식으로 개발되므로
//객체로 처리하는 것이 훨씬 더 작업방식이나 개념상 좋다
public class SubCategory {
	//컬럼명과 멤버변수를 테이블에 근거하여 일치 시키고 // 자료형을 앞에준다 
	//데이터는 보호되어야 한다
	private int subcategory_id;
	private int topcategory_id;
	private String category_name;
	
	//컨트롤 쉬프트 에스 + 
	public int getSubcategory_id() {
		return subcategory_id;
	}
	public void setSubcategory_id(int subcategory_id) {
		this.subcategory_id = subcategory_id;
	}
	public int getTopcategory_id() {
		return topcategory_id;
	}
	public void setTopcategory_id(int topcategory_id) {
		this.topcategory_id = topcategory_id;
	}
	public String getCategory_name() {
		return category_name;
	}
	public void setCategory_name(String category_name) {
		this.category_name = category_name;
	}
	
	
}
