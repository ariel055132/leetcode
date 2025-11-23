public class Q3190 {
    /**
     * You are given an integer array nums. In one operation, you can add or subtract 1 from any element of nums.
     * Return the minimum number of operations to make all elements of nums divisible by 3.
     *
     * Loop through each element in the array
     * Include elements that are not divisible by 3 in the result
     * Return the filtered result array
     *
     * For any number n:
     * If n % 3 == 2: n + 1 is divisible by 3
     * If n % 3 == 1: n - 1 is divisible by 3
     * This guarantees the minimum number of operations (exactly 1) to reach divisibility
     *
     * @param nums array
     * @return result
     */
    public int minimumOperation(int[] nums) {
        int result = 0;
        for (int num : nums) {
            if (num % 3 != 0) {
                result++;
            }
        }
        return result;
    }
}
