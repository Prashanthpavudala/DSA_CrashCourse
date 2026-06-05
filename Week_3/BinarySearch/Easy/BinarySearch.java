package Week_3.BinarySearch.Easy;

import java.util.Arrays;

public class BinarySearch {
    public static int binarySearch(int[] nums, int target) {
        int left=0, right=nums.length-1;
        while(left <= right){
            int mid = left + (right-left)/2;
            if(nums[mid] == target){
                return mid;
            }else if(nums[mid] < target){
                left = mid+1;
            }else{
                right = mid-1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {

        int[] nums = {1, 3, 5, 7, 9, 11, 13};
        int target = 7;

        System.out.println("Array:"+ Arrays.toString(nums));

        System.out.println("\nTarget: " + target);

        int result = binarySearch(nums, target);

        if (result != -1) {
            System.out.println("Target found at index: " + result);
        } else {
            System.out.println("Target not found.");
        }
    }
}
