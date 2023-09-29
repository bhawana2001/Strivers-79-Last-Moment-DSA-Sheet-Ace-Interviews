// Problem Statement: There are n servers numbered from 0 to n – 1 connected by undirected server-to-server connections forming a network where connections[i] = [ai, bi] represents a connection between servers ai and bi. Any server can reach other servers directly or indirectly through the network.
// A critical connection is a connection that, if removed, will make some servers unable to reach some other servers.
// Return all critical connections in the network in any order.

//Problem Link: https://www.codingninjas.com/studio/problems/bridges-in-a-graph_893026?utm_source=striver&utm_medium=website&utm_campaign=a_zcoursetuf

import java.util.*;

public class bridgesInGraph {

    public static List<List<Integer>> findBridges(int[][] edges, int v, int e) {
        // Create adjacency list
        Map<Integer, List<Integer>> adj = new HashMap<>();
        for (int[] edge : edges) {
            int u = edge[0];
            int w = edge[1];
            adj.computeIfAbsent(u, k -> new ArrayList<>()).add(w);
            adj.computeIfAbsent(w, k -> new ArrayList<>()).add(u);
        }

        // Create data structures
        int[] timer = { 0 };
        int[] disc = new int[v];
        int[] low = new int[v];
        Arrays.fill(disc, -1);
        Arrays.fill(low, -1);
        boolean[] vis = new boolean[v];

        List<List<Integer>> ans = new ArrayList<>();

        // DFS
        for (int i = 0; i < v; i++) {
            if (!vis[i]) {
                dfs(i, -1, timer, disc, low, ans, adj, vis);
            }
        }

        return ans;

    }

    private static void dfs(int node, int parent, int[] timer, int[] disc, int[] low,
            List<List<Integer>> ans, Map<Integer, List<Integer>> adj,
            boolean[] vis) {
        vis[node] = true;
        disc[node] = low[node] = timer[0]++;

        for (int neighbor : adj.getOrDefault(node, new ArrayList<>())) {
            if (neighbor == parent) {
                continue;
            }

            if (!vis[neighbor]) {
                dfs(neighbor, node, timer, disc, low, ans, adj, vis);
                low[node] = Math.min(low[node], low[neighbor]);

                // Check for bridge edge
                if (low[neighbor] > disc[node]) {
                    List<Integer> res = new ArrayList<>();
                    res.add(node);
                    res.add(neighbor);
                    ans.add(res);
                }

            } else {
                // Back edge
                low[node] = Math.min(low[node], disc[neighbor]);
            }
        }
    }

}
