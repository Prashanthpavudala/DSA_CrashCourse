package Week_2.Recursion.Easy;

public class SumOfFirstNnumbers {
    // Recursive Function
    public static int sumOfN(int n) {
        if(n <= 0){
            return 0;
        }
        return n + sumOfN(n-1);
    }

    public static void main(String[] args) {

        int n = 10;

        System.out.println("Number: " + n);

        int result = sumOfN(n);

        System.out.println("Sum of First " + n + " Numbers: " + result);
    }
}
