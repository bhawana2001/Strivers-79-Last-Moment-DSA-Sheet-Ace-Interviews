//Problem Statement: There are n cities and m edges connected by some number of flights. You are given an array of flights where flights[i] = [ fromi, toi, pricei] indicates that there is a flight from city fromi to city toi with cost price. You have also given three integers src, dst, and k, and return the cheapest price from src to dst with at most k stops. If there is no such route, return -1.

//Problem Link: https://www.codingninjas.com/studio/problems/saving-money_1171195?utm_source=striver&utm_medium=website&utm_campaign=a_zcoursetuf

import java.util.*;

public class cheapestFlightsWithinKStops {
    static class Pair {
        int first, second;

        public Pair(int first, int second) {
            this.first = first;
            this.second = second;
        }
    }

    public static int savingMoney(int n, int source, int destination, int k, List<List<Integer>> trains) {
        // Write your code here.
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }

        for (List<Integer> train : trains) {
            int u = train.get(0);
            int v = train.get(1);
            int cost = train.get(2);
            adj.get(u).add(v);
            adj.get(u).add(cost);
        }

        int[] money = new int[n];
        Arrays.fill(money, Integer.MAX_VALUE);

        PriorityQueue<Pair> pq = new PriorityQueue<>((a, b) -> a.first - b.first);
        pq.add(new Pair(0, source));
        money[source] = 0;

        while (!pq.isEmpty() && k >= 0) {
            int size = pq.size();
            for (int i = 0; i < size; i++) {
                Pair top = pq.poll();
                int price = top.first;
                int station = top.second;

                for (int j = 0; j < adj.get(station).size(); j += 2) {
                    int newStation = adj.get(station).get(j);
                    int newPrice = adj.get(station).get(j + 1);

                    if (price + newPrice < money[newStation]) {
                        money[newStation] = price + newPrice;
                        pq.add(new Pair(price + newPrice, newStation));
                    }
                }
            }
            k--;
        }

        if (money[destination] == Integer.MAX_VALUE)
            return -1;
        return money[destination];
    }
}