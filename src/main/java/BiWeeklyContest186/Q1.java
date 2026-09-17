package BiWeeklyContest186;

import java.util.HashMap;

public class Q1 {
    /**
     * You are given an integer array nums of odd length n.
     * Return true if the middle element of nums appears exactly once in the array. Otherwise return false.
     * 
     * @param nums
     * @return
     */
    public boolean isMiddleElementUnique(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int n = nums.length;
        int middleN = n / 2;
        // Store nums[nums.length / 2] as middleNum
        int middleNum = nums[middleN];
        // Scan the array, store the occurrence of element in nums with hashmap
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        return map.get(middleNum) == 1;
    }
}
