//Problem Statement: You are given a text string and a pattern string. Your task is to find all occurrences of the pattern in the given text using the Rabin-Karp string matching algorithm.

//Problem Link: https://www.codingninjas.com/codestudio/problems/stringmatch-rabincarp_1115738?utm_source=striver&utm_medium=website&utm_campaign=a_zcoursetuf

import java.util.*;

public class rabinKarp {
    public static List<Integer> stringMatch(String text, String pattern) {
        // Write your code here.
        List<Integer> ans = new ArrayList<>();

        for (int i = 0; i <= text.length() - pattern.length(); i++) {
            if (text.substring(i, i + pattern.length()).equals(pattern)) {
                ans.add(i + 1);
            }
        }
        return ans;
    }
}