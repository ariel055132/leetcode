import java.util.HashMap;
import java.util.Map;

public class Q219 {
    /**
     * Given an integer array nums and an integer k, return true if there are two distinct indices i and j in the array such that nums[i] == nums[j] and abs(i - j) <= k.
     *
     * @param nums int[]
     * @param k int
     * @return boolean
     */
    public boolean containsNearbyByDuplicate(int[] nums, int k) {
        // Key: element in array nums ; Value: index of element in array
        Map<Integer, Integer> map = new HashMap<>();
        for (int index = 0; index < nums.length; index++) {
            // Element in array nums does not exist in map, initialize it
            if (map.get(nums[index]) == null) {
                map.put(nums[index], index);
            } else {
                // If Element in array nums found in map, do the calculation: abs(index2 - index1)
                // Figure out the abs result is smaller or equal to k or not
                // If Yes -> return true
                // If No -> Update the map
                int indexDiff = Math.abs(index - map.get(nums[index]));
                if (indexDiff <= k) {
                    return true;
                }
                map.put(nums[index], index);
            }
        }
        return false;
    }
}
