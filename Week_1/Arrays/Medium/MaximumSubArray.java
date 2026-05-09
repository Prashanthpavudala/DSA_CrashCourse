package Week_1.Arrays.Medium;

public class MaximumSubArray {
    
    /*
    Example:
    Input:  [-2,1,-3,4,-1,2,1,-5,4]
    Output: 6

    Explanation:
    Subarray [4,-1,2,1] has the largest sum = 6
    */

    // Brute force method
    // TC: O(n^2), SC: O(1)
    public static int maxSubArrayBrute(int[] arr) {
        int n = arr.length;
        int maxSum = 0;
        for(int i=0; i<n;i++){
            int currSum = 0;
            for(int j=i; j<n; j++){
                currSum = currSum + arr[j];
                maxSum = Math.max(currSum, maxSum);
            }
        }
        return maxSum;
    }

    // Optimized method
    // TC: O(n), SC: O(1)
    public static int maxSubArrayOptimized(int[] arr) {
        int maxSum = 0;
        int currSum = 0;
        for(int i=0; i<arr.length; i++){
            currSum = Math.max(arr[i], currSum + arr[i]);
            maxSum = Math.max(currSum, maxSum);
        }
        return maxSum;
    }

    public static void main(String[] args) {

        int[] arr = {-2,1,-3,4,-1,2,1,-5,4};

        int brute = maxSubArrayBrute(arr);
        int optimized = maxSubArrayOptimized(arr);

        System.out.println("Brute Force Answer: " + brute);
        System.out.println("Optimized Answer: " + optimized);
    }

}