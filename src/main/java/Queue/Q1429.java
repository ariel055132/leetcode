package Queue;

import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.Map;
import java.util.Queue;

/**
 * You have a queue of integers, you need to retrieve the first unique integer in the queue.
 * 
 * Implement the FirstUnique (Q1429) class:
 * FirstUnique(int[] nums) Initializes the object with the numbers in the queue.
 * int showFirstUnique() returns the value of the first unique integer of the queue, and returns -1 if there is no such integer.
 * void add(int value) insert value to the queue.
 */
public class Q1429 {
    // Preserves insertion order, including duplicates with queue
    Queue<Integer> queue = new ArrayDeque<>();
    // Track whether each number is unique (Key: number, value: uniqueness of number)
    Map<Integer, Boolean> uniqueMap = new HashMap<>();

    // Constructor
    public Q1429(int[] nums) {
        for (int num : nums) {
            this.add(num);
        }
    }

    public int showFirstUnique() {
        // removes nonunique numbers from the front until the queue is empty or its front is unique
        while (!queue.isEmpty() && uniqueMap.get(queue.peek()) == false) {
            queue.poll();
        }
        if (!queue.isEmpty()) {
            return queue.peek();
        }
        return -1;
    }

    /**
     * Insert value to the queue
     * Maintain the uniqueMap for uniqueness check
     * 
     * @param value
     */
    public void add(int value) {
        if (!uniqueMap.containsKey(value)) {
            // Add new number (in map) to queue
            // Mark the number unique
            uniqueMap.put(value, true);
        } else {
            // Mark the number non-unique for later occurrence number
            uniqueMap.put(value, false);
        }
        queue.offer(value);
    }
}
