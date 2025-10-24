package SlidingWindow;

public class Q713 {
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        int n = nums.length;
        int product = 1; // otherwise always become 0
        int left = 0;
        int ans = 0;
        for (int right = 0; right < n; right++) {
            product *= nums[right];
            while (product >= k && left <= right) {
                product /= nums[left];
                left++;
            }
            ans += (right - left + 1);
        }
        return ans;
    }
}
