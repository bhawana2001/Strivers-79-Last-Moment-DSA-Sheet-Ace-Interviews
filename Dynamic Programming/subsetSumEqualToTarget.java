//Problem Statement: We are given an array ‘ARR’ with N positive integers. We need to find if there is a subset in “ARR” with a sum equal to K. If there is, return true else return false.

//Problem Link: https://www.codingninjas.com/studio/problems/subset-sum-equal-to-k_1550954?utm_source=striver&utm_medium=website&utm_campaign=a_zcoursetuf

public class subsetSumEqualToTarget {
    public static boolean subsetSumToK(int n, int k, int arr[]) {
        // Write your code here.
        boolean[][] dp = new boolean[n + 1][k + 1];
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[0].length; j++) {
                // first entry always be true
                if (i == 0 && j == 0) {
                    dp[i][j] = true;
                }
                // first row should be false
                else if (i == 0) {
                    dp[i][j] = false;
                }
                // first column shoud be true because every entry have an option to not be a
                // part of subset
                else if (j == 0) {
                    dp[i][j] = true;
                } else {
                    // if current value make subset
                    if (dp[i - 1][j] == true) {
                        dp[i][j] = true;
                    } else {
                        int val = arr[i - 1];
                        // if current value is greater then arrays element
                        if (j >= val) {
                            // we will check for the value of element which will be val-current element
                            if (dp[i - 1][j - val] == true) {
                                dp[i][j] = true;
                            }
                        }
                    }
                }
            }
        }
        return dp[n][k];
    }
}
