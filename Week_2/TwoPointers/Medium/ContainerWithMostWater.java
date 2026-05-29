package Week_2.TwoPointers.Medium;

public class ContainerWithMostWater {

    /*
        Problem:
        You are given an integer array height where height[i]
        represents the height of a vertical line.

        Find two lines that together with the x-axis form a container
        that can store the maximum amount of water.

        Return the maximum area of water a container can store.

        ------------------------------------------------------

        Example:

        Input:
        height = [1,8,6,2,5,4,8,3,7]

        Output:
        49

        Explanation:

        Choose:
        left line  = height[1] = 8
        right line = height[8] = 7

        Width = 8 - 1 = 7

        Height of container =
        minimum(8, 7) = 7

        Area =
        width * minHeight
        = 7 * 7
        = 49

        This is the maximum possible area.
    */

    // ------------------------------------------------------
    // Brute Force
    // TC: O(n^2) SC: O(1)
    public static int bruteForce(int[] height) {
        if(height==null || height.length==0){
            return -1;
        }
        int n = height.length;
        int maxArea = 0;
        for(int i=0; i<n; i++){
            for(int j=i+1; j<n; j++){
                int area = (j-i) * Math.min(height[i], height[j]);
                maxArea = Math.max(area, maxArea);
            }
        }
        return maxArea;
    }

    // ------------------------------------------------------
    // Optimized - Two Pointers
    // TC: O(n) SC: O(1)
    public static int optimized(int[] height) {
        if(height==null || height.length==0){
            return -1;
        }
        int n = height.length;
        int maxArea = 0;
        int left = 0;
        int right = n-1;
        while(left < right){
            int area = (right-left) * Math.min(height[left], height[right]);
            maxArea = Math.max(area, maxArea);
            if(height[left] < height[right]){
                left++;
            }else{
                right--;
            }
        }
        return maxArea;
    }

    // ------------------------------------------------------

    public static void main(String[] args) {

        int[] height = {1,8,6,2,5,4,8,3,7};

        System.out.println("Brute Force Answer: " + bruteForce(height));

        System.out.println("Optimized Answer: " + optimized(height));
    }
}