// Problem Statement: You are given n balloons, indexed from 0 to n – 1. Each balloon is painted with a number on it represented by an array. You are asked to burst all the balloons.
// If you burst the ith balloon, you will get arr[i – 1] * arr[i] * arr[i + 1] coins. If i – 1 or i + 1 goes out of the array’s bounds, then treat it as if there is a balloon with a 1 painted on it.
// Return the maximum coins you can collect by bursting the balloons wisely.

//Problem Link: https://www.codingninjas.com/codestudio/problems/burst-balloons_628471?utm_source=striver&utm_medium=website&utm_campaign=a_zcoursetuf

public class burstBalloons {
    public static int burstBalloons1(int[] arr) {
        // Write your code here.
        int n = arr.length;
        int[] balloons = new int[n + 2];
        balloons[0] = 1;
        balloons[n + 1] = 1;
        System.arraycopy(arr, 0, balloons, 1, n);

        int[][] dp = new int[n + 2][n + 2];

        for (int len = 1; len <= n; len++) {
            for (int i = 1; i <= n - len + 1; i++) {
                int j = i + len - 1;
                for (int k = i; k <= j; k++) {
                    int cost = balloons[i - 1] * balloons[k] * balloons[j + 1] + dp[i][k - 1] + dp[k + 1][j];
                    dp[i][j] = Math.max(dp[i][j], cost);
                }
            }
        }
        return dp[1][n];
    }
}