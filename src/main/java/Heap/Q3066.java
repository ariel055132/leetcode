package Heap;

import java.util.PriorityQueue;

public class Q3066 {
    /**
     * You are given a 0-indexed integer array nums, and an integer k.
     * You are allowed to perform some operations on nums, where in a single operation, you can:
     * Select the two smallest integers x and y from nums.
     * Remove x and y from nums.
     * Insert (min(x, y) * 2 + max(x, y)) at any position in the array.
     * Note that you can only apply the described operation if nums contains at least two elements.
     * Return the minimum number of operations needed so that all elements of the array are greater than or equal to k.
     *
     * Use min-heap gives you the smallest remaining number
     * 1. Insert every input number into the heap
     * 2. Continue while at least two numbers remain and the smallest is below k
     * 3. Remove the smallest number, then the smallest of what remains
     * 4. Combine them and insert the result
     * 5. Increment result and repeat
     **/
    public int minOpeations(int[] nums, int k) {
        int result = 0;
        // Use heap to ensure always select and remove two smallest integers from nums
        PriorityQueue<Long> pq = new PriorityQueue<>();
        // Insert every input number into the heap
        for (int num : nums) {
            pq.add((long) num);
        }
        // pq.size() >= 2: Can only apply the operation if nums contains at least two elements
        // pq.peek() < k: the smallest is below k, repeat the action below
        while (pq.size() >= 2 && pq.peek() < k) {
            long x = pq.poll(); // smallest integer - x
            long y = pq.poll(); // smallest integer - y
            long newNum = (Math.min(x, y) * 2 + Math.max(x, y)); // Insert new num at any position in the array

            pq.add(newNum);
            result++;
        }
        return result;
    }
}
