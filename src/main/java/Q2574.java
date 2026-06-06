public class Q2574 {
    /**
     * You are given a 0-indexed integer array nums of size n.
     * Define two arrays leftSum and rightSum where:
     * leftSum[i] is the sum of elements to the left of the index i in the array nums. If there is no such element, leftSum[i] = 0.
     * rightSum[i] is the sum of elements to the right of the index i in the array nums. If there is no such element, rightSum[i] = 0.
     * Return an integer array answer of size n where answer[i] = |leftSum[i] - rightSum[i]|.
     * 
     * Just build the leftSum and rightSum array
     * Calculate the result array with leftSum and rightSum
     * 
     * @param nums
     * @return
     */
    public int[] leftRightDifference(int[] nums) {
        int[] result = new int[nums.length];
        int[] leftSum = new int[nums.length];
        int[] rightSum = new int[nums.length];
        leftSum[0] = 0;
        rightSum[nums.length - 1] = 0;
        for (int i = 1; i < nums.length; i++) {
            leftSum[i] = leftSum[i - 1] + nums[i - 1];
        }
        for (int i = nums.length - 2; i >= 0; i--) {
            rightSum[i] = rightSum[i + 1] + nums[i + 1]; 
        }
        for (int i = 0; i < nums.length; i++) {
            result[i] = Math.abs(leftSum[i] - rightSum[i]);
        }
        return result;
    }   
}
