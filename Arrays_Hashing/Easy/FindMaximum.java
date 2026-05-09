package Arrays_Hashing.Easy;

public class FindMaximum {
    // TC: O(n), SC: O(1)
    public static int findMaximum(int[] arr) {
        int max = Integer.MIN_VALUE;
        for(int num : arr){
            max = Math.max(max, num);
        }
        return max;
    }

    public static void main(String[] args) {

        int[] arr = {13, 7, 2, 9, 5};

        int result = findMaximum(arr);

        System.out.println("Maximum element is: " + result);
    }
}
