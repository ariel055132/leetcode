public class Q840 {
    public int numMagicSquaresInside(int[][] grid) {
        int result = 0;
        for (int i = 0; i < grid.length - 3; i++) {
            for (int j = 0; j < grid[0].length - 3; j++) {
                if (isMagicSquare(grid, i, j)) {
                    result++;
                }
            }
        }
        return result;
    }

    public boolean isMagicSquare(int[][] grid, int i, int j) {
        // Check whether it is a valid square
        // 1. Square can contain number from 1 to 9.
        // 2. The square has distinct numbers
        boolean[] seen = new boolean[10];
        for (int x = 0; x < 3; x++) {
            for (int y = 0; y < 3; y++) {
                int num = grid[i + x][j + y];
                if (num < 1 || num > 9 || seen[num]) {
                    System.out.println(num);
                    return false;
                } else {
                    seen[num] = true;
                }
            }
        }

        // Check whether it is a magic square
        // Calculate the sum first
        int sum = grid[i][j] + grid[i][j+1] + grid[i][j+2];
        System.out.println(sum);

        // Check rows
        for (int x = 0; x < 3; x++) {
            int currentRowSum = grid[i+x][j] + grid[i+x][j+1] + grid[i+x][j+2];
            if (sum != currentRowSum) {
                return false;
            }
        }

        // Check columns
        for (int y = 0; y < 3; y++) {
            int currentColSum = grid[i][j+y] + grid[i+1][j+y] + grid[i+2][j+y];
            if (sum != currentColSum) {
                return false;
            }
        }

        // Check diagonals
        int leftToRightDiagonalSum = 0;
        int rightToLeftDiagonalSum = 0;
        if (sum != leftToRightDiagonalSum) {
            return false;
        } else if (sum != rightToLeftDiagonalSum) {
            return false;
        }

        // Meet all of the magic square definition, return true (it's magic square)
        return true;
    }
}
