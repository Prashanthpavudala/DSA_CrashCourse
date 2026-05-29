package Week_2.TwoPointers.Easy;

public class ValidPalindrome {

    /*
        Valid Palindrome

        A phrase is a palindrome if,
        after converting all uppercase letters into lowercase letters
        and removing all non-alphanumeric characters,
        it reads the same forward and backward.

        Alphanumeric characters include letters and numbers.

        ------------------------------------------------------

        Example 1:

        Input:
        s = "A man, a plan, a canal: Panama"

        Output:
        true

        Explanation:

        After removing special characters and converting to lowercase:

        "amanaplanacanalpanama"

        Forward  -> amanaplanacanalpanama
        Backward -> amanaplanacanalpanama

        Both are same, so return true.

        ------------------------------------------------------

        Example 2:

        Input:
        s = "race a car"

        Output:
        false

        Explanation:

        Cleaned string:
        "raceacar"

        Forward  -> raceacar
        Backward -> racaecar

        Both are different, so return false.
    */

    // ------------------------------------------------------
    // Brute Force Approach
    // TC: O(n) SC: O(n)
    // ------------------------------------------------------
    public static boolean bruteForce(String s) {
        StringBuilder sb = new StringBuilder();
        for(Character ch : s.toCharArray()){
            if(Character.isDigit(ch) || Character.isLetter(ch)){
                sb.append(Character.toLowerCase(ch));
            }
        }

        String filtered = sb.toString();
        String reversed = sb.reverse().toString();

        return filtered.equals(reversed);
    }

    // ------------------------------------------------------
    // Optimized Two Pointer Approach
    // TC: O(n) SC: O(1)
    // ------------------------------------------------------
    public static boolean optimized(String s) {
        
        int left = 0, right = s.length()-1;
        while(left < right){
            while(left < right && !(Character.isLetter(s.charAt(left)) || Character.isDigit(s.charAt(left)))){
                left++;
            }
            while(left < right && !(Character.isLetter(s.charAt(right)) || Character.isDigit(s.charAt(right)))){
                right--;
            }
            if(Character.toLowerCase(s.charAt(left)) != Character.toLowerCase(s.charAt(right))){
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

    public static void main(String[] args) {

        String s1 = "A man, a plan, a canal: Panama";
        String s2 = "race a car";
        String s3 = " ";

        System.out.println("Brute Force:");
        System.out.println(bruteForce(s1));
        System.out.println(bruteForce(s2));
        System.out.println(bruteForce(s3));

        System.out.println();

        System.out.println("Optimized:");
        System.out.println(optimized(s1));
        System.out.println(optimized(s2));
        System.out.println(optimized(s3));
    }
}