package Week_1.Arrays_Hashing.Easy;

import java.util.Arrays;

public class MoveZeros {
    
    /*  TC: O(n), SC: O(1)
        i → scans the array
        j → tracks where the next non-zero should go   
    */ 
    public static void moveZeros(int[] arr) {

        int j=0;
        
        for(int i=0; i<arr.length; i++){
            if(arr[i] != 0){
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
                j++;
            }
        }

    }

    /*
        Dry run
        iteration i=0 no change
        iteration i=1 
                    [1, 0, 0, 3, 12]
                    j=1
        iteration i=2 no change
        iteration i=3 
                    [1, 3, 0, 0, 12]
                    j=2
        iteration i=4 
                    [1, 3, 12, 0, 0]
                    j=3
    */

    public static void main(String[] args) {

        int[] arr = {0, 1, 0, 3, 12};

        moveZeros(arr);

        System.out.println("Array after moving zeros: " + Arrays.toString(arr));
    }
}
