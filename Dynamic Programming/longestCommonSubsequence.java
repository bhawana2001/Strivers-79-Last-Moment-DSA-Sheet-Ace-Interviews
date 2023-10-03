// //Problem Statement: Given two strings text1 and text2, return the length of their longest common subsequence. If there is no common subsequence, return 0.
// A subsequence of a string is a new string generated from the original string with some characters (can be none) deleted without changing the relative order of the remaining characters.
// For example, "ace" is a subsequence of "abcde".
// A common subsequence of two strings is a subsequence that is common to both strings.

//Problem Link: https://bit.ly/3raZbqM

public class longestCommonSubsequence {

    public static int lcs(String s, String t) {
        // Your code goes here
        int dp[][] = new int[s.length() + 1][t.length() + 1];

        for (int j = 0; j <= t.length(); j++) {
            dp[0][j] = 0;
        }
        for (int i = 0; i <= s.length(); i++) {
            dp[i][0] = 0;
        }
        for (int i = 1; i <= s.length(); i++) {
            for (int j = 1; j <= t.length(); j++) {
                if (s.charAt(i - 1) == t.charAt(j - 1)) {
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        return dp[s.length()][t.length()];
    }

}