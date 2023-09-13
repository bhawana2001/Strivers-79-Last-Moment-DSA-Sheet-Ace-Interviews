// Problem Statement: The n-queens is the problem of placing n queens on n × n chessboard such that no two queens can attack each other. 
// Given an integer n, return all distinct solutions to the n -queens puzzle. Each solution contains a distinct boards configuration of the queen’s placement, where ‘Q’ and ‘.’ indicate queen and empty space respectively.

//Problem Link: https://www.codingninjas.com/studio/problems/n-queens_696453?utm_source=striver&utm_medium=website&utm_campaign=a_zcoursetuf

import java.util.ArrayList;
import java.util.List;

public class nQueens {
    public static List<List<Integer>> nQueens(int n) {
        // Initialize the chessboard
        int board[][] = new int[n][n];
        List<List<Integer>> ans = new ArrayList<>();
        int leftRow[] = new int[n];
        int upperDaigonal[] = new int[2 * n - 1];
        int lowerDaigonal[] = new int[2 * n - 1];

        // Initialize the chessboard to all 0s
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                board[i][j] = 0;
            }
        }

        // Start solving the N-Queens problem
        solve(0, board, ans, leftRow, upperDaigonal, lowerDaigonal);
        return ans;
    }

    public static void solve(int col, int[][] board, List<List<Integer>> ans, int[] leftRow, int[] upperDaigonal,
            int[] lowerDaigonal) {
        // Base condition: If we've placed queens in all columns, add the solution
        if (col == board.length) {
            ans.add(construct(board));
            return;
        }

        for (int row = 0; row < board.length; row++) {
            // Check if it's a valid move to place a queen at the current position
            if (leftRow[row] == 0 && upperDaigonal[row + col] == 0
                    && lowerDaigonal[board.length - 1 + col - row] == 0) {
                // Place a queen
                board[row][col] = 1;
                leftRow[row] = 1;
                upperDaigonal[row + col] = 1;
                lowerDaigonal[board.length - 1 + col - row] = 1;

                // Recursively proceed to the next column
                solve(col + 1, board, ans, leftRow, upperDaigonal, lowerDaigonal);

                // Backtrack by removing the queen to explore other possibilities
                board[row][col] = 0;
                leftRow[row] = 0;
                upperDaigonal[row + col] = 0;
                lowerDaigonal[board.length - 1 + col - row] = 0;
            }
        }
    }

    public static List<Integer> construct(int[][] board) {
        List<Integer> res = new ArrayList<>();
        for (int[] row : board) {
            for (int element : row) {
                res.add(element);
            }
        }
        return res;
    }
}
