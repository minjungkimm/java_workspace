class  Customer{
    private String name;
    private int age;
    boolean isMarry;

	public void setName(String name){
		this.name=name;
	}
	public String getName(){
		return name;
	}

	public void setAge(int age){
		this.age=age;
	}
	public int getAge(){
		return age;
	}

	public void setIsMarry(boolean isMarry){
		this.isMarry=isMarry; //��԰��ġ��
	}
	public boolean getIsMarry(){
		return isMarry;
	}
}
