package Week_2.Recursion.Medium;

public class Fibonacci {
    // Recursive Function
    public static int fibonacci(int n) {
        if(n == 0 || n == 1){
            return n;
        }
        return fibonacci(n-1) + fibonacci(n-2);
    }

    // Non-Recursive Function
    public static int NonRecursivefibonacci(int n) {
        if(n==0 || n==1){
            return n;
        }
        int prev2 = 0;
        int prev1 = 1;
        int current = 0;
        for(int i=2; i<=n; i++){
            current = prev2 + prev1;
            prev2 = prev1;
            prev1 = current;
        }
        return current;
    }

    public static void main(String[] args) {

        int n = 6;

        System.out.println("Fibonacci Series up to position " + n + " (Recursive):");
        for (int i = 0; i <= n; i++) {
            System.out.print(fibonacci(i) + " ");
        }

        System.out.println("\n\nFibonacci Series up to position " + n + " (Non-Recursive):");
        for (int i = 0; i <= n; i++) {
            System.out.print(NonRecursivefibonacci(i) + " ");
        }
    }
}
