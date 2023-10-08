//Problem Statement: You are given a string text and a pattern pattern. Your task is to find all occurrences of the pattern in the given text using the Z-Algorithm.

//Problem Link: https://www.codingninjas.com/codestudio/problems/pattern-searching-using-z-algorithm_8395752?utm_source=striver&utm_medium=website&utm_campaign=a_zcoursetuf

import java.util.*;

public class patternSearchingUsingZAlgorithm {
    public static List<Integer> search(String s, String pattern) {
        List<Integer> v = new ArrayList<>();
        int n = s.length();
        int m = pattern.length();

        for (int i = 0; i <= n - m; i++) {
            int j = 0;
            for (; j < m; j++) {
                if (s.charAt(i + j) != pattern.charAt(j)) {
                    break;
                }
            }
            if (j == m) {
                v.add(i + 1);
            }
        }
        return v;
    }
}