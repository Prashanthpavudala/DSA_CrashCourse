package Week_1.Hashing.Easy;

import java.util.HashMap;

public class TwoSum {
    /*
     * Example Input:
     *
     * Array = {2, 7, 11, 15}
     * Target = 9
     *
     * Explanation:
     * 2 + 7 = 9
     *
     * Indices:
     * 2 is at index 0
     * 7 is at index 1
     */

    // TC: O(n^2), SC: O(1)
    public static int[] brute(int[] arr, int target) {
        int n = arr.length;
        for(int i=0; i<n; i++){
            for(int j=i+1; j<n;j++){
                if(arr[i]+arr[j] == target){
                    return new int[]{i, j};
                }
            }
        }
        return new int[]{-1, -1};
    }

    // TC: O(n), SC: O(n)
    public static int[] optimized(int[] arr, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i=0; i<arr.length; i++){
            int complement = target - arr[i];
            if(map.containsKey(complement)){
                return new int[]{map.get(complement), i};
            }
            map.put(arr[i], i);
        }
        return new int[]{-1, -1};
    }

    public static void main(String[] args) {

        int[] arr = { 2, 3, 3, 7, 11, 15 };
        int target = 6;

        // Brute Force Result
        int[] bruteResult = brute(arr, target);

        System.out.println("Brute Force Result:");
        System.out.println("Indices: " + bruteResult[0] + ", " + bruteResult[1]);

        // Optimized Result
        int[] optimizedResult = optimized(arr, target);

        System.out.println("\nOptimized Result:");
        System.out.println("Indices: " + optimizedResult[0] + ", " + optimizedResult[1]);
    }
}
