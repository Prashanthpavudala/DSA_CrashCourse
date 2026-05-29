package Week_1.Hashing.Easy;

import java.util.HashSet;

public class ContainsDuplicate {


    // TC: O(n^2)
    // SC: O(1)
    public static boolean containsDuplicateBruteForce(int[] nums) {
        int n = nums.length;
        for(int i=0; i<n; i++){
            for(int j=i+1; j<n; j++){
                if(nums[i]==nums[j]){
                    return true;
                }
            }
        }
        return false;
    }



    // TC: O(n)
    // SC: O(n)
    public static boolean containsDuplicateOptimized(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        for(int num : nums){
            if(set.contains(num)){
                return true;
            }
            set.add(num);
        }
        return false;
    }


    public static void main(String[] args) {

        // Example Input
        int[] nums = {1, 2, 3, 1};

        // Calling Brute Force
        boolean bruteResult = containsDuplicateBruteForce(nums);

        // Calling Optimized
        boolean optimizedResult = containsDuplicateOptimized(nums);

        // Printing Results
        System.out.println("Brute Force Result: " + bruteResult);
        System.out.println("Optimized Result: " + optimizedResult);
    }
}
