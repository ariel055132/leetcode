public class Q2302 {
    public long countSubarrays(int[] nums, long k) {
        long result = 0;
        int left = 0;
        long sum = 0;
        for (int right = 0; right < nums.length; right++) {
            // the current sum
            sum += nums[right];
            // right - left + 1 == The current size of nums
            while (sum * (right - left + 1) >= k) {
                sum -= nums[left];
                left++;
            }
            result += (right - left + 1);
        }
        return result;
    }
}
