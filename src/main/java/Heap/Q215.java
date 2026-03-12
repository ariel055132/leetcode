package Heap;

import java.util.PriorityQueue;

public class Q215 {
    /**
     * Given an integer array nums and an integer k, return the kth largest element in the array.
     * Note that it is the kth largest element in the sorted order, not the kth distinct element.
     * 
     * Complexity: O(nlogk)
     * Each of the n elements is processed once. However, heap operations take O(log k) time, leading to an overall complexity of O(n log k).
     * 
     * @param nums
     * @param k
     * @return
     */
    public int findKthLargest(int[] nums, int k) {
        // Create min-heap where the smallest element is at the top
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int num : nums) {
            // Add the element to the heap
            pq.add(num);
            // Check if heap exceeds size k
            if (pq.size() > k) {
                // remove the smallest element
                // Keeps only the k largest elements in the heap
                pq.poll();
            }
        }
        return pq.peek();
    }
}
