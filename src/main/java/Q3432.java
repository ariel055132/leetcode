public class Q3432 {
    public int countPartitions(int[] nums) {
        int result = 0;

        int leftSum = 0;
        int rightSum = 0;
        for (int i = 0; i < nums.length; i++) {
            rightSum += nums[i];
        }

        for (int i = 0; i < nums.length -1; i++) {
            leftSum += nums[i];
            rightSum -= nums[i];

            if ((rightSum - leftSum) % 2 == 0) {
                result++;
            }
        }

        return result;
    }
}
