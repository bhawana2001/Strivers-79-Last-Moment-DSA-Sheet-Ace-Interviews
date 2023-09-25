// Problem Statement: Given a grid of size NxM (N is the number of rows and M is the number of columns in the grid) consisting of ‘0’s (Water) and ‘1’s(Land). Find the number of islands.
// Note: An island is surrounded by water and is formed by connecting adjacent lands horizontally or vertically or diagonally i.e., in all 8 directions.

//Problem Link: https://www.codingninjas.com/studio/problems/distinct-islands_630460?utm_source=striver&utm_medium=website&utm_campaign=a_zcoursetuf

import java.util.*;

public class numberOfDistinctIslands {
    public static int distinctIsland(int[][] arr, int n, int m) {
        // write your code here

        HashSet<ArrayList<String>> set = new HashSet<>();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (arr[i][j] == 1) {
                    ArrayList<String> temp = new ArrayList<>();
                    dfs(arr, temp, i, j, i, j);
                    set.add(temp);
                }
            }
        }
        return set.size();
    }

    public static void dfs(int[][] arr, ArrayList<String> temp, int i, int j, int i0, int j0) {
        if (i < 0 || j < 0 || i >= arr.length || j >= arr[0].length || arr[i][j] != 1)
            return;
        if (arr[i][j] == 1) {
            arr[i][j] = 0;
            temp.add(toString(i - i0, j - j0));
            dfs(arr, temp, i + 1, j, i0, j0);
            dfs(arr, temp, i - 1, j, i0, j0);
            dfs(arr, temp, i, j + 1, i0, j0);
            dfs(arr, temp, i, j - 1, i0, j0);
        }
    }

    public static String toString(int row, int col) {
        return Integer.toString(row) + " " + Integer.toString(col);
    }
}
