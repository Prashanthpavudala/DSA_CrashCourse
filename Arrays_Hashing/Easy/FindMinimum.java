package Arrays_Hashing.Easy;

public class FindMinimum {
    // TC: O(n), SC: O(1)
    public static int findMinimum(int[] arr) {
        int min = Integer.MAX_VALUE;
        for(int num : arr){
            min = Math.min(min, num);
        }
        return min;
    }

    public static void main(String[] args) {

        int[] arr = {3, 7, 2, 9, 5};

        int result = findMinimum(arr);

        System.out.println("Minimum element is: " + result);
    }
}
