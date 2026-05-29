package Week_2.SlidingWindow.Easy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FindAllAnagramsInString {
    /*
        Example:

        Input:
        s = "cbaebabacd"
        p = "abc"

        Output:
        [0, 6]

        Explanation:

        Index 0:
        substring = "cba"
        "cba" is an anagram of "abc"

        Index 6:
        substring = "bac"
        "bac" is an anagram of "abc"

        So the answer is:
        [0, 6]
    */

    //TC - O(n * k log k)
    public static List<Integer> bruteForce(String s, String p) {
        List<Integer> result = new ArrayList<>();
        int n=s.length();
        int k=p.length();
        char[] pDup = p.toCharArray();
        Arrays.sort(pDup);
        for(int i=0; i<n-k+1; i++){
            char[] temp = s.substring(i, i+k).toCharArray();
            Arrays.sort(temp);
            if(Arrays.equals(pDup, temp)){
                result.add(i);
            }
        }
        return result;
    }


    public static List<Integer> optimized(String s, String p) {
        List<Integer> result = new ArrayList<>();
        int left = 0;

        int[] pf = new int[26];
        int[] wf = new int[26];

        for(char c : p.toCharArray()){
            pf[c-'a']++;
        }

        for(int right=0; right<s.length(); right++){
             wf[s.charAt(right)-'a']++;
             if(right-left+1 > p.length()){
                wf[s.charAt(left)-'a']--;
                left++;
             }
             if(Arrays.equals(wf, pf)){
                result.add(left);
             }
        }
        return result;
    }

    public static void main(String[] args) {

        String s = "cbaebabacb";
        String p = "abc";

        System.out.println("Input String  : " + s);
        System.out.println("Pattern String: " + p);

        System.out.println();

        System.out.println("Brute Force Output:");
        System.out.println(bruteForce(s, p));

        System.out.println();

        System.out.println("Optimized Output:");
        System.out.println(optimized(s, p));
    }
}
