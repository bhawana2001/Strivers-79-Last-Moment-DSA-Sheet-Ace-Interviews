//Problem Statement: Given are the two distinct words startWord and targetWord, and a list denoting wordList of unique words of equal lengths. Find the length of the shortest transformation sequence from startWord to targetWord.
// In this problem statement, we need to keep the following conditions in mind:
// A word can only consist of lowercase characters.
// Only one letter can be changed in each transformation.
// Each transformed word must exist in the wordList including the targetWord.
// startWord may or may not be part of the wordList
// Note:  If there’s no possible way to transform the sequence from startWord to targetWord return 0.

//Problem Link: https://www.codingninjas.com/studio/problems/word-ladder_1102319?utm_source=striver&utm_medium=website&utm_campaign=a_zcoursetuf

import java.util.*;

public class wordLadder {
    // Class to represent pairs of strings and their associated steps
    static class Pair {
        String str;
        int steps;

        Pair(String s, int st) {
            this.steps = st;
            this.str = s;
        }
    }

    // Function to find the shortest transformation sequence from "begin" to "end"
    // using the given "dict"
    public static int wordLadder(String begin, String end, ArrayList<String> dict) {
        HashSet<String> hs = new HashSet<>();

        // Add all words from the dictionary to the HashSet
        for (String s : dict)
            hs.add(s);

        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(begin, 1)); // Start with the "begin" word and set steps to 1

        while (!q.isEmpty()) {
            StringBuilder temp = new StringBuilder(q.peek().str);
            int steps = q.peek().steps;
            q.poll();

            if (temp.toString().equals(end))
                return steps; // If the current word matches the "end," return the number of steps

            // Try changing each character in the word
            for (int i = 0; i < temp.length(); i++) {
                char ori = temp.charAt(i);
                for (char ch = 'a'; ch <= 'z'; ch++) {
                    temp.setCharAt(i, ch); // Change the character

                    // If the modified word is in the dictionary, add it to the queue and remove it
                    // from the dictionary
                    if (hs.contains(temp.toString())) {
                        q.add(new Pair(temp.toString(), steps + 1));
                        hs.remove(temp.toString());
                    }
                }
                temp.setCharAt(i, ori); // Revert the character back to its original value
            }
        }

        return -1; // If no transformation sequence is found, return -1
    }
}
