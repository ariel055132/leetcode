public class Q1004 {
    public int longestOnes(int[] nums, int k) {
        int left = 0;
        int result = 0;
        int zeroCount = 0;
        for (int right = 0; right < nums.length; right++){
            if (nums[right] == 0) {
                zeroCount++;
            }
            if (zeroCount > k) {
                if (nums[left] == 0) {
                    zeroCount--;
                }
                left++;
            }
            result = Math.max(result, right - left + 1);
        }
        return result;
    }
}
