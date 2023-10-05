//Problem Statement: Given an integer array nums, return the length of the longest strictly increasing subsequence.

//Problem Link: https://bit.ly/3GuWGpA

import java.util.*;

public class longestIncreasingSubsequence {

    public static int longestIncreasingSubsequence1(int arr[]) {
        List<Integer> lis = new ArrayList<>();
        lis.add(arr[0]);
        int n = arr.length;
        for (int i = 1; i < n; i++) {
            if (arr[i] > lis.get(lis.size() - 1)) {
                lis.add(arr[i]);
            } else {
                int index = binarySearch(lis, arr[i]);
                lis.set(index, arr[i]);
            }
        }
        return lis.size();
    }

    private static int binarySearch(List<Integer> lis, int target) {
        int left = 0, right = lis.size() - 1;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (lis.get(mid) < target) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return left;
    }

}
