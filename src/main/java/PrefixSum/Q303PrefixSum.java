package PrefixSum;

public class Q303PrefixSum {
    private int[] data;
    public Q303PrefixSum(int[] nums) {
        data = new int[nums.length + 1];
        for (int i = 0; i < nums.length; i++) {
            data[i + 1] = data[i] + nums[i];
        }
    }

    public int sumRange(int left, int right) {
        return data[right + 1] - data[left];
    }
}
