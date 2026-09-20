package BiWeeklyContest185;

import java.util.Arrays;

public class Q1 {
    /**
     * You are given two integers m and n, representing the number of rows and columns of a grid.
     * Construct any m x n grid consisting only of the characters '.' and '#', where:
     * '.' represents a free cell.
     * '#' represents an obstacle cell.
     * A valid path is a sequence of free cells that:
     * Starts at the top-left cell (0, 0).
     * Ends at the bottom-right cell (m - 1, n - 1).
     * Moves only: 
     * Right, from (i, j) to (i, j + 1), or
     * Down, from (i, j) to (i + 1, j).
     * Return any grid such that there is exactly one valid path from the top-left cell to the bottom-right cell.
     * 
     * start with every cell blocked, then open a staircase-shaped path. The path alternates right and down until it reaches a boundary, then continues along that boundary.
     * 
     * @param m
     * @param n
     * @return
     */
    public String[] uniquePathGrid(int m, int n) {
        // Fill the grid with obstacles.
        char[][] grid = new char[m][n];
        for (int i = 0; i < m; i++) {
            Arrays.fill(grid[i], '#');
        }
        
        // Open the starting cell.
        int r = 0, c = 0;
        grid[r][c] = '.';  
        
        while (r < m - 1 || c < n - 1) {
            // Move toward the destination, opening each visited cell.
            if (c < n - 1 && (r == m - 1 || c == r)) {
                c++;
            } else {
                r++; 
            }
            grid[r][c] = '.';
        }
        
        // Convert each character row into a string for the return value.
        String[] result = new String[m];
        for (int i = 0; i < m; i++) {
            result[i] = new String(grid[i]);
        }
        
        return result;
    }
}

