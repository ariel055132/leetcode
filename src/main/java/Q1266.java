public class Q1266 {
    public int minTimeToVisitAllPoints(int[][] points) {
        int result = 0; // answer need to return
        for (int i = 1; i < points.length; i++) {
            int currX = points[i - 1][0];
            int currY = points[i - 1][1];
            int targetX = points[i][0];
            int targetY = points[i][1];
            result += Math.max(Math.abs(targetX - currX), Math.abs(targetY - currY));
        }

        return result;
    }
}
