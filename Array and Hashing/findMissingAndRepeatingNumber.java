// Problem Statement: You are given a read-only array of N integers with values also in the range [1, N] both inclusive. 
// Each integer appears exactly once except A which appears twice and B which is missing. 
// The task is to find the repeating and missing numbers A and B where A repeats twice and B is missing.

//Problem Link: https://www.codingninjas.com/codestudio/problems/missing-and-repeating-numbers_6828164?utm_source=striver&utm_medium=website&utm_campaign=a_zcoursetuf
import java.util.*;
public class findMissingAndRepeatingNumber {
    public static int[] findMissingRepeatingNumbers(int []arr) {
        // Write your code here
        long n = arr.length; // size of the array
        // Find Sn and S2n:
        long SN = (n * (n + 1)) / 2;
        long S2N = (n * (n + 1) * (2 * n + 1)) / 6;

        // Calculate S and S2:
        long S = 0, S2 = 0;
        for (int i = 0; i < n; i++) {
            S += arr[i];
            S2 += (long)arr[i] * (long)arr[i];
        }

        long val1 = S - SN;
        long val2 = S2 - S2N;
        val2 = val2 / val1;

        long a = (val1 + val2) / 2;
        long b = a - val1;

        int[] res = {(int)a, (int)b};
        return res;
    }
    public static void main(String[] args) {
        int[] a = {3, 1, 2, 5, 4, 6, 7, 5};
        int[] ans = findMissingRepeatingNumbers(a);
        System.out.println("The repeating and missing numbers are: {"
                           + ans[0] + ", " + ans[1] + "}");
    }
}