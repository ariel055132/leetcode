import java.util.HashMap;
import java.util.Map;

public class Q3005 {
    /**
     * Given an array nums consisting of positive integers. (nums)
     * Return the total frequencies of elements in nums such that those elements all have the maximum frequency
     * The frequency of an element is the number of occurences of that element in the array
     *
     * @param nums int[]
     * @return result int
     */
    public int maxFrequencyElements(int[] nums) {
        int result = 0;
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        for (int num : nums) {
            hashMap.put(num, hashMap.getOrDefault(num, 0) + 1);
        }
        int maxValue = hashMap.values().stream()
                .max(Integer::compareTo)
                .orElse(Integer.MIN_VALUE);
        for (Map.Entry<Integer, Integer> entry : hashMap.entrySet()) {
            if (entry.getValue() == maxValue) {
                result += entry.getValue();
            }
        }
        return result;
    }
}
