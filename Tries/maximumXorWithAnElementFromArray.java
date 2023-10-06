// Problem Statement:You are given an array/list ‘ARR’ consisting of ‘N’ non-negative integers. You are also given a list ‘QUERIES’ consisting of ‘M’ queries, where the ‘i-th’ query is a list/array of two non-negative integers ‘Xi’, ‘Ai’, i.e ‘QUERIES[i]’ = [‘Xi’, ‘Ai’].
// The answer to the ith query, i.e ‘QUERIES[i]’ is the maximum bitwise xor value of ‘Xi’ with any integer less than or equal to ‘Ai’ in ‘ARR’.You should return an array/list consisting of ‘N’ integers where the ‘i-th’ integer is the answer of ‘QUERIES[i]’.

//Problem Link: https://www.codingninjas.com/studio/problems/maximum-xor-with-an-element-from-array_1382020?utm_source=striver&utm_medium=website&utm_campaign=a_zcoursetuf

import java.util.*;

class Node {
    Node[] links = new Node[2];

    boolean containsKey(int key) {
        return links[key] != null;
    }

    Node get(int key) {
        return links[key];
    }

    void put(int key, Node node) {
        links[key] = node;
    }
}

class Trie {
    private static Node root;

    Trie() {
        this.root = new Node();
    }

    public static void insert(int num) {
        Node node = root;
        for (int i = 31; i >= 0; i--) {
            int bit = (num >> i) & 1;
            if (!node.containsKey(bit)) {
                node.put(bit, new Node());
            }
            node = node.get(bit);
        }
    }

    public int getXOR(int num) {
        Node node = root;
        int max = 0;
        for (int i = 31; i >= 0; i--) {
            int bit = (num >> i) & 1;
            if (node.containsKey(1 - bit)) {
                max = max | (1 << i);
                node = node.get(1 - bit);
            } else
                node = node.get(bit);
        }
        return max;
    }
}

public class maximumXorWithAnElementFromArray {
    public static ArrayList<Integer> maxXorQueries(ArrayList<Integer> arr, ArrayList<ArrayList<Integer>> queries) {
        // Write your code here.
        Collections.sort(arr);
        ArrayList<ArrayList<Integer>> offlineQueries = new ArrayList<ArrayList<Integer>>();
        int m = queries.size();
        for (int i = 0; i < m; i++) {
            ArrayList<Integer> temp = new ArrayList<Integer>();
            temp.add(queries.get(i).get(1));
            temp.add(queries.get(i).get(0));
            temp.add(i);
            offlineQueries.add(temp);
        }
        Collections.sort(offlineQueries, new Comparator<ArrayList<Integer>>() {
            public int compare(ArrayList<Integer> a, ArrayList<Integer> b) {
                return a.get(0).compareTo(b.get(0));
            }
        });
        int ind = 0;
        int n = arr.size();
        Trie trie = new Trie();
        ArrayList<Integer> ans = new ArrayList<Integer>(m);
        for (int i = 0; i < m; i++)
            ans.add(-1);
        for (int i = 0; i < m; i++) {
            while (ind < n && arr.get(ind) <= offlineQueries.get(i).get(0)) {
                trie.insert(arr.get(ind));
                ind++;
            }
            int queryInd = offlineQueries.get(i).get(2);
            if (ind != 0)
                ans.set(queryInd, trie.getXOR(offlineQueries.get(i).get(1)));
            else
                ans.set(queryInd, -1);
        }
        return ans;
    }
}