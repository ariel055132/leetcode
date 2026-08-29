import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Q3471 {
    /**
     * You are given an integer array nums and an integer k.
     * An integer x is almost missing from nums if x appears in exactly one subarray of size k within nums.
     * Return the largest almost missing integer from nums. If no such integer exists, return -1.
     * A subarray is a contiguous sequence of elements within an array. 
     * 
     * 
     * @param nums
     * @param k
     * @return
     */
    public int largestInteger(int[] nums, int k) {
        int result = -1;
        // Map for saving the frequencies of number in subarray
        // Key: number ; Value: frequencies of number 
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length - k; i++) {
            Set<Integer> set = new HashSet<>();
            // Enumerate the possibibles of sub array
            for (int j = i; j < i + k; j++) {
                set.add(nums[j]);
            }
            // If num is inside the subarray, add the value of those number in map
            for (int num : set) {
                map.put(num, map.getOrDefault(num, 0) +1);
            }
        }
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            // Find An integer x is almost missing from nums if x appears in exactly one subarray of size k within nums.
            // Checking out the largest result
            if (entry.getValue() == 1) {
                result = Math.max(result, entry.getKey());
            }
        }

        return result;
    }
}
