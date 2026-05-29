package Week_2.Recursion.Easy;

public class Print1toN {
    // Recursive Function
    public static void printNumbers(int n) {
        if(n <= 0){
            return;
        }
        printNumbers(n-1);
        System.out.println(n);
    }

    public static void main(String[] args) {

        int n = 5;

        System.out.println("Printing Numbers from 1 to " + n + ":");

        printNumbers(n);
    }
}
