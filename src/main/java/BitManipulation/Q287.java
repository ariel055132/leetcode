package BitManipulation;

import java.util.Arrays;
import java.util.HashMap;

public class Q287 {
    /**
     * HashTable Solution
     * Time Complexity: O(n)
     * Space Complexity: O(n)
     *
     * @param nums int[]
     * @return int
     */
    public int findDuplicate(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            if (map.containsKey(num)) {
                return num; // Find the first duplicate
            } else {
                map.put(num, 1);
            }
        }
        return -1;
    }

    /**
     * Sorting
     * Time Complexity: O(n log n)
     * Space Complexity: O(1)
     */
    public int findDuplicate1(int[] nums) {
        Arrays.sort(nums);
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == nums[i - 1]) {
                return nums[i];
            }
        }
        return -1;
    }

}
