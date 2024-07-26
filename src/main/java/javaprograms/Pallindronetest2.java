package javaprograms;

import java.util.Scanner;

public class Pallindronetest2 {
	public static void main(String[] args) {
		
		String original,reverse="";
		
		Scanner sc = new Scanner(System.in);
		System.out.println("enter number or string");
		
		original=sc.nextLine();
		
		int length = original.length();
		
		for(int i=length-1;i>=0;i--)
			reverse=reverse + original.charAt(i);
			
			if(original.toLowerCase().equals(reverse.toLowerCase())) 
				System.out.println("it is Palindrome");
			else 
				System.out.println("It is NOT Pallindrome");
			}
		}
				
	
