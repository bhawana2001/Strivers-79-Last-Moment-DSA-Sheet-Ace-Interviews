// Problem Statement: Given an array of non-negative integers representation elevation of ground. Your task is to find the water that can be trapped after rain.

//Problem Link: https://leetcode.com/problems/trapping-rain-water/

import java.util.Stack;

class trapRainWater {
    public static int trap(int[] arr) {
        // USING STACK
        int n = arr.length;
        int watertrap = 0; // Initialize the variable to store the trapped water.
        Stack<Integer> stack = new Stack<>(); // Create a stack to store indices of bars.

        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && arr[i] > arr[stack.peek()]) {
                int top = stack.pop(); // Pop the index of the bar at the top of the stack.
                if (stack.isEmpty()) {
                    break; // If there's no left boundary, exit the loop.
                }
                int distance = i - stack.peek() - 1; // Calculate the width of the container.
                int boundedHeight = Math.min(arr[i], arr[stack.peek()]) - arr[top];
                watertrap += distance * boundedHeight; // Calculate and add trapped water.
            }
            stack.push(i); // Push the current index onto the stack.
        }
        return watertrap; // Return the total trapped water.
    }

    public static void main(String args[]) {
        int arr[] = { 0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1 };
        System.out.println("The maximum water trapped " + trap(arr));
    }
}
