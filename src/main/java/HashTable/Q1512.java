package HashTable;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Q1512 {
    /**
     * Given an array of integer nums, return the number of good pairs.
     * A pair (i, j) is called good if nums[i] == nums[j] and i < j.
     *
     * @param nums
     * @return
     */
    public int numIdenticalPairs(int[] nums) {
        int result = 0;
        Arrays.sort(nums);
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            if (map.get(num) == null) {
                map.put(num, 1);
            } else {
                map.put(num, map.get(num) + 1);
            }
            result += map.get(num) - 1;
        }
        return result;
    }
}
