package PrefixSum;

public class Q303 {
    private int[] data;
    public Q303(int[] nums) {
        data = nums;
    }

    public int sumRange(int left, int right) {
        int result = 0;
        for (int i = left; i <= right; i++) {
            result += data[i];
        }
        return result;
    }
}
