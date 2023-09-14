// Problem Statement: Given an m x n grid of characters board and a string word, return true if the word exists in the grid. The word can be constructed from letters of sequentially adjacent cells, where adjacent cells are horizontally or vertically neighboring. The same letter cell may not be used more than once.

//Problem Link: https://www.codingninjas.com/studio/problems/word-search---l_892986?utm_source=striver&utm_medium=website&utm_campaign=a_zcoursetuf

public class wordSearch {
    public static boolean present(char[][] board, String word, int n, int m) {
        // Convert the word to a character array
        char[] targetWord = word.toCharArray();

        // Iterate through each cell on the board
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                // If the first character of the word matches the current cell,
                // try to find the word starting from this cell using backtracking
                if (board[i][j] == targetWord[0] && backtrack(board, targetWord, i, j, 0)) {
                    return true;
                }
            }
        }

        // If the word is not found after checking all possible starting points, return
        // false
        return false;
    }

    private static boolean backtrack(char[][] board, char[] targetWord, int i, int j, int k) {
        int n = board.length;
        int m = board[0].length;

        // If the entire word is found, return true
        if (k == targetWord.length) {
            return true;
        }

        // Check if the current cell is out of bounds or doesn't match the target
        // character
        if (i < 0 || i >= n || j < 0 || j >= m || board[i][j] != targetWord[k]) {
            return false;
        }

        // Temporarily mark the current cell as visited
        char temp = board[i][j];
        board[i][j] = ' ';

        // Explore adjacent cells in all four directions
        boolean found = backtrack(board, targetWord, i + 1, j, k + 1) ||
                backtrack(board, targetWord, i - 1, j, k + 1) ||
                backtrack(board, targetWord, i, j + 1, k + 1) ||
                backtrack(board, targetWord, i, j - 1, k + 1);

        // Restore the original character at the current cell
        board[i][j] = temp;

        return found;
    }
}
