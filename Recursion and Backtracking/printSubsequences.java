// Problem Statement: Given a string, find all the possible subsequences of the string.

//Problem Link: https://www.codingninjas.com/studio/problems/print-subsequences_8416366?utm_source=striver&utm_medium=website&utm_campaign=a_zcoursetuf

import java.util.ArrayList;
import java.util.List;

public class printSubsequences {
    public static List<String> generateSubsequences(String s) {
        // if length of string is 0, we return list with empty string
        if (s.length() == 0) {
            List<String> bs = new ArrayList<>();
            bs.add("");
            return bs;
        }
        // take out first char from string
        char ch = s.charAt(0);
        // substring of s
        String ss = s.substring(1);
        // generate all the subsequances for substrings
        List<String> sa = generateSubsequences(ss);
        List<String> res = new ArrayList<>();
        for (String str : sa) {
            res.add("" + str);
            res.add(ch + str);
        }
        return res;
    }

    public static void main(String args[]) {
        String s = "abc";
        List<String> ans = generateSubsequences(s);
        // printint all the subsequence.
        System.out.println("All possible subsequences are ");
        for (String it : ans) {
            System.out.print(it + " ");
        }

    }
}