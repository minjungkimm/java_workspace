package api;

class StringTest{

	public static void main(String[] args){
		//String 은 불변이다 (immutable)
		String str="korea"; //기존 (생성과 동시에 고정됨) 
		str=str+"fighting"; //코리아+파이팅 (새로운 문자 생성됨)
		//서로 따로 존재하는 것이므로, 주소값도 따로 존재..
		
		for(int i=1;i<100;i++){
			str=str+i; //for문 돌면서 처음상태에서 수정이 아닐
			//100개의 문자열 객체가 생성되는것..
			//여기서 korea 가 수정될것으로
			//생각되지만 사실상은 String 한번 생성되면
			//절대 변경되지 않는 상수다!!
			//상수는 변경되지 않는다!!!
		}
		//해결책!) String을 이용하여 많은 문자열을
		//조합하려고 할때는 어떻게 해야하나?
		//변경가능한 문자열을 처리해주는 api 이용
		StringBuffer sb=new StringBuffer();
		//StringBuffer에 추가될 뿐이며, 새로운 문자열 상수를
		//생성하지 않는다.. 즉 1개로 개발가능..
		sb.append("korea");
		sb.append("fighting");
		sb.append("and");
		sb.append("forever");
		
		//sb는 String형이 아니기 때문에,
		//println 인수로 넣으면 (자동변환되긴 하지만)
		//정석대로 개발한다면, String 형으로 변환해야 한다!!!
		//...Object 라는 최상위 객체가 보유한
		//메서드 중 객체를 String 으로 변환해주는
		//메서드가 있다.. 바로 toString()
		System.out.println(sb.toString());
	}
}
