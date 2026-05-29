package Week_2.Recursion.Easy;

public class ReverseString {
    public static String reverseString(String s) {
        if(s.length() == 1){
            return s;
        }
        return reverseString(s.substring(1)) + s.charAt(0);
    }

    public static void main(String[] args) {

        String s = "hello";

        System.out.println("Original String:");
        System.out.println(s);

        String sNew = reverseString(s);

        System.out.println("Reversed String:");
        System.out.println(sNew);
    }
}
