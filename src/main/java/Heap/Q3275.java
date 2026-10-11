package Heap;

import java.util.Collections;
import java.util.PriorityQueue;

public class Q3275 {
    /**
     * There is an infinite 2D plane.
     *
     * You are given a positive integer k. You are also given a 2D array queries, which contains the following queries:
     * queries[i] = [x, y]: Build an obstacle at coordinate (x, y) in the plane.
     * It is guaranteed that there is no obstacle at this coordinate when this query is made.
     *
     * After each query, you need to find the distance of the kth nearest obstacle from the origin.
     * Return an integer array results where results[i] denotes the kth nearest obstacle after query i, or results[i] == -1 if there are less than k obstacles.
     * Note that initially there are no obstacles anywhere.
     * The distance of an obstacle at coordinate (x, y) from the origin is given by |x| + |y|.
     *
     * Keep the k smallest distances in a max-heap
     *
     * @param queries
     * @param k
     * @return
     */
    public int[] resultArray(int[][] queries, int k) {
        int[] result = new int[queries.length];
        // Maintain a max-heap with Collections.reverseOrder().
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for (int i = 0; i < queries.length; i++) {
            // Calculate the obstacle's distance
            // Add the distance to the heap
            pq.add(Math.abs(queries[i][0]) + Math.abs(queries[i][1]));
            // If the heap contains more than k distances, removes its largest value (over-capacity)
            if (pq.size() > k) pq.poll();
            // If the heap contains k distances, record its largest value; Otherwise, record -1
            result[i] = (pq.size() == k) ? pq.peek() : -1;
        }
        return result;
    }
}
