import java.util.Arrays;

public class Q1874 {
    /**
     * The product sum of two equal-length arrays a and b is equal to the sum of a[i] * b[i] for all 0 <= i < a.length (0-indexed).
     *
     * Smallest from nums1 with largest from nums2
     * Second-smallest with second-largest
     * etc.
     * For preventing the products from growing too large.
     * @param nums1 int[]
     * @param nums2 int[]
     * @return smallest product sum int
     */
    public int minProductSum(int[] nums1, int[] nums2) {
        int result = 0;
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        for (int i = 0, j = nums2.length - 1; i < j; i++, j--) {
            int tmp = nums2[i];
            nums2[i] = nums2[j];
            nums2[j] = tmp;
        }
        for (int i = 0; i < nums1.length; i++) {
            result += nums1[i] * nums2[i];
        }
        return result;
    }
}
