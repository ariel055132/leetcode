package Heap;

import java.util.Collections;
import java.util.PriorityQueue;

public class Q2530 {
    public long maxKelements(int[] nums, int k) {
        long result = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for (int num : nums) {
            pq.add(num);
        }
        for (int i = 0; i < k; i++) {
            int num = pq.remove();
            result += num;
            num = Math.floorDiv(num, 3);
            pq.add(num);
        }
        return result;
    }
}
