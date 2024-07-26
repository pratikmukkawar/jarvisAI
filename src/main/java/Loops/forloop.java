package Loops;

import java.util.Scanner;

public class forloop {

	public static void main(String[] args) {
		//String str ="Pratik Mukkawar";
		
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter your string");
		String str=sc.nextLine();
		int length=str.length();
		
		for(int i=length-1;i>=0;i--) {
			
			System.out.print(str.charAt(i));
		}

	}

}
