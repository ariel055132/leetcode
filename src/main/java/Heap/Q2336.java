package Heap;

import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;

public class Q2336 {
    /**
     * You have a set which contains all positive integers [1, 2, 3, 4, 5, ...].
     * Implement the SmallestInfiniteSet class:
     * 1. SmallestInfiniteSet() Initializes the SmallestInfiniteSet object to contain all positive integers.
     * 2. int popSmallest() Removes and returns the smallest integer contained in the infinite set.
     * 3. void addBack(int num) Adds a positive integer num back into the infinite set, if it is not already in the infinite set.
     * 
     * Use heap (aka. PriorityQueue) to efficiently remove the smallest number
     * Use set to efficiently check membership and prevent duplicates
     * Both structures always 
     */
    PriorityQueue<Integer> pq = new PriorityQueue<>();
    Set<Integer> set = new HashSet<>();

    /**
     * -> SmallestInfiniteSet()
     * Add every integer from 1 to 1001 to both structures
     */
    public Q2336() {
        for (int i = 1; i <= 1001; i++) {
            pq.add(i);
            set.add(i);
        }
    }

    /**
     * Remove and return the smallest integer contained in the infinite set.
     * pq.remove() removes the heap's minimum
     * Also removes the number from set
     * 
     * @return
     */
    public int popSmallest() {
        int num = pq.remove();
        set.remove(num);
        return num;
    }

    /**
     * Add the number
     * If set.contains(nums) is false, insert num into both structures
     * Otherwise, leave them unchanged
     * 
     * @param num
     */
    public void addBack(int num) {
        if (!set.contains(num)) {
            set.add(num);
            pq.add(num);
        } 
    }
}
