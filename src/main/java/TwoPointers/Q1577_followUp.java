package TwoPointers;

import java.util.Arrays;
import java.util.HashMap;

public class Q1577_followUp {
    public int numTriplets(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);

        return helper(nums1, nums2) + helper(nums2, nums1);
    }

    public int helper(int[] nums1, int[] nums2) {
        int result = 0;
        HashMap<Long, Integer> num2ProductFreqMap = new HashMap<>();
        for (int i = 0; i < nums2.length; i++) {
            for (int j = i + 1; j < nums2.length; j++) {
                long currentProduct = (long) nums2[i] * nums2[j];
                num2ProductFreqMap.put(currentProduct, num2ProductFreqMap.getOrDefault(currentProduct, 0) + 1);
            }
        }

        for (int i = 0; i < nums1.length; i++) {
            long currentSquare = (long) nums1[i] * nums1[i];
            if (num2ProductFreqMap.containsKey(currentSquare)) {
                result += num2ProductFreqMap.get(currentSquare);
            }
        }
        return result;
    }
}
