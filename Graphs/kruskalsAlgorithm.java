// Problem Statement: Given a weighted, undirected, and connected graph of V vertices and E edges. The task is to find the sum of weights of the edges of the Minimum Spanning Tree.

//Problem Link: https://www.codingninjas.com/studio/problems/kruskal%E2%80%99s-minimum-spanning-tree-algorithm_1082553?utm_source=striver&utm_medium=website&utm_campaign=a_zcoursetuf

import java.util.*;

public class kruskalsAlgorithm {
    public static int kruskalMST(int n, int[][] edges) {
        // Write your code here
        List<List<Integer>> adj = new ArrayList<>();

        for (int[] arr : edges) {
            int u = arr[0], v = arr[1], wt = arr[2];
            List<Integer> l = new ArrayList<>();
            l.add(wt);
            l.add(u);
            l.add(v);
            adj.add(l);
        }

        Comparator<List<Integer>> comparator = (l1, l2) -> l1.get(0).compareTo(l2.get(0));
        Collections.sort(adj, comparator);

        Disjoint d = new Disjoint(n);
        int sum = 0;

        for (List<Integer> m : adj) {
            int wt = m.get(0), u = m.get(1), v = m.get(2);
            if (d.findParent(u) != d.findParent(v)) {
                sum += wt;
                d.unionByRank(u, v);
            }
        }

        return sum;
    }
}

final class Disjoint {
    public int rank[], parent[];

    public Disjoint(int n) {
        rank = new int[n + 1];
        parent = new int[n + 1];
        for (int i = 1; i <= n; i++)
            parent[i] = i;
    }

    public int findParent(int node) {
        if (node == parent[node])
            return node;
        return parent[node] = findParent(parent[node]);
    }

    public void unionByRank(int u, int v) {
        int pu = findParent(u);
        int pv = findParent(v);

        if (rank[pu] < rank[pv]) {
            parent[pu] = pv;
        } else if (rank[pu] > rank[pv]) {
            parent[pv] = pu;
        } else {
            parent[pv] = pu;
            rank[pu]++;
        }
    }
}
