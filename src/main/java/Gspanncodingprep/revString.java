package Gspanncodingprep;

public class revString {
    public static void main(String[] args) {
        String str="Pratik";
        char[] chars=str.toCharArray();
        for(int i=str.length()-1;i>=0;i--) {
            System.out.print(chars[i]);
        }

    }
}
