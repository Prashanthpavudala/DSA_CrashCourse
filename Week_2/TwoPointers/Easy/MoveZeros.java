package Week_2.TwoPointers.Easy;

import java.util.Arrays;

public class MoveZeros {
    /*
        Problem Statement:
        Given an integer array nums,
        move all 0's to the end of it
        while maintaining the relative order
        of the non-zero elements.

        You must do this in-place.

        ------------------------------------------------

        Example 1:

        Input:
        nums = [0,1,0,3,12]

        Output:
        [1,3,12,0,0]

        Explanation:

        Step 1:
        Move all non-zero elements forward
        -> [1,3,12,_,_]

        Step 2:
        Fill remaining positions with 0
        -> [1,3,12,0,0]

        ------------------------------------------------

        Example 2:

        Input:
        nums = [0]

        Output:
        [0]
    */


    // ------------------------------------------------
    // BRUTE FORCE
    // TC: O(n) SC: O(n)
    public static void bruteForce(int[] nums) {
        int n = nums.length;
        int[] temp = new int[n];
        int insertPos = 0;
        for(int i=0; i<n; i++){
            if(nums[i] != 0){
                temp[insertPos] = nums[i];
                insertPos++;
            }
        }
        for(int i=0; i<n; i++){
            nums[i] = temp[i];
        }
    }


    // ------------------------------------------------
    // OPTIMIZED APPROACH (Two Pointers)
    // TC: O(n) SC: O(1)
    public static void optimized(int[] nums) {
        int left = 0;
        int n = nums.length;
        for(int right = 0; right < n; right++){
            if(nums[right]!=0){
                int temp = nums[right];
                nums[right] = nums[left];
                nums[left] = temp;
                left++;
            }
        }
    }


    public static void main(String[] args) {

        int[] nums1 = {0, 1, 0, 3, 12};

        System.out.println("Original Array:");
        System.out.println(Arrays.toString(nums1));

        // Brute Force
        int[] bruteArray = nums1.clone();
        bruteForce(bruteArray);

        System.out.println("\nAfter Brute Force:");
        System.out.println(Arrays.toString(bruteArray));


        // Optimized
        int[] optimizedArray = nums1.clone();
        optimized(optimizedArray);

        System.out.println("\nAfter Optimized Approach:");
        System.out.println(Arrays.toString(optimizedArray));
    }
}