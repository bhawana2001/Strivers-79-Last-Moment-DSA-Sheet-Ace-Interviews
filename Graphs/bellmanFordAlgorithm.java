//Problem Statement: Given a weighted, directed and connected graph of V vertices and E edges, Find the shortest distance of all the vertices from the source vertex S.
// Note: If the Graph contains a negative cycle then return an array consisting of only -1.

//Problem Link: https://www.codingninjas.com/studio/problems/bellman-ford_2041977?utm_source=striver&utm_medium=website&utm_campaign=a_zcoursetuf

import java.util.List;

public class bellmanFordAlgorithm {
    public static int[] bellmonFord(int n, int m, int src, List<List<Integer>> edges) {
        // Write your code here.
        int dist[] = new int[n + 1];
        for (int i = 1; i <= n; i++)
            dist[i] = (int) (1e8);
        dist[src] = 0;
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < m; j++) {
                int u = edges.get(j).get(0);
                int v = edges.get(j).get(1);
                int d = edges.get(j).get(2);
                if ((dist[u] + d) < dist[v]) {
                    dist[v] = dist[u] + d;
                }
            }
        }

        return dist;
    }
}
