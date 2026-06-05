package Week_3.BinarySearch.Medium;

import java.util.Arrays;

public class SearchInRotatedSortedArray {
    
    // Brute Force Approach
    public static int bruteForce(int[] nums, int target) {
        int n=nums.length;
        for(int i=0; i<n; i++){
            if(nums[i] == target){
                return i;
            }
        }
        return -1;
    }

    // Optimized Binary Search Approach
    public static int optimized(int[] nums, int target) {
        int left=0, right=nums.length-1;
        while(left <= right){
            int mid = left + (right-left)/2;
            if(nums[mid] == target){
                return mid;
            }
            //left sorted
            if(nums[left] <= nums[mid]){
                //left half
                if(nums[left] <= target && target < nums[mid]){
                    right = mid-1;
                }else{
                    left = mid+1;
                }
            }else{//right half
                if(nums[mid] < target && target <= nums[right]){
                    left = mid+1;
                }else{
                    right = mid-1;
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {

        int[] nums = {4, 5, 6, 7, 0, 1, 2};
        int target = 0;

        System.out.print("Array: " + Arrays.toString(nums));

        System.out.println("\nTarget: " + target);

        int bruteResult = bruteForce(nums, target);
        System.out.println("Brute Force Result: " + bruteResult);

        int optimizedResult = optimized(nums, target);
        System.out.println("Optimized Result: " + optimizedResult);
    }
}
