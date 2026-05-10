package Week_1.Arrays_Hashing.Medium;

import java.util.Arrays;

/*
    Example:
    Input:  [1 2 3 4]
    Output: [24 12 8 6]
*/

public class ProductOfArrayExceptSelf {

    // TC: O(n^2), SC: O(n)
     public static int[] productExceptSelfBruteForce(int[] nums) {
        int[] result = new int[nums.length];

        for(int i=0; i<nums.length; i++){
            int product = 1;
            for(int j=0; j< nums.length; j++){
                if(i!=j){
                    product *= nums[j];
                }
            }
            result[i] = product;
        }
        return result;
    }
    
    // TC: O(n), SC: O(n)
    public static int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] prefix = new int[n];
        prefix[0] = 1;
        for(int i=1; i<n; i++){
            prefix[i] = prefix[i-1] * nums[i-1];
        }

        int[] suffix = new int[n];
        suffix[n-1] = 1;
        for(int i=n-2; i>=0; i--){
            suffix[i] = suffix[i+1] * nums[i+1];
        }

        for(int i=0; i<n; i++){
            prefix[i] = prefix[i] * suffix[i];
        }

        return prefix;
    }

    public static void main(String[] args) {

        // Example input
        // int[] nums = {1, 2, 3, 4};
        int[] nums = {-1, 1, 0, -3, 3};

        // Call function
        // int[] result = productExceptSelfBruteForce(nums);
        int[] result = productExceptSelf(nums);

        // Print output
        System.out.println("Input: " + Arrays.toString(nums));
        System.out.println("Output: " + Arrays.toString(result));
    }
}
