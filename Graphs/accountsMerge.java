// Problem Statement: Given a list of accounts where each element account [ i ] is a list of strings, where the first element account [ i ][ 0 ]  is a name, and the rest of the elements are emails representing emails of the account.
// Now, we would like to merge these accounts. Two accounts definitely belong to the same person if there is some common email to both accounts. Note that even if two accounts have the same name, they may belong to different people as people could have the same name. A person can have any number of accounts initially, but all of their accounts definitely have the same name.
// After merging the accounts, return the accounts in the following format: the first element of each account is the name, and the rest of the elements are emails in sorted order.

// Note: Accounts themselves can be returned in any order.

//Problem Link: https://www.codingninjas.com/studio/problems/accounts-merge_1089558?utm_source=striver&utm_medium=website&utm_campaign=a_zcoursetuf

import java.util.*;

class DisjointSet {
    private int[] rank;
    private int[] parent;

    public DisjointSet(int n) {
        rank = new int[n];
        parent = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }
    }

    public int findParent(int node) {
        if (node == parent[node]) {
            return node;
        }
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

public class accountsMerge {
    public static List<List<String>> accountsMerge1(List<List<String>> accounts) {
        // Write your code here.
        int n = accounts.size();
        DisjointSet disjointSet = new DisjointSet(n);

        Map<String, Integer> emailToIndex = new HashMap<>();

        for (int i = 0; i < n; i++) {
            for (int j = 1; j < accounts.get(i).size(); j++) {
                String email = accounts.get(i).get(j);
                if (!emailToIndex.containsKey(email)) {
                    emailToIndex.put(email, i);
                } else {
                    disjointSet.unionByRank(i, emailToIndex.get(email));
                }
            }
        }

        Map<Integer, List<String>> mergedEmails = new HashMap<>();

        for (Map.Entry<String, Integer> entry : emailToIndex.entrySet()) {
            String email = entry.getKey();
            int node = disjointSet.findParent(entry.getValue());

            if (!mergedEmails.containsKey(node)) {
                mergedEmails.put(node, new ArrayList<>());
            }
            mergedEmails.get(node).add(email);
        }

        List<List<String>> result = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            if (mergedEmails.containsKey(i)) {
                List<String> mergedList = mergedEmails.get(i);
                Collections.sort(mergedList);
                mergedList.add(0, accounts.get(i).get(0));
                result.add(mergedList);
            }
        }

        return result;
    }
}
