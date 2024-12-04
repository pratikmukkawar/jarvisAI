package Gspanncodingprep;

public class countLenghtWithoutFunction {
    public static void main(String[] args) {
        String str="Pratik";
        int length=0;
        char[] chars=str.toCharArray();
        for(char c:chars){
            length++;
        }
        System.out.println(length);
    }
}
