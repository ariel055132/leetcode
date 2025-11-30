import java.util.Arrays;

public class Q973 {
    /**
     * finds the k closest points to the origin (0, 0) from a given array of points. The distance is calculated using the Euclidean distance formula (without the square root for optimization)
     *
     * @param points
     * @param k
     * @return
     */
    public int[][] kClosest(int[][] points, int k) {
        // 1. Create array to store distances for each point
        int[] distance = new int[points.length];
        // 2. Create result array to hold k closest points
        int[][] result = new int[k][2];
        // 3. Calculate distance for each point from origin
        for (int i = 0; i < points.length; i++) {
            distance[i] = calculateDistance(points[i]);
        }
        // 4. Sort distances in ascending order
        Arrays.sort(distance);
        // 5. Get the k-th small distance
        int distanceK = distance[k-1];
        // 6. Collect all points with distance <= threshold (k)
        int idx = 0;
        for (int i = 0; i < points.length; i++) {
            if (calculateDistance(points[i]) <= distanceK) {
                result[idx] = points[i];
                idx++;
            }
        }

        return result;
    }

    public int calculateDistance(int[] point) {
        return point[0] * point[0] + point[1] * point[1];
    }
}
