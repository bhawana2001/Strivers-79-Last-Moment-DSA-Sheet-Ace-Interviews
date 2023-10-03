// Problem Statement: A palindromic string is a string that is equal to its reverse. For example: “Nitin” is a palindromic string. Now the question states to find the length of the longest palindromic subsequence of a string. It is that palindromic subsequence of the given string with the greatest length. We need to print the length of the longest palindromic subsequence.

//Problem Link: https://www.codingninjas.com/studio/problems/longest-palindromic-subsequence_842787?utm_source=striver&utm_medium=website&utm_campaign=a_zcoursetuf

public class longestPalindromicSubsequence {
    public static int longestPalindromeSubsequence(String s) {
        // Write your code here.
        String ans = "";
        for (int i = s.length() - 1; i >= 0; i--) {
            ans += s.charAt(i);
        }

        int[][] dp = new int[s.length()][s.length()];
        for (int i = 0; i < s.length(); i++) {
            for (int j = 0; j < s.length(); j++) {
                dp[i][j] = -1;
            }
        }
        return helper(s, ans, 0, 0, dp);
    }

    public static int helper(String s1, String s2, int i, int j, int[][] dp) {
        if (i == s1.length() || j == s2.length()) {
            return 0;
        }

        if (dp[i][j] != -1) {
            return dp[i][j];
        }
        int ans = 0;
        if (s1.charAt(i) == s2.charAt(j)) {
            return 1 + helper(s1, s2, i + 1, j + 1, dp);
        } else {
            ans = Math.max(helper(s1, s2, i + 1, j, dp), helper(s1, s2, i, j + 1, dp));
        }
        dp[i][j] = ans;
        return ans;
    }
}