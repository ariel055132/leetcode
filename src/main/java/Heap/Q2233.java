package Heap;

import java.util.PriorityQueue;

public class Q2233 {
    /**
     * You are given an array of non-negative integers nums and an integer k.
     * In one operation, you may choose any element from nums and increment it by 1.
     * Return the maximum product of nums after at most k operations.
     * Since the answer may be very large, return it modulo 109 + 7.
     * Note that you should maximize the product before taking the modulo.
     *
     * Always increment the smallest element (observing example)
     * Using a min-heap to find the smallest element efficiently
     *
     * Consider two values a <= b:
     * Increment a: the product becomes (a + 1) * b = ab + b
     * Increment b: the product becomes a * (b + 1) = ab + a
     * Since b >= a, increment the smaller value produces at least as large as a product
     *
     * @param nums int[]
     * @param k int
     * @return int
     *
     * O((n + k) log n)
     */
    public int maximumProduct(int[] nums, int k) {
        // Build the heap. (Java's default heap is min-heap)
        // Add every number to the heap.
        PriorityQueue<Integer> pq =  new PriorityQueue<>();
        for (int num : nums) {
            pq.add(num);
        }
        // Perform k increment
        // pq.poll removes the smallest value
        // Increment it and insert it again
        for (int i = 0; i < k; i++) {
            int tmp = pq.poll();
            tmp++;
            pq.add(tmp);
        }

        // Calculate the product
        // Apply the module (MOD) after each multiplication
        long result = 1;
        long MOD = 1_000_000_007;
        while (!pq.isEmpty()) {
            result = (result * pq.poll()) % MOD;
        }
        return (int) result;
    }
}
