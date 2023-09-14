// Problem Statement: Given an undirected graph and a number m, determine if the graph can be colored with at most m colors such that no two adjacent vertices of the graph are colored with the same color.

//Problem Link: https://www.codingninjas.com/studio/problems/m-coloring-problem_981273?utm_source=striver&utm_medium=website&utm_campaign=a_zcoursetuf

import java.util.ArrayList;
import java.util.List;

public class mColoring {

    // Function to check if it's safe to color a node with a given color
    public static boolean isSafe(int node, int[] color, List<List<Integer>> adjList, int col) {
        for (int it : adjList.get(node)) {
            if (color[it] == col)
                return false;
        }
        return true;
    }

    // Function to check graph coloring recursively
    public static boolean checkGraphColoring(List<List<Integer>> adjList, int[] color, int node, int m) {
        if (node == adjList.size())
            return true;

        // Try different colors for the current node
        for (int col = 1; col <= m; col++) {
            if (isSafe(node, color, adjList, col)) {
                color[node] = col;

                // Recursively check the next node
                if (checkGraphColoring(adjList, color, node + 1, m))
                    return true;

                color[node] = 0; // Backtrack if no valid coloring is found
            }
        }

        return false;
    }

    public static String graphColoring(int[][] mat, int m) {
        // Creating the adjacency list from the adjacency matrix
        int n = mat.length;
        List<List<Integer>> adjList = new ArrayList<>();

        // Initialize the adjacency list
        for (int i = 0; i < n; i++) {
            adjList.add(new ArrayList<>());
        }

        // Populate the adjacency list based on the adjacency matrix
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[i].length; j++) {
                if (mat[i][j] != 0)
                    adjList.get(i).add(j);
            }
        }

        int[] color = new int[n];

        // Check if graph coloring is possible
        if (checkGraphColoring(adjList, color, 0, m))
            return "YES";
        return "NO";
    }

}