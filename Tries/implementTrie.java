// Problem Statement:  Implement a data structure ”TRIE” from scratch. Complete some functions.
// 1) Trie(): Initialize the object of this “TRIE” data structure.
// 2) insert(“WORD”): Insert the string “WORD”  into this “TRIE” data structure.
// 3) countWordsEqualTo(“WORD”): Return how many times this “WORD” is present in this “TRIE”.
// 4) countWordsStartingWith(“PREFIX”): Return how many words are there in this “TRIE” that have the string “PREFIX” as a prefix.
// 5) erase(“WORD”): Delete this string “WORD” from the “TRIE”.
// Note:
// 1. If erase(“WORD”) function is called then it is guaranteed that the “WORD” is present in the “TRIE”.
// 2. If you are going to use variables with dynamic memory allocation then you need to release the memory associated with them at the end of your solution.

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