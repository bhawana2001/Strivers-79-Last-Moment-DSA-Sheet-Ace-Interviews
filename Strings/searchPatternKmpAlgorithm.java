//Problem Statement: You are given a string text and a pattern pattern. Your task is to find the starting index of the first occurrence of the pattern in the given text using the Knuth-Morris-Pratt (KMP) algorithm.

//Problem Link: https://www.codingninjas.com/codestudio/problems/search-pattern-kmp-algorithm_8416386?utm_source=striver&utm_medium=website&utm_campaign=a_zcoursetuf

import java.util.*;

public class searchPatternKmpAlgorithm {
    public static List<Integer> stringMatch(String text, String pattern) {
        int n = text.length();
        int m = pattern.length();
        List<Integer> ans = new ArrayList<>();
        int[] LPS = new int[m];
        int len = 0;

        for (int i = 1; i < m; i++) {
            if (pattern.charAt(i) == pattern.charAt(len)) {
                len++;
                LPS[i] = len;
            } else {
                if (len != 0) {
                    len = LPS[len - 1];
                }
            }
        }

        int i = 0, j = 0;
        while (i < n) {
            if (text.charAt(i) == pattern.charAt(j)) {
                i++;
                j++;
                if (j == m) {
                    ans.add(i - j + 1);
                    j = LPS[j - 1];
                }
            } else {
                if (j > 0) {
                    j = LPS[j - 1];
                } else {
                    i++;
                }
            }
        }
        return ans;
    }
}