import java.util.HashMap;

public class Q961 {
    /**
     * You are given an integer array nums with the following properties:
     * 1. nums.length == 2 * n
     * 2. nums contains n + 1 unique elements
     * 3. Exactly one element of nums is repeated n times
     * Return the element that is repeated n times.
     *
     * Solution:
     * 1. Create a hashmap to count and save the frequencies of elements
     * 2. If the frequencies of elements == n times, return it
     *
     * Time Complexity: O(N), where N is the length of nums
     * Space Complexity: O(N)
     *
     * @param nums int[]
     * @return int
     */
    public int repeatedNTimes(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int nTimes = nums.length / 2;
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
            if (map.get(num) == nTimes) {
                return num;
            }
        }
        return 1;
    }
}
