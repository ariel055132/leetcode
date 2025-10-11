package TwoPointers;

public class Q977_FollowUp {
    /**
     * Finding an O(n) Solution
     *
     * @param nums
     * @return
     */
    public int[] sortedSquares(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        int resultIndex = nums.length - 1;
        int[] result = new int[nums.length];
        while (left <= right) {
            int leftIndexNumValue = nums[left] * nums[left];
            int rightIndexNumValue = nums[right] * nums[right];
            if (leftIndexNumValue >= rightIndexNumValue) {
                result[resultIndex] = leftIndexNumValue;
                resultIndex--;
                left++;
            } else {
                result[resultIndex] = rightIndexNumValue;
                resultIndex--;
                right--;
            }
        }
        return result;
    }
}
