// Problem Statement: We are given two strings ‘S1’ and ‘S2’. We need to convert S1 to S2. The following three operations are allowed:
// Deletion of a character.Replacement of a character with another one.Insertion of a character.
// We have to return the minimum number of operations required to convert S1 to S2 as our answer.

//Problem Link: https://www.codingninjas.com/studio/problems/shortest-common-supersequence_4244493?utm_source=striver&utm_medium=website&utm_campaign=a_zcoursetuf

public class shortestCommonSupersequence {
    public static String shortestSupersequence(String a, String b) {
        // Write your code here..
        int m = a.length();
        int n = b.length();
        int[][] dp = new int[m + 1][n + 1];
        for (int i = 0; i <= m; i++) {
            for (int j = 0; j <= n; j++) {
                if (i == 0 || j == 0)
                    dp[i][j] = 0;
                else if (a.charAt(i - 1) == b.charAt(j - 1)) {
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        String ans = "";
        int i = m, j = n;
        while (i > 0 && j > 0) {
            if (a.charAt(i - 1) == b.charAt(j - 1)) {
                ans += a.charAt(i - 1);
                i--;
                j--;
            } else if (dp[i - 1][j] > dp[i][j - 1]) {
                ans += a.charAt(i - 1);
                i--;
            } else {
                ans += b.charAt(j - 1);
                j--;
            }
        }
        while (i > 0) {
            ans += a.charAt(i - 1);
            i--;
        }
        while (j > 0) {
            ans += b.charAt(j - 1);
            j--;
        }
        StringBuilder sb = new StringBuilder(ans);
        sb.reverse();
        return sb.toString();
    }

}