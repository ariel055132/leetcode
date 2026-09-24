package Heap;

import java.util.Comparator;
import java.util.PriorityQueue;

public class Q2558 {
    /**
     * You are given an integer array gifts denoting the number of gifts in various piles. Every second, you do the following:
     * Choose the pile with the maximum number of gifts.
     * If there is more than one pile with the maximum number of gifts, choose any.
     * Reduce the number of gifts in the pile to the floor of the square root of the original number of gifts in the pile.
     * 
     * Return the number of gifts remaining after k seconds.
     * 
     * Repeatedly need to remove the maximum value and insert its updated value
     * Therefore, a max-heap fits a problem
     * 
     * @param gifts
     * @param k
     * @return
     */
    public long pickGifts(int[] gifts, int k) {
        long result = 0;
        // Heap in java is min heap, need to use reverseOrder to implement maxHeap
        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());
        // Insert every pile into the max-heap
        for (int gift : gifts) {
            pq.add(gift);
        }
        /**
         * Repeat k times
         * 1. Remove the largest pile
         * 2. Compute its square root and round down
         * 3. Insert the remaining pile back into the heap
         */
        for (int i = 0; i < k; i++) {
            // pq.remove -> retrieves and removes the largest pile
            // Square root
            // Cast to int
            // Insert into the priority queue
            pq.add((int)Math.sqrt(pq.remove()));
        }
        // Remove and sum every remaining pile
        while (pq.size() > 0) {
            result += pq.remove();
        }
        return result;
    }
}
