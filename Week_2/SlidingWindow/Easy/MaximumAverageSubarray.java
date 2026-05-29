package Week_2.SlidingWindow.Easy;

public class MaximumAverageSubarray {

    /*
        Input: nums = [1,12,-5,-6,50,3], k = 4
        Output: 12.75000
        Explanation: Maximum average is (12 - 5 - 6 + 50) / 4 = 51 / 4 = 12.75
    */

    public static double findMaxAverageBrute(int[] nums, int k) {
        int n = nums.length;
        int maxSum = Integer.MIN_VALUE;
        for(int i=0; i<n-k+1; i++){
            int currSum = 0;
            for(int j=i; j<i+k; j++){
                currSum += nums[j];
            }
            maxSum = Math.max(maxSum, currSum);
        }
        return (double)maxSum/k;
    }

    public static double findMaxAverageOptimized(int[] nums, int k) {
        int maxSum = Integer.MIN_VALUE;
        int left = 0;
        int windowSum = 0;
        for(int right=0; right<nums.length; right++){
            windowSum += nums[right];
            if(right-left+1 == k){
                maxSum = Math.max(maxSum, windowSum);
                windowSum -= nums[left];
                left++;
            }
        }
        return (double)maxSum/k;
    }

    public static void main(String[] args) {

        int[] nums = {1, 12, -5, -6, 50, 3};

        int k = 4;

        // Brute Force Result
        double bruteResult = findMaxAverageBrute(nums, k);

        // Optimized Result
        double optimizedResult = findMaxAverageOptimized(nums, k);

        System.out.println("Brute Force Maximum Average = " + bruteResult);

        System.out.println("Optimized Sliding Window Maximum Average = " + optimizedResult);
    }
}
