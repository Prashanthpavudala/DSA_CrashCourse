package Week_1.Hashing.Medium;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class SubarraySumEqualsK {

     /*
     * Brute Force Approach (to be implemented by you)
     * Idea:
     * - Try every possible subarray
     * - Compute sum and check if it equals k
     */
    public static int bruteForce(int[] nums, int k) {
        int n = nums.length;
        int count = 0;
        for(int i=0; i<n; i++){
            int sum = 0;
            for(int j=i; j<n; j++){
                sum += nums[j];
                if(sum == k){
                    count++;
                }
            }
        }
        return count;
    }

    /*
     * Optimized Approach (to be implemented by you)
     * Idea:
     * - Use prefix sum + HashMap to track frequencies
     * - Count how many times (prefixSum - k) has appeared
     */
    public static int optimized(int[] nums, int k) {
        Map<Integer, Integer> sumCountMap = new HashMap<>();
        sumCountMap.put(0, 1);
        int prefixSum = 0;
        int count = 0;
        for(int num : nums){
            prefixSum += num;
            if(sumCountMap.containsKey(prefixSum-k)){
                count += sumCountMap.get(prefixSum-k);
            }
            sumCountMap.put(prefixSum, sumCountMap.getOrDefault(prefixSum, 0)+1);
        }
        return count;
    }
    
    public static void main(String[] args) {

        int[] nums = {1, 2, 3, -1, 1, 1, 1};
        int k = 3;

        System.out.println("Input Array: " + Arrays.toString(nums));
        System.out.println("Target K: " + k);

        // Brute Force Approach
        int bruteResult = bruteForce(nums, k);
        System.out.println("Brute Force Result: " + bruteResult);

        // Optimized Approach
        int optimizedResult = optimized(nums, k);
        System.out.println("Optimized Result: " + optimizedResult);
    }

}
