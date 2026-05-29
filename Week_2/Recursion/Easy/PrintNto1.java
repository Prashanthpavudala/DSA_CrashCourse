package Week_2.Recursion.Easy;

public class PrintNto1 {
    // Recursive Function
    public static void printNumbers(int n) {
        if(n <= 0){
            return;
        }
        System.out.println(n);
        printNumbers(n-1);
    }

    public static void main(String[] args) {

        int n = 5;

        System.out.println("Printing Numbers from " + n + " to 1:");

        printNumbers(n);
    }
}
