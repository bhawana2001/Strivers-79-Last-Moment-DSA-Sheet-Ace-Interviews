// Problem Statement:Given an array of ‘N’  positive integers, we need to return the maximum sum of the subsequence such that no two elements of the subsequence are adjacent elements in the array.
// Note: A subsequence of an array is a list with elements of the array where some elements are deleted ( or not deleted at all) and the elements should be in the same order in the subsequence as in the array.

//Problem Link: https://www.codingninjas.com/studio/problems/maximum-sum-of-non-adjacent-elements_843261?utm_source=striver&utm_medium=website&utm_campaign=a_zcoursetuf

import java.util.*;

public class maximumSumOfNonAdjacentElements {
    public static int maximumNonAdjacentSum(ArrayList<Integer> nums) {
        // Write your code here.
        int exc = 0;
        int inc = nums.get(0);
        for (int i = 1; i < nums.size(); i++) {
            // new include will be addition of old exlude plus current element
            int ninc = exc + nums.get(i);
            // new exclude will be maximum of both inc and exc of previous
            int nexc = Math.max(exc, inc);
            exc = nexc;
            inc = ninc;
        }
        int res = Math.max(exc, inc);
        return res;
    }
}