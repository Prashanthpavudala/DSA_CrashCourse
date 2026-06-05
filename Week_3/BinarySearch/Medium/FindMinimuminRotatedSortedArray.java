package Week_3.BinarySearch.Medium;

import java.util.Arrays;

public class FindMinimuminRotatedSortedArray {
    // Brute Force Approach
    public static int bruteForce(int[] nums) {
        int n = nums.length;
        int result = Integer.MAX_VALUE;
        for(int num : nums){
            result = Math.min(num, result);
        }
        return result;
    }

    // Optimized Binary Search Approach
    public static int optimized(int[] nums) {
        int left=0, right=nums.length-1;
        while(left < right){
            int mid = left + (right-left)/2 ;
            if(nums[mid] > nums[right]){
                left = mid+1;
            }else{
                right = mid;
            }
        }
        return nums[left];
    }

    public static void main(String[] args) {

        int[] nums = {4, 5, 6, 7, 0, 1, 2};

        System.out.println("Array: " + Arrays.toString(nums));

        int bruteResult = bruteForce(nums);
        System.out.println("Brute Force Result: " + bruteResult);

        int optimizedResult = optimized(nums);
        System.out.println("Optimized Result: " + optimizedResult);
    }
}
