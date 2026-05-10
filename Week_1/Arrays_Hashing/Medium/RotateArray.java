package Week_1.Arrays_Hashing.Medium;

import java.util.Arrays;

public class RotateArray {

    /*
    Example:
    Input:
    arr = [1,2,3,4,5,6,7]
    k = 3

    Output:
    [5,6,7,1,2,3,4]

    Explanation:
    Rotate the array to the right by 3 steps.
    */

    // Brute force method
    // TC: O(n), SC: O(n)
    public static int[] rotateBrute(int[] arr, int k) {
        int n = arr.length;
        int[] arrBrute = new int[n];
        int j=0;
        for(int i=n-k; i<n; i++){
            arrBrute[j++] = arr[i];
        }
        for(int i=0; i<n-k; i++){
            arrBrute[j++] = arr[i];
        }
        return arrBrute;
    }

    // Optimized method
    // TC: O(n), SC: O(1)
    public static void rotateOptimized(int[] arr, int k) {
        int n = arr.length;
        reverse(arr, 0, n-1);
        reverse(arr, 0, k-1);
        reverse(arr, k, n-1);
    }

    public static void reverse(int[] arr, int left, int right){
        while(left < right){
            int temp = arr[left];
            arr[left] = arr[right];
            arr[right] = temp;
            left++;
            right--;
        }
    }

    public static void main(String[] args) {

        int[] arr1 = {1,2,3,4,5,6,7};
        int[] arr2 = {1,2,3,4,5,6,7};

        int k = 3;

        int[] arrBrute = rotateBrute(arr1, k);
        rotateOptimized(arr2, k);

        System.out.println("Brute Force Output: " +
                Arrays.toString(arrBrute));

        System.out.println("Optimized Output: " +
                Arrays.toString(arr2));
    }
}