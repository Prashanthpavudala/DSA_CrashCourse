package Week_3.BinarySearch.Easy;

public class SearchInsertPosition {

    // Brute Force Approach
    // O(n) Time, O(1) Space
    public static int bruteForce(int[] nums, int target) {
        int n = nums.length;
        for(int i=0; i<n; i++){
            if(nums[i] >= target){
                return i;
            }
        }
        return nums.length;
    }

    // Optimized Binary Search Approach
    // O(log n) Time, O(1) Space
    public static int optimized(int[] nums, int target) {
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
        return left;
    }

    public static void main(String[] args) {

        int[] nums = {1, 3, 5, 6};
        int target = 2;

        System.out.print("Array: ");
        for (int num : nums) {
            System.out.print(num + " ");
        }

        System.out.println("\nTarget: " + target);

        int bruteResult = bruteForce(nums, target);
        System.out.println("Brute Force Result: " + bruteResult);

        int optimizedResult = optimized(nums, target);
        System.out.println("Optimized Result: " + optimizedResult);
    }
}
