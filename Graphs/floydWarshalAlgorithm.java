// Problem Statement: The problem is to find the shortest distances between every pair of vertices in a given edge-weighted directed graph. The graph is represented as an adjacency matrix of size n*n. Matrix[i][j] denotes the weight of the edge from i to j. If Matrix[i][j]=-1, it means there is no edge from i to j.

//Problem Link: https://www.codingninjas.com/studio/problems/floyd-warshall_2041979?utm_source=striver&utm_medium=website&utm_campaign=a_zcoursetuf

import java.util.ArrayList;

public class floydWarshalAlgorithm {
    static int floydWarshall(int n, int m, int src, int dest, ArrayList<ArrayList<Integer>> edges) {
        // Write your code here.
        int[][] dist = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                dist[i][j] = Integer.MAX_VALUE;
            }
            dist[i][i] = 0;
        }

        // as it has One-based nodes
        for (ArrayList<Integer> it : edges) {
            int u = it.get(0) - 1;
            int v = it.get(1) - 1;
            int wt = it.get(2);
            dist[u][v] = wt;
        }

        for (int k = 0; k < n; k++) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (dist[i][k] != Integer.MAX_VALUE && dist[k][j] != Integer.MAX_VALUE) {
                        dist[i][j] = Math.min(dist[i][j], dist[i][k] + dist[k][j]);
                    }
                }
            }
        }
        return dist[src - 1][dest - 1] == Integer.MAX_VALUE ? 1000000000 : dist[src - 1][dest - 1];
    }

}
