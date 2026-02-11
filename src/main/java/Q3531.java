public class Q3531 {
    public int countCoveredBuildings(int n, int[][] buildings) {
        int result = 0;
        int[] rowMin = new int[n + 1];
        int[] rowMax = new int[n + 1];
        int[] colMin = new int[n + 1];
        int[] colMax = new int[n + 1];

        for (int[] building : buildings) {
            int x = building[0];
            int y = building[1];
            rowMin[y] = Math.min(rowMin[y], x);
            rowMax[y] = Math.min(rowMax[y], x);
            colMin[x] = Math.min(colMin[x], y);
            colMax[x] = Math.max(colMax[x], y);
        }
        for (int[] p : buildings) {
            int x = p[0], y = p[1];
            if (rowMin[y] < x && x < rowMax[y] && colMin[x] < y && y < colMax[x]) {
                result++;
            }
        }

        return result;
    }
}
