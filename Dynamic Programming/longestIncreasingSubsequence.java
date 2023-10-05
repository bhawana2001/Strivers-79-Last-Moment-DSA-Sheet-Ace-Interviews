//Problem Statement: Given an integer array nums, return the length of the longest strictly increasing subsequence.

//Problem Link: https://bit.ly/3GuWGpA

import java.util.*;

public class longestIncreasingSubsequence {

    public static int longestIncreasingSubsequence1(int arr[]) {
        // Your code goes here
        int n = arr.length;
        int dp[][] = new int[n][n + 1];
        for (int row[] : dp) {
            Arrays.fill(row, -1);
        }
        return helper(arr, n, 0, -1, dp);
    }

    public static int helper(int arr[], int n, int ind, int prev, int[][] dp) {
        if (ind == n) {
            return 0;
        }
        if (dp[ind][prev + 1] != -1) {
            return dp[ind][prev + 1];
        }
        int notTake = 0 + helper(arr, n, ind + 1, prev, dp);
        int take = 0;
        if (prev == -1 || arr[ind] > arr[prev]) {
            take = 1 + helper(arr, n, ind + 1, ind, dp);
        }
        dp[ind][prev + 1] = Math.max(notTake, take);
        return dp[ind][prev + 1];
    }

}
