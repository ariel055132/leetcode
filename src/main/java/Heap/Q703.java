package Heap;

import java.util.PriorityQueue;

public class Q703 {
    /**
     * You are tasked to implement a class which, for a given integer k, maintains a stream of test scores and continuously returns the kth highest test score after a new score has been submitted. More specifically, we are looking for the kth highest score in the sorted list of all scores.
     *
     * Implement the KthLargest class:
     *
     * KthLargest(int k, int[] nums) Initializes the object with the integer k and the stream of test scores nums.
     * int add(int val) Adds a new test score val to the stream and returns the element representing the kth largest element in the pool of test scores so far.
     *
     * Maintain a heap sized with k
     * As min-heap is used in Java, first element is the kth largest element in the heap
     */
    PriorityQueue<Integer> pq = new PriorityQueue<>();
    int k;

    public Q703(int k, int[] nums) {
        this.k = k;
        for (int num : nums) {
            add(num);
        }
    }

    public int add(int val) {
        pq.add(val);
        if (pq.size() > k) {
            pq.poll();
        }
        return pq.peek();
    }
}
