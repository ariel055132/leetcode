public class Q3512 {
    /**
     * You are given an integer array nums and an integer k. You can perform the following operation any number of times:
     * Select an index i and replace nums[i] with nums[i] - 1.
     * Return the minimum number of operations required to make the sum of the array divisible by k.
     * -----
     * nums = [3, 9, 7]
     * k = 5
     * ans = 4
     * 3 + 9 + 7 = 19
     * 19 % 5 = 4
     * -----
     * nums = [4, 1, 3]
     * k = 4
     * ans = 0
     * 4 + 1 + 3 = 8
     * 8 % 4 = 0
     *
     * @param nums
     * @param k
     * @return
     */
    public int minOperations(int[] nums, int k) {
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        return sum % k;
    }
}
