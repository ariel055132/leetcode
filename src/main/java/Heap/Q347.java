package Heap;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class Q347 {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> freqMap = new HashMap<>();
        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b) -> freqMap.get(a) - freqMap.get(b));
        for (int num : nums) {
            freqMap.put(num, freqMap.getOrDefault(num, 0)+1);
        }
        for (int num : freqMap.keySet()) {
            pq.offer(num);
            if (pq.size() > k) {
                pq.poll();
            }
        }
        int[] result = new int[k];
        for (int i = 0; i < k; i++) {
            result[i] = pq.poll();
        }
        return result;

    }
}
