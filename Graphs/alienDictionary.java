// Problem Statement: Given a sorted dictionary of an alien language having N words and k starting alphabets of a standard dictionary. Find the order of characters in the alien language.
// Note: Many orders may be possible for a particular test case, thus you may return any valid order.

//Problem Link: https://www.codingninjas.com/studio/problems/alien-dictionary_630423?utm_source=striver&utm_medium=website&utm_campaign=a_zcoursetuf

import java.util.*;

public class alienDictionary {
    public static String getAlienLanguage(String[] dictionary, int k) {

        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();

        for (int i = 0; i < k; i++) {
            adj.add(new ArrayList<>());
        }
        for (int i = 0; i < dictionary.length - 1; i++) {

            String s1 = dictionary[i];
            String s2 = dictionary[i + 1];
            int len = Math.min(s1.length(), s2.length());

            for (int ptr = 0; ptr < len; ptr++) {

                if (s1.charAt(ptr) != s2.charAt(ptr)) {
                    adj.get(s1.charAt(ptr) - 'a').add(s2.charAt(ptr) - 'a');
                    break;
                }
            }
        }
        boolean vis[] = new boolean[k];
        Stack<Integer> st = new Stack<>();

        for (int i = 0; i < k; i++) {
            if (vis[i] == false) {
                dfs(i, vis, adj, st);
            }
        }
        String ans = "";

        while (!st.isEmpty()) {
            ans = ans + (char) (st.peek() + 'a');
            st.pop();
        }
        return ans;
    }

    public static void dfs(int node, boolean[] vis, ArrayList<ArrayList<Integer>> adj, Stack<Integer> st) {

        vis[node] = true;

        for (int it : adj.get(node)) {
            if (vis[it] == false) {
                dfs(it, vis, adj, st);
            }
        }
        st.push(node);

    }
}