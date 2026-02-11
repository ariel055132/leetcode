public class Q3427 {
    public int subarraySum(int[] nums) {
        int result = 0;
        int n = nums.length;
        int[] prefixSum = new int[n + 1];
        prefixSum[0] = 0;
        for (int i = 0; i < n; i++) {
            prefixSum[i+1] = prefixSum[i] + nums[i];
            int start = Math.max(0, i - nums[i]);
            result += prefixSum[i+1] - prefixSum[start];
        }

        return result;
    }
}
