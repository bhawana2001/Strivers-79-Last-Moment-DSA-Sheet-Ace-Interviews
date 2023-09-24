// Problem Statement: You will be given an m x n grid, where each cell has the following values : 
// 2  –  represents a rotten orange
// 1  –  represents a Fresh orange
// 0  –  represents an Empty Cell
// Every minute, if a Fresh Orange is adjacent to a Rotten Orange in 4-direction ( upward, downwards, right, and left ) it becomes Rotten. 
// Return the minimum number of minutes required such that none of the cells has a Fresh Orange. If it’s not possible, return -1.

//Problem Link: https://www.codingninjas.com/studio/problems/rotting-oranges_701655?utm_source=striver&utm_medium=website&utm_campaign=a_zcoursetuf

import java.util.*;

class Pair {
    int row, col;
    int time;

    Pair(int row, int col, int time) {
        this.row = row;
        this.col = col;
        this.time = time;
    }
}

public class rottenOranges {

    public static int minTimeToRot(int[][] grid, int n, int m) {
        // Create a queue to perform BFS traversal
        Queue<Pair> q = new LinkedList<>();
        // Create a 2D array to track visited cells
        boolean[][] visit = new boolean[n][m];
        int countFresh = 0; // Count of fresh oranges

        // Initialize the queue and countFresh
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                // Adding oranges that are already rotten to the queue
                if (grid[i][j] == 2) {
                    q.offer(new Pair(i, j, 0));
                }
                // Counting the number of fresh oranges
                else if (grid[i][j] == 1) {
                    countFresh++;
                }
            }
        }

        int maxTime = 0; // Maximum time taken to rot all oranges
        int count = 0; // Count of oranges that have become rotten

        // Arrays for row and column direction (up, right, down, left)
        int[] dx = { -1, 0, 1, 0 };
        int[] dy = { 0, 1, 0, -1 };

        while (!q.isEmpty()) {
            Pair curr = q.poll();
            int row = curr.row;
            int col = curr.col;
            int t = curr.time;

            maxTime = Math.max(maxTime, t);

            // Check adjacent cells for fresh oranges
            for (int i = 0; i < 4; i++) {
                int newRow = row + dx[i];
                int newCol = col + dy[i];

                // Check if the new cell is within bounds, contains a fresh orange, and hasn't
                // been visited
                if (newRow >= 0 && newCol >= 0 && newRow < n && newCol < m && grid[newRow][newCol] == 1
                        && !visit[newRow][newCol]) {
                    visit[newRow][newCol] = true;
                    q.offer(new Pair(newRow, newCol, t + 1));
                    count++;
                }
            }
        }

        // If the total count of rotten oranges is not equal to countFresh, some oranges
        // are still fresh, so return -1
        return count != countFresh ? -1 : maxTime;
    }
}
