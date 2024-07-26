package javaprograms;

public class finaltest1 {

	 final int x = 10;
	 static int y = 15;

	  public static void main(String[] args) {
		  finaltest1 r = new finaltest1();
	    r.y=20; // will generate an error: cannot assign a value to a final variable
	  System.out.println(r.y);
	  }
	}
