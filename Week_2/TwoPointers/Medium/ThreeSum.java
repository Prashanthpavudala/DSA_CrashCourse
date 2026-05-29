package Week_2.TwoPointers.Medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ThreeSum {
    /*
        Example 1:

        Input:
        nums = [-1,0,1,2,-1,-4]

        Output:
        [[-1,-1,2],[-1,0,1]]

        Explanation:

        Triplets whose sum = 0 are:

        1) -1 + -1 + 2 = 0
        2) -1 +  0 + 1 = 0

        So the answer is:
        [[-1,-1,2],[-1,0,1]]
    */

    
    public static List<List<Integer>> bruteForce(int[] nums) {
        Set<List<Integer>> result = new HashSet<>();
        int n = nums.length;
        Arrays.sort(nums);
        for(int i=0; i<n-2; i++){
            for(int j=i+1; j<n-1; j++){
                for(int k=j+1; k<n; k++){
                    if(nums[i]+nums[j]+nums[k] == 0){
                        result.add(Arrays.asList(nums[i],nums[j],nums[k]));
                    }
                }
            }
        }
        return new ArrayList<>(result);
    }

    
    public static List<List<Integer>> optimized(int[] nums) {
        Set<List<Integer>> result = new HashSet<>();
        int n = nums.length;
        Arrays.sort(nums);
        for(int i=0; i<n-2 ; i++){
            int left = i+1;
            int right = n-1;
            while(left < right){
                int sum = nums[i] + nums[left] + nums[right];
                if(sum == 0){
                    result.add(Arrays.asList(nums[i],nums[left],nums[right]));
                    left++;
                    right--;
                }else if(sum < 0){
                    left++;
                }else{
                    right--;
                }
            }
        }
        return new ArrayList<>(result);
    }

    public static void main(String[] args) {

        int[] nums = {-1, 0, 1, 2, -1, -4};

        System.out.println("Input Array:");
        System.out.println(Arrays.toString(nums));

        System.out.println("\nBrute Force Result:");
        System.out.println(bruteForce(nums));

        System.out.println("\nOptimized Result:");
        System.out.println(optimized(nums));
    }
}