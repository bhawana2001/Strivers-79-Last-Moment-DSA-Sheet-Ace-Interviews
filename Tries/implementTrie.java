// Problem Statement: You are given a Trie data structure representing a dictionary of words. You need to implement a function deleteWord that deletes a specified word from the Trie. The Trie is represented by the TrieNode class, which contains an array of children nodes for each letter from 'a' to 'z' and a boolean isEnd indicating whether the current node represents the end of a word.

//Problem Link: https://www.codingninjas.com/studio/problems/trie-delete-operation_1062663?utm_source=striver&utm_medium=website&utm_campaign=a_zcoursetuf

class TrieNode {
    TrieNode children[] = new TrieNode[26];
    boolean isEnd;

    TrieNode() {
        isEnd = false;

        for (int i = 0; i < 26; i++) {
            children[i] = null;
        }
    }
};

public class implementTrie {

    public static TrieNode deleteWord(TrieNode root, String word) {
        // WRITE YOUR CODE HERE
        TrieNode curr = root;

        for (int i = 0; i < word.length(); i++) {
            if (curr.children[word.charAt(i) - 'a'] == null)
                break;
            curr = curr.children[word.charAt(i) - 'a'];
        }
        curr.isEnd = false;
        return root;
    }

}