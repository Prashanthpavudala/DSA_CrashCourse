package Week_3.BinarySearch.Medium;

public class FindPeakElement {
    
    // Brute Force Approach
    public static int bruteForce(int[] nums) {
        int n=nums.length;
        for(int i=0; i<n; i++){
            if(nums[i] > nums[i+1]){
                return i;
            }
        }
        return n-1;
    }

    // Optimized Binary Search Approach
    public static int optimized(int[] nums) {
        int left=0, right=nums.length-1;
        while(left < right){
            int mid = left + (right-left)/2;
            if(nums[mid] < nums[mid+1]){
                left=mid+1;
            }else{
                right=mid;
            }
        }
        return left;
    }

    public static void main(String[] args) {

        int[] nums = {1, 2, 3, 1};

        System.out.print("Array: ");
        for (int num : nums) {
            System.out.print(num + " ");
        }

        System.out.println();

        int bruteResult = bruteForce(nums);
        System.out.println("Brute Force Peak Index: " + bruteResult);

        int optimizedResult = optimized(nums);
        System.out.println("Optimized Peak Index: " + optimizedResult);
    }
}
