package Heap;

import java.util.Arrays;
import java.util.PriorityQueue;

public class Q3478 {
    public long[] findMaxSum(int[] nums1, int[] nums2, int k) {
        long[] result = new long[nums1.length];
        Integer[] order = new Integer[nums1.length];
        for (int i = 0; i < nums1.length; i++) {
            order[i] = i;
        }
        Arrays.sort(order, (a, b) -> Integer.compare(nums1[a], nums1[b]));

        PriorityQueue<Integer> pq = new PriorityQueue<>();
        long sum = 0;
        int start = 0;

        while (start < nums1.length) {
            int end = start + 1;
            while (end < nums1.length
                    && nums1[order[end]] == nums1[order[start]]) {
                end++;
            }

            // Heap contains only values from strictly smaller nums1.
            for (int p = start; p < end; p++) {
                result[order[p]] = sum;
            }

            // Add this group for future groups.
            for (int p = start; p < end; p++) {
                int value = nums2[order[p]];
                pq.offer(value);
                sum += value;

                if (pq.size() > k) {
                    sum -= pq.poll();
                }
            }

            start = end;
        }
        return result;
    }
}
