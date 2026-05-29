package Week_2.TwoPointers.Medium;

import java.util.Arrays;

public class SortColors {

    /*
        Problem:
        Given an array nums with n objects colored red, white, or blue,
        sort them in-place so that objects of the same color are adjacent.

        We will use:
        0 -> Red
        1 -> White
        2 -> Blue

        Example:

        Input:
        nums = [2,0,2,1,1,0]

        Output:
        [0,0,1,1,2,2]

        Explanation:

        Before Sorting:
        [2,0,2,1,1,0]

        After Sorting:
        [0,0,1,1,2,2]
    */


    // ---------------------------------------------------
    // BRUTE FORCE APPROACH
    public static void bruteForce(int[] nums) {
        int zerosCount = 0, onesCount = 0, twosCount = 0;
        for(int num : nums){
            if(num == 0)
                zerosCount++;
            else if(num == 1)
                onesCount++;
            else
                twosCount++;
        }
        int index=0;
        while(zerosCount > 0){
            nums[index++] = 0;
            zerosCount--;
        }
        while(onesCount > 0){
            nums[index++] = 1;
            onesCount--;
        }
        while(twosCount > 0){
            nums[index++] = 2;
            twosCount--;
        }
    }


    // ---------------------------------------------------
    // OPTIMIZED APPROACH (Dutch National Flag Algorithm)
    public static void optimized(int[] nums) {
        int left = 0, middle = 0, right = nums.length-1;
        while(middle < right){
            if(nums[middle] == 0){
                swap(nums, left, middle);
                middle++;
                left++;
            }else if(nums[middle] == 1){
                middle++;
            }else{
                swap(nums, middle, right);
                middle++;
                right--;
            }
        }
    }


    public static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }


    // ---------------------------------------------------
    // MAIN FUNCTION
    // ---------------------------------------------------

    public static void main(String[] args) {

        int[] nums1 = {2, 0, 2, 1, 1, 0};

        System.out.println("Original Array:");
        System.out.println(Arrays.toString(nums1));

        // Brute Force
        bruteForce(nums1);

        System.out.println("\nAfter Brute Force Sorting:");
        System.out.println(Arrays.toString(nums1));



        int[] nums2 = {2, 0, 2, 1, 1, 0};

        // Optimized
        optimized(nums2);

        System.out.println("\nAfter Optimized Sorting:");
        System.out.println(Arrays.toString(nums2));
    }
}