class  HighHeel{
   String color="None Color";
   
   public void HighHeel(String color){
	   this.color=color;
   }

   public static void main(String[] args){
		HighHeel h1= new HighHeel();
		h1.HighHeel("pink");
		System.out.println(h1.color);
   }
}

