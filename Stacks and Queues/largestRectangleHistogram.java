// Problem Statement: Given an array of integers heights representing the histogram’s bar height where the width of each bar is 1  return the area of the largest rectangle in histogram.

//Problem Link: https://www.codingninjas.com/studio/problems/largest-rectangle-in-a-histogram_1058184?utm_source=striver&utm_medium=website&utm_campaign=a_zcoursetuf

import java.util.ArrayList;
import java.util.Stack;

public class largestRectangleHistogram {
    public static int largestRectangle(ArrayList<Integer> heights) {
        int n = heights.size(); // Get the size of the ArrayList
        Stack<Integer> st = new Stack<>(); // Create a stack for storing indices
        int[] lb = new int[n]; // Initialize an array for left boundaries
        int[] rb = new int[n]; // Initialize an array for right boundaries

        // Calculate left boundaries
        for (int i = 0; i < n; i++) {
            while (!st.isEmpty() && heights.get(st.peek()) >= heights.get(i)) {
                st.pop(); // Pop elements until a smaller element is not found
            }

            if (st.isEmpty()) {
                lb[i] = 0; // No smaller element found on the left
            } else {
                lb[i] = st.peek() + 1; // The peeked element is the left boundary
            }
            st.push(i); // Push the current index onto the stack
        }

        st.clear(); // Clear the stack for re-use

        // Calculate right boundaries
        for (int i = n - 1; i >= 0; i--) {
            while (!st.isEmpty() && heights.get(st.peek()) >= heights.get(i)) {
                st.pop(); // Pop elements until a smaller element is not found
            }

            if (st.isEmpty()) {
                rb[i] = n - 1; // No smaller element found on the right
            } else {
                rb[i] = st.peek() - 1; // The peeked element is the right boundary
            }

            st.push(i); // Push the current index onto the stack
        }

        int maxArea = 0;
        for (int i = 0; i < n; i++) {
            int width = (rb[i] - lb[i] + 1); // Calculate the width
            maxArea = Math.max(maxArea, heights.get(i) * width); // Calculate and update the maximum area
        }
        return maxArea; // Return the maximum area
    }
}
