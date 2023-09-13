// Problem Statement:
// Given a 9×9 incomplete sudoku, solve it such that it becomes valid sudoku. Valid sudoku has the following properties.
//          1. All the rows should be filled with numbers(1 – 9) exactly once.
//          2. All the columns should be filled with numbers(1 – 9) exactly once.
//          3. Each 3×3 submatrix should be filled with numbers(1 – 9) exactly once.
// Note: Character ‘.’ indicates empty cell.

//Problem Link: https://www.codingninjas.com/studio/problems/sudoku-solver_8416969?utm_source=striver&utm_medium=website&utm_campaign=a_zcoursetuf

public class sudokuSolver {
    // Function to solve a Sudoku puzzle
    public static boolean sudokuSolver(int board[][]) {
        return solve(board);
    }

    // Check if it's safe to place 'val' at the given row and column
    public static boolean isSafe(int row, int col, int board[][], int val) {
        for (int i = 0; i < board.length; i++) {
            // Check row-wise
            if (board[row][i] == val) {
                return false;
            }
            // Check column-wise
            if (board[i][col] == val) {
                return false;
            }
            // Check subgrid (3x3)
            if (board[3 * (row / 3) + (i / 3)][3 * (col / 3) + (i % 3)] == val) {
                return false;
            }
        }
        return true;
    }

    // Solve the Sudoku puzzle using backtracking
    public static boolean solve(int board[][]) {
        int n = board[0].length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == 0) { // Find an empty cell
                    for (int val = 1; val <= 9; val++) {
                        if (isSafe(i, j, board, val)) {
                            board[i][j] = val; // Place 'val'
                            // Recursively solve for the next cell
                            boolean nextSolutionPossible = solve(board);
                            if (nextSolutionPossible) {
                                return true; // If a valid solution is found
                            } else {
                                board[i][j] = 0; // Backtrack and reset the cell
                            }
                        }
                    }
                    return false; // No valid value can be placed
                }
            }
        }
        return true; // Puzzle is solved
    }
}
