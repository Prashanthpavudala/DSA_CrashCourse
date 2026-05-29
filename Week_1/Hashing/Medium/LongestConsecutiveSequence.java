package Week_1.Hashing.Medium;

import java.util.Arrays;
import java.util.HashSet;

public class LongestConsecutiveSequence {
     /*
        Example 1:

        Input:
        nums = [100, 4, 200, 1, 3, 2]

        Output:
        4

        Explanation:
        The longest consecutive sequence is:
        [1, 2, 3, 4]

        Length = 4
    */

    // Brute Force Approach
    //TC - O(n^2) SC - O(n)
    public static int longestConsecutiveBrute(int[] nums) {
        int longest = 0;

        HashSet<Integer> set = new HashSet<>();
        for(int num : nums){
            set.add(num);
        }

        for(int num : set){
            int current = num;
            int count = 1;
            while(set.contains(current+1)){
                current++;
                count++;
            }
            longest = Math.max(longest, count);
        }

        return longest;
    }

    // Optimized Approach
    //TC - O(n) SC - O(n)
    public static int longestConsecutiveOptimal(int[] nums) {
        int longest = 0;
        HashSet<Integer> set = new HashSet<>();
        for(int num : nums){
            set.add(num);
        }

        for(int num : set){
            // Only start counting when: num - 1 does NOT exist
            if(!set.contains(num-1)){
                int current = num;
                int count = 1;
                while(set.contains(current+1)){
                    current++;
                    count++;
                }
                longest = Math.max(count, longest);
            }
        }

        return longest;
    }


    public static void main(String[] args) {

        int[] nums = {100, 4, 200, 1, 3, 2};

        System.out.println("Input Array:");
        System.out.println(Arrays.toString(nums));

        int bruteAnswer = longestConsecutiveBrute(nums);
        System.out.println("Brute Force Answer: " + bruteAnswer);

        int optimalAnswer = longestConsecutiveOptimal(nums);
        System.out.println("Optimized Answer: " + optimalAnswer);
    }
}
