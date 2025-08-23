package Blind75;

public class Q238 {
    /**
     * [1,2,3,4] -> [24,12,8,6]
     *
     * @param nums
     * @return
     */
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] result = new int[n];
        int currentProduct = 1;
        int zeroCnt = 0;
        for (int num : nums) {
            if (num == 0) {
                zeroCnt++;
            } else {
                currentProduct *= num;
            }
        }
        for (int i = 0; i < n; i++) {
            if (nums[i] == 0) {
                result[i] = 0;
                continue;
            }
            result[i] = currentProduct / nums[i];
        }
        return result;
    }
}
