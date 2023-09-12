// Problem Statement: Given an array of distinct integers and a target, you have to return the list of all unique combinations where the chosen numbers sum to target. You may return the combinations in any order.
// The same number may be chosen from the given array an unlimited number of times. Two combinations are unique if the frequency of at least one of the chosen numbers is different.

//Problem Link: https://www.codingninjas.com/studio/problems/combination-sum_981296?utm_source=striver&utm_medium=website&utm_campaign=a_zcoursetuf

import java.util.*;

public class combinationSum {
    public static List<List<Integer>> combSum(int[] ARR, int B) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(ARR); // Sort the array to generate combinations efficiently
        combinations(0, ARR, B, res, new ArrayList<>());
        return res;
    }

    public static void combinations(int ind, int[] arr, int target,
            List<List<Integer>> res, List<Integer> bs) {
        if (target == 0) {
            res.add(new ArrayList<>(bs));
            return;
        }
        if (ind == arr.length || arr[ind] > target) {
            return;
        }

        // Include the current element in the combination
        bs.add(arr[ind]);
        combinations(ind, arr, target - arr[ind], res, bs);
        bs.remove(bs.size() - 1);

        // Skip the current element and move to the next one
        combinations(ind + 1, arr, target, res, bs);
    }
}
