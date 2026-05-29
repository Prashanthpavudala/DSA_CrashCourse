package Week_1.Hashing.Medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class GroupAnagrams {
    /*
        Input:
        [eat, tea, tan, ate, nat, bat]

        After Grouping:

        "aet" -> [eat, tea, ate]
        "ant" -> [tan, nat]
        "abt" -> [bat]
    */

    // TC: O(n*klogk), SC: O(n*k)
    public static List<List<String>> groupAnagramsBrute(String[] strs) {
        if(strs == null || strs.length == 0){
            return new ArrayList<>();
        }
        HashMap<String, List<String>> anagramMap = new HashMap<>();
        for(String s : strs){
            char[] arr = s.toCharArray();   
            Arrays.sort(arr);
            String key = String.valueOf(arr);
            if(!anagramMap.containsKey(key)){
                anagramMap.put(key, new ArrayList<>());
            }
            anagramMap.get(key).add(s);
        }
        // List<List<String>> result = new ArrayList<>();
        // for(Map.Entry<String, List<String>> entry : anagramMap.entrySet()){
        //     result.add(entry.getValue());
        // }
        return new ArrayList<>(anagramMap.values());
    }


    // TC: O(n*k), SC: O(n*k)
    public static List<List<String>> groupAnagramsOptimal(String[] strs) {
        if(strs == null || strs.length==0){
            return new ArrayList<>();
        }
        
        HashMap<String, List<String>> anagramMap = new HashMap<>();

        for(String s : strs){

            String frqString = getFreqString(s);

            if(!anagramMap.containsKey(frqString)){
                anagramMap.put(frqString, new ArrayList<>());
            }
            anagramMap.get(frqString).add(s);
        }
        // System.out.println(anagramMap);
        // {a1b1t1=[bat], a1n1t1=[tan, nat], a1e1t1=[eat, tea, ate]}
        return new ArrayList<>(anagramMap.values());
    }

    private static String getFreqString(String s){
        int[] freq = new int[26];

        for(char ch : s.toCharArray()){
            freq[ch - 'a']++;
        }

        StringBuilder freqString = new StringBuilder("");
        char c = 'a';
        for(int i : freq){
            if(i > 0){
                freqString.append(c);
                freqString.append(i);
            }
            c++;
        }

        return freqString.toString();
    }


    // ---------------- MAIN FUNCTION ----------------

    public static void main(String[] args) {

        String[] strs = {"eat", "tea", "tan", "ate", "nat", "bat"};
        // String[] strs = {""};

        // Calling Brute Force
        List<List<String>> bruteResult = groupAnagramsBrute(strs);

        System.out.println("Brute Force Result:");
        System.out.println(bruteResult);

        // Calling Optimized
        List<List<String>> optimalResult = groupAnagramsOptimal(strs);

        System.out.println("\nOptimized Result:");
        System.out.println(optimalResult);
    }
}
