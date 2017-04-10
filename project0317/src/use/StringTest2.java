package use;

class StringTest2{

	public static void main(String[] args){
		String str="korea java";
		char e=str.charAt(3);
		System.out.println(e); //1번

		int index=str.indexOf("a"); //2번
		System.out.println("첫번째 a의 index 순번은"+index);
		
		String result=str.substring(index+5); //3번
		System.out.println("마지막 a의 index 순번은"+result);
		
		System.out.println(str.length()); //4번

		//str.replace("korea java","코리아 java"); //5번
		//System.out.println(str); 

		//String result=str.substring(index,index)

		
		

	}
}
