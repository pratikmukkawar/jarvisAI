package Gspanncodingprep;

import java.util.Scanner;

class validAgevForVoter extends Exception {
    public validAgevForVoter(String message) {
        super(message);
    }
}
public class voting{
    public static void main(String[] args) {
        Scanner sc =new Scanner(System.in);

        System.out.println("Enter the age in years");
        int age =sc.nextInt();
        try{
            if (age<18){
                throw new validAgevForVoter("not eligible for voting");}
            System.out.println("eligible for voting");}
        catch (validAgevForVoter e) {
            System.out.println(e.getMessage());

            }
        }

    }
