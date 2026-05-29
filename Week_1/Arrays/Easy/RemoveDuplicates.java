package Week_1.Arrays.Easy;

import java.util.Arrays;

public class RemoveDuplicates {
    
    // TC: O(n), SC: O(n)
    // public static int removeDuplicates(int[] arr) {

    //     Set<Integer> set = new LinkedHashSet<>();

    //     for(int num : arr){
    //         set.add(num);
    //     }

    //     int i=0;
    //     for(int num : set){
    //         arr[i] = num;
    //         i++;
    //     }

    //     return i;
    // }

    /*  TC: O(n), SC: O(1)
        i → scans the array
        j → tracks where the next unique should go   
    */ 
    public static int removeDuplicates(int[] arr) {

        if(arr.length == 0){
            return 0;
        }

        int j=1;
        for(int i=1; i<arr.length; i++){
            if(arr[i] != arr[i-1]){
                arr[j] = arr[i];
                j++;
            }
        }

        return j;
    }

    /*
        Dry run
        iteration i=1 no change
        iteration i=2 
                    [1, 2, 2, 2, 3, 4, 4]
                    j=2
        iteration i=3 no change
        iteration i=4 
                    [1, 2, 3, 2, 3, 4, 4]
                    j=3
        iteration i=5 
                    [1, 2, 3, 4, 3, 4, 4]
                    j=4
        iteration i=6 no change
    */

    public static void main(String[] args) {

        int[] arr = {1, 1, 2, 2, 3, 4, 4};

        int k = removeDuplicates(arr);

        System.out.println("Unique elements count: " + k);

        System.out.print("Array after removing duplicates: " + Arrays.toString(arr));
    }
}
