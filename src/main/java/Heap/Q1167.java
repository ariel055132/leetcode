package Heap;

import java.util.PriorityQueue;

public class Q1167 {
    /**
     * You have some number of sticks with positive integer lengths. 
     * These lengths are given as an array sticks, where sticks[i] is the length of the ith stick.
     * You can connect any two sticks of lengths x and y into one stick by paying a cost of x + y.
     * You must connect all the sticks until there is only one stick remaining.
     * Return the minimum cost of connecting all the given sticks into one stick in this way.
     * 
     * Follow the instructions stated by the question.
     * 1. Put all the stick lengths into a min-heap.
     * 2. Initialize cost = 0
     * 3. While the heap has more than one stick:
     *      1. Removed the two shortest sticks: x and y
     *      2. Merge them: merged = x + y.
     *      3. Add merged to cost
     *      4. Push merged back into the heap. (Ensure is is sorted in ascending order)
     * 
     * Why using a minHeap?
     * we need to maintain the minimum cost to connect, therefore we need to choose the two shortest sticks in combination
     * Using minHeap to avoid continuous sorting
     * 
     * Time Complexity: O(n log n), as each stick is inserted into and removed from the heap
     * Space Complexity: O(n), for the min-Heap
     * 
     * @param sticks int[]
     * @return
     */
    public int connectSticks(int[] sticks) {
        int result = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int stick : sticks) {
            pq.add(stick);
        }
        while (pq.size() > 1) {
            int stick1 = pq.poll();
            int stick2 = pq.poll();
            int stickSum = stick1 + stick2;
            result += stickSum;
            pq.add(stickSum);
        }
        return result;
    }
}
