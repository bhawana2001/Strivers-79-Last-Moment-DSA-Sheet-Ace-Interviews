//Problem Statement: Given a weighted, undirected, and connected graph of V vertices and an adjacency list adj where adj[i] is a list of lists containing two integers where the first integer of each list j denotes there is an edge between i and j, second integers corresponds to the weight of that edge. You are given the source vertex S and You have to Find the shortest distance of all the vertex from the source vertex S. You have to return a list of integers denoting the shortest distance between each node and Source vertex S.
// Note: The Graph doesn’t contain any negative weight cycle

//Problem Link: https://www.codingninjas.com/studio/problems/dijkstra's-shortest-path_985358?utm_source=striver&utm_medium=website&utm_campaign=a_zcoursetuf&leftPanelTab=0

import java.util.*;

public class djisktrasAlgorithm {
    static class Pair {
        int dest;
        int wt;

        Pair(int dest, int wt) {
            this.dest = dest;
            this.wt = wt;
        }
    }

    public static List<Integer> dijkstra(int[][] edge, int v, int edges, int source) {

        ArrayList<ArrayList<Pair>> adj = new ArrayList<>();

        for (int i = 0; i < v; i++) {
            adj.add(new ArrayList<>());
        }

        for (int i = 0; i < edges; i++) {
            adj.get(edge[i][0]).add(new Pair(edge[i][1], edge[i][2]));
            adj.get(edge[i][1]).add(new Pair(edge[i][0], edge[i][2]));
        }

        PriorityQueue<Pair> pq = new PriorityQueue<>((x, y) -> x.wt - y.wt);
        int[] dist = new int[v];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[source] = 0;
        pq.add(new Pair(source, 0));
        while (!pq.isEmpty()) {
            Pair it = pq.poll();
            int node = it.dest;
            int dis = it.wt;
            if (dis > dist[node]) {
                continue;
            }
            for (Pair iter : adj.get(node)) {
                int adjNode = iter.dest;
                int wt = iter.wt;
                if (dis + wt < dist[adjNode]) {
                    dist[adjNode] = dis + wt;
                    pq.add(new Pair(adjNode, dist[adjNode]));
                }
            }
        }

        List<Integer> shortestDistances = new ArrayList<>();
        for (int d : dist) {
            if (d == Integer.MAX_VALUE) {
                shortestDistances.add(-1);
            } else {
                shortestDistances.add(d);
            }
        }
        return shortestDistances;
    }
}