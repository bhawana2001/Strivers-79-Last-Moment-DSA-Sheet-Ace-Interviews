//Problem Statement: A thief wants to rob a store. He is carrying a bag of capacity W. The store has ‘n’ items. Its weight is given by the ‘wt’ array and its value by the ‘val’ array. He can either include an item in its knapsack or exclude it but can’t partially have it as a fraction. We need to find the maximum value of items that the thief can steal.

//Problem Link: https://www.codingninjas.com/studio/problems/0-1-knapsack_920542?utm_source=striver&utm_medium=website&utm_campaign=a_zcoursetuf

public class zeroOneKnapsack {
    static int knapsack(int[] weight, int[] value, int n, int maxWeight) {

        int[][] dp = new int[n + 1][maxWeight + 1];
        for (int i = 1; i < dp.length; i++) {
            for (int j = 1; j < dp[0].length; j++) {
                // if current weight value is greater then given weight
                if (j >= weight[i - 1]) {
                    int rCap = j - weight[i - 1];
                    if (dp[i - 1][rCap] + value[i - 1] > dp[i - 1][j]) {
                        dp[i][j] = dp[i - 1][rCap] + value[i - 1];
                    } else {
                        dp[i][j] = dp[i - 1][j];
                    }
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        return dp[n][maxWeight];
    }
}