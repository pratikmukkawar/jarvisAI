package numberpatterns;

import java.util.Scanner;

public class armstrongnumber {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
	      int number;
	      System.out.println("Enter any number:");
	      number= sc.nextInt();
	        double sum = 0;
	        int orgNumber = number, digit;
	        while(number>0)
	        {
	            digit = number%10;
	            sum = sum+Math.pow(digit,3);
	            number = number/10;
	        }
	        if(orgNumber == sum)
	        System.out.println ("Number is Armstrong");
	        else
	        System.out.println ("Number is not Armstrong");
	    }
	}