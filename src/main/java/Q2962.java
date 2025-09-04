public class Q2962 {
    public long countSubarrays(int[] nums, int k) {
        long result = 0;
        int max = Integer.MIN_VALUE;
        int left = 0;
        int countMax = 0;
        // Find the maximum element in the array
        for (int num : nums) {
            max = Math.max(max, num);
        }
        for (int right = 0; right < nums.length; right++) {
            if (nums[right] == max) {
                countMax++;
            }
            // If countMax is greater than or equal to k, calculate subarrays count
            while (countMax == k) {
                if (nums[left] == max) {
                    countMax--;
                }
                left++;
            }
            result += left;
        }
        return result;
    }
}
