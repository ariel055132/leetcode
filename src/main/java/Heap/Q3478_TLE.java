package Heap;

import java.util.PriorityQueue;

public class Q3478_TLE {
    public long[] findMaxSum(int[] nums1, int[] nums2, int k) {
        long[] result = new long[nums1.length];
        for (int i = 0; i < nums1.length; i++) {
            int nums1Val = nums1[i];
            PriorityQueue<Integer> pq = new PriorityQueue<>();
            long sum = 0;
            for (int j = 0; j < nums1.length; j++) {
                if (nums1[j] < nums1[i]) {
                    pq.add(nums2[j]);
                    sum += nums2[j];
                }
                if (pq.size() > k) {
                    sum -= pq.poll();
                }
            }
            result[i] = sum;
        }

        return result;
    }
}
