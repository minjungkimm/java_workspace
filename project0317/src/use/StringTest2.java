package use;

class StringTest2{

	public static void main(String[] args){
		String str="korea java";
		char e=str.charAt(3);
		System.out.println(e); //1��

		int index=str.indexOf("a"); //2��
		System.out.println("ù��° a�� index ������"+index);
		
		String result=str.substring(index+5); //3��
		System.out.println("������ a�� index ������"+result);
		
		System.out.println(str.length()); //4��

		//str.replace("korea java","�ڸ��� java"); //5��
		//System.out.println(str); 

		//String result=str.substring(index,index)

		
		

	}
}
