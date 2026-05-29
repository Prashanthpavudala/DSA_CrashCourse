package Week_1.Arrays.Easy;

import java.util.Arrays;

public class ReverseArray {
    
     // TC: O(n), SC: O(1)
    public static void reverseArray(int[] arr) {

        int left = 0, right = arr.length-1, temp = 0;

        while(left < right){
            temp = arr[left];
            arr[left] = arr[right];
            arr[right] = temp;
            left++;
            right--;
        }

    }

    public static void main(String[] args) {

        int[] arr = {1, 2, 3, 4, 5};

        reverseArray(arr);

        System.out.print("Reversed array: " + Arrays.toString(arr));
    }
}
