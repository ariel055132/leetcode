package Heap;

import java.util.Collections;
import java.util.PriorityQueue;

public class Q2208 {
    /**
     * You are given an array nums of positive integers.
     * In one operation, you can choose any number from nums and reduce it to exactly half the number.
     * (Note that you may choose this reduced number in future operations.)
     *
     * Greedy selection + max-heap
     * We always choose the greatest number inside nums, and halve it.
     * It leads to the largest reduction in a valid order, reaching the target with the fewest option
     *
     * @param nums
     * @return
     */
    public int halveArray(int[] nums) {
        int result = 0;
        // Create a max heap so that poll() removes the largest value
        PriorityQueue<Double> pq = new PriorityQueue<>(Collections.reverseOrder());
        double numsSum = 0; // Original total in nums
        double currentSum = 0; // total removed total so far
        // Put elements to the max-heap
        for (int num : nums) {
            numsSum += num;
            pq.add((double) num);
        }
        while (currentSum < numsSum / 2) {
            // remove the largest value, halve it, and add the reduction to currentSum
            double max = pq.poll();
            max /= 2;
            currentSum += max;
            pq.add(max);
            result++;
        }
        return result;
    }
}
