package Week_1.Arrays.Medium;

import java.util.Arrays;

public class MergeSortedArray {

    /*
    Example:
    Input:
    arr1 = [1, 3, 5]
    arr2 = [2, 4, 6]

    Output:
    [1, 2, 3, 4, 5, 6]
    */

    // Brute force method
    // TC: O((n+m)log(n+m)), SC: O(n+m)
    public static int[] mergeBrute(int[] arr1, int[] arr2) {
        int n = arr1.length;
        int m = arr2.length;
        int[] result = new int[n+m];

        // for(int i=0; i<n; i++){
        //     result[i] = arr1[i];
        // }

        System.arraycopy(arr1, 0, result, 0, n);

        // for(int j=0; j<m; j++){
        //     result[n++] = arr2[j];
        // }

        System.arraycopy(arr2, 0, result, n, m);

        Arrays.sort(result);

        return result;
    }

    // Optimized method
    // TC: O(n+m), SC: O(n+m)
    public static int[] mergeOptimized(int[] arr1, int[] arr2) {
        int n = arr1.length;
        int m = arr2.length;
        int[] result = new int[n+m];

        int i=0, j=0, k=0;

        while(i<n && j<m){
            if(arr1[i] < arr2[j]){
                result[k++] = arr1[i++];
            }else{
                result[k++] = arr2[j++];
            }
        }

        while(i < n){
            result[k++] = arr1[i++];
        }

        while(j < m){
            result[k++] = arr2[j++];
        }

        return result;
    }

    public static void main(String[] args) {

        int[] arr1 = {1, 3, 5};
        int[] arr2 = {2, 4, 6};

        int[] brute = mergeBrute(arr1, arr2);
        int[] optimized = mergeOptimized(arr1, arr2);

        System.out.println("Brute Force Output: " + Arrays.toString(brute));
        System.out.println("Optimized Output: " + Arrays.toString(optimized));
    }
}