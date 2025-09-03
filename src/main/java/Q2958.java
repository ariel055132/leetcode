import java.util.HashMap;

public class Q2958 {
    public int maxSubarrayLength(int[] nums, int k) {
        // Edge Case: When nums is empty, or k is 0 -> just return 0
        if (nums == null || k == 0) {
            return 0;
        }
        int n = nums.length;
        int left = 0;
        int result = 0;
        HashMap<Integer, Integer> numFreqMap = new HashMap<>();
        for (int right = 0; right < n; right++) {
            int num = nums[right];
            numFreqMap.put(num, numFreqMap.getOrDefault(num, 0) + 1);
            while (numFreqMap.get(num) > k) {
                int leftNum = nums[left];
                int leftNumFreq = numFreqMap.get(leftNum);
                numFreqMap.put(leftNum, --leftNumFreq);
                left++;
            }
            result = Math.max(result, right - left + 1);
        }
        return result;
    }
}
