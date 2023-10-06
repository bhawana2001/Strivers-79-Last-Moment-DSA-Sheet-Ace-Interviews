// Problem Statement: Given a string of alphabetic characters. Return the count of distinct substrings of the string(including the empty string) using the Trie data structure.

//Problem Link: https://www.codingninjas.com/studio/problems/count-distinct-substrings_985292?utm_source=striver&utm_medium=website&utm_campaign=a_zcoursetuf

class Node {
    Node[] links;
    boolean isEnd;

    public Node() {
        this.links = new Node[26];
        isEnd = false;
    }

    public void add(char chr, Node node) {
        links[chr - 'a'] = node;
    }

    public Node get(char chr) {
        return links[chr - 'a'];
    }

    public boolean contains(char chr) {
        return links[chr - 'a'] != null;
    }
}

class Trie {
    Node root;
    int distinct = 0;

    public Trie() {
        root = new Node();
    }

    public void insert(String word) {
        Node temp = root;
        for (int i = 0; i < word.length(); i++) {
            if (temp.contains(word.charAt(i))) {
                temp = temp.get(word.charAt(i));
            } else {
                distinct++;
                temp.add(word.charAt(i), new Node());
                temp = temp.get(word.charAt(i));
            }
        }
        temp.isEnd = true;
    }

    public int distinctSubstring() {
        return distinct;
    }
}

public class numberOfDistinctSubstringsInString {

    public static int countDistinctSubstrings(String s) {
        // Write your code here.
        Trie trie = new Trie();
        int n = s.length();
        for (int i = 0; i < n; i++) {
            trie.insert(s.substring(i, n));
        }
        return trie.distinctSubstring() + 1;
    }
}