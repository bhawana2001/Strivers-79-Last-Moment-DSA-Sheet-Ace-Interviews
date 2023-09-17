// Problem Statement: Given an array of integers arr, there is a sliding window of size k which is moving from the very left of the array to the very right. 
// You can only see the k numbers in the window. Each time the sliding window moves right by one position. Return the max sliding window.

//Problem Link: https://www.codingninjas.com/studio/problems/sliding-maximum-_701652?utm_source=striver&utm_medium=website&utm_campaign=a_zcoursetuf

import java.util.*;

public class slidingWindowMaximum {
    public static int[] maxSlidingWindow(int[] arr, int n, int k) {
        Stack<Integer> st = new Stack<>();
        int[] nge = new int[n];

        // Initialize the stack with the last element of the array
        st.push(n - 1);
        nge[n - 1] = n;

        // Calculate the Next Greater Element (nge) for each element in the array
        for (int i = n - 2; i >= 0; i--) {
            while (st.size() > 0 && arr[i] >= arr[st.peek()]) {
                st.pop();
            }
            if (st.size() == 0) {
                nge[i] = n;
            } else {
                nge[i] = st.peek();
            }
            st.push(i);
        }

        // Create a list to store the results
        List<Integer> res = new ArrayList<>();
        int j = 0;

        // Iterate through the array to find the maximum element in each sliding window
        for (int i = 0; i <= n - k; i++) {
            if (j < i) {
                j = i;
            }
            while (nge[j] < i + k) {
                j = nge[j];
            }
            res.add(arr[j]);
        }

        // Convert the list to an int[] array
        int[] ans = new int[res.size()];
        for (int i = 0; i < res.size(); i++) {
            ans[i] = res.get(i);
        }

        return ans;
    }

    public static void main(String[] args) {
        int[] arr = { 2, 4, 7, 1, 4, 2, 7, 1 };
        int[] ans = maxSlidingWindow(arr, arr.length, 3);
        for (int i : ans) {
            System.out.print(i + " ");
        }
    }
}
