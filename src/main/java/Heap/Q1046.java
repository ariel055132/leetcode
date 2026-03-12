package Heap;

import java.util.Collections;
import java.util.PriorityQueue;

public class Q1046 {
    /**
     * You are given an array of integers stones where stones[i] is the weight of the ith stone.
     * We are playing a game with the stones. On each turn, we choose the heaviest two stones and smash them together. Suppose the heaviest two stones have weights x and y with x <= y. 
     * The result of this smash is:
     * 1. If x == y, both stones are destroyed, and
     * 2. If x != y, the stone of weight x is destroyed, and the stone of weight y has new weight y - x.
     * At the end of the game, there is at most one stone left.
     * Return the weight of the last remaining stone. If there are no stones left, return 0.
     * 
     * @param stones
     * @return
     */
    public int lastStoneWeight(int[] stones) {
        // Use maxHeap as we need to choose the heaviest two stone
        // maxHeap -> [greatest element ... smallest element]
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        // Add the stones into the maxHeap
        for (int stone : stones) {
            maxHeap.add(stone);
        }   
        // Start choosing the heaviest two stones
        while (maxHeap.size() > 1) {
            int top1 = maxHeap.peek(); // x
            maxHeap.poll();
            int top2 = maxHeap.peek(); // y
            maxHeap.poll();
            // if x != y, the stone has new weight: y - x
            if (top1 != top2) {
                maxHeap.add(top1 - top2);
            }
        
        }
        // Return the weight of the last remaining stone
        // If no stones left (maxHeap is empty), return 0
        return maxHeap.isEmpty() ? 0 : maxHeap.peek();
    }
}
