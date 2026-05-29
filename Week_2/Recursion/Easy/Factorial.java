package Week_2.Recursion.Easy;

public class Factorial {

    // Recursive Function
    public static int factorial(int n) {
        if(n == 0){
            return 1;
        }
        return n * factorial(n-1);
    }

    public static void main(String[] args) {

        int n = 5;

        System.out.println("Number: " + n);

        int result = factorial(n);

        System.out.println("Factorial: " + result);
    }
}