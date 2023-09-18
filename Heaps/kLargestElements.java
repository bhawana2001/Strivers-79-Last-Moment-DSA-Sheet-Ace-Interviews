// Problem Statement: Given an unsorted array, print Kth Largest and Smallest Element from an unsorted array.

// Problem Link: https://www.codingninjas.com/codestudio/problems/k-largest-elements_796005?utm_source=striver&utm_medium=website&utm_campaign=a_zcoursetuf

import java.util.*;

public class kLargestElements {

    public static ArrayList<Integer> kLargest(int n, int[] input, int k) {
        // Create a min-heap
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();

        // Add the first k elements to the min-heap
        for (int i = 0; i < k; i++) {
            minHeap.add(input[i]);
        }

        // Continue adding elements to the min-heap and removing the smallest
        for (int i = k; i < input.length; i++) {
            if (input[i] > minHeap.peek()) {
                minHeap.remove(); // Remove the smallest element
                minHeap.add(input[i]); // Add the current element
            }
        }

        // Convert the min-heap to a list
        ArrayList<Integer> result = new ArrayList<>();
        while (!minHeap.isEmpty()) {
            result.add(minHeap.remove());
        }

        return result;

    }

    public static void main(String[] args) {
        int n = 8;
        int[] arr = { 2, 5, 1, 8, 3, 9, 12, 20 };
        ArrayList<Integer> res = kLargest(n, arr, 4);
        for (int i : res) {
            System.out.print(i + " ");
        }
    }

}