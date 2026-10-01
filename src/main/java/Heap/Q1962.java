package Heap;

import java.util.Collections;
import java.util.PriorityQueue;

public class Q1962 {
    /**
     * You are given a 0-indexed integer array piles, where piles[i] represents the number of stones in the ith pile, and an integer k. You should apply the following operation exactly k times:
     * Choose any piles[i] and remove floor(piles[i] / 2) stones from it.
     * Notice that you can apply the operation on the same pile more than once.
     * Return the minimum possible total number of stones remaining after applying the k operations.
     *
     * floor(x) is the largest integer that is smaller than or equal to x (i.e., rounds x down).
     *
     * Solution:
     * Always choose the largest current pile since it offers the largest number of removable stone
     * It can lead to the return of the minimum possible total number of stones remaining after applying the k operations
     *
     * We can track the largest current pile by using a max-heap
     *
     * @param piles
     * @param k
     * @return
     */
    public int minStoneSum(int[] piles, int k) {
        int result = 0;
        // Java's default priority queue exposes the smallest value.
        // Collections.reverseOrder() makes it expose the largest value instead. (max-heap)
        PriorityQueue<Long> pq = new PriorityQueue<>(Collections.reverseOrder());
        // Inset every pile into the heap
        for (int pile : piles) {
            pq.add((long) pile);
        }
        // Peform exactly k operation
        while (k != 0) {
            // Remove the largest pile
            long num = pq.remove();
            // Calculate its remaining stones.
            num = num - Math.floorDiv(num, 2);
            // Re-insert it so the heap can find the next largest pile
            pq.add(num);
            k--;
        }
        // Sum all remaining piles and return the result
        for (long num : pq) {
            result += num;
        }
        return result;
    }
}
