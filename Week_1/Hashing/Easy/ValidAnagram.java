package Week_1.Hashing.Easy;

import java.util.Arrays;
import java.util.HashMap;

public class ValidAnagram {

    /*
    * Example Input:
    *
    * s = "listen"
    * t = "silent"
    *
    * Explanation:
    *
    * Both strings contain:
    *
    * l -> 1
    * i -> 1
    * s -> 1
    * t -> 1
    * e -> 1
    * n -> 1
    *
    * Same characters
    * Same frequency
    *
    * Therefore,
    * both are valid anagrams.
    */
    
    // TC: O(nlogn)
    // SC: O(n)
    public static boolean brute(String s, String t) {
        if(s.length() != t.length()){
            return false;
        }

        char[] sDup = s.toCharArray();
        Arrays.sort(sDup);

        char[] tDup = t.toCharArray();
        Arrays.sort(tDup);

        return Arrays.equals(sDup, tDup);
    }


    // TC: O(n)
    // SC: O(n)
    public static boolean optimized(String s, String t) {
        if(s.length() != t.length()){
            return false;
        }
        HashMap<Character, Integer> map = new HashMap<>();
        for(char ch : s.toCharArray()){
            map.put(ch, map.getOrDefault(ch, 0)+1);
        }

        for(char ch : t.toCharArray()){
            if(map.containsKey(ch)){
                map.put(ch, map.get(ch)-1);
                if(map.get(ch)==0){
                    map.remove(ch);
                }
            }else{
                return false;
            }
        }
        return map.isEmpty();
    }


    public static void main(String[] args) {

        String s = "listen";
        String t = "silent";


        // Calling Brute Force Method
        boolean bruteResult = brute(s, t);

        System.out.println("Brute Force Result:");
        System.out.println(bruteResult);


        // Calling Optimized Method
        boolean optimizedResult = optimized(s, t);

        System.out.println("\nOptimized Result:");
        System.out.println(optimizedResult);
    }
}
