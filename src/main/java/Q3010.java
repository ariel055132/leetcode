import java.util.Arrays;

/**
 * You are given an array of integers nums of length n.
 * The cost of an array is the value of its first element.
 * For example, the cost of [1, 2, 3] is 1 while
 */

public class Q3010 {
    /**
     *
     * @param nums
     * @return
     */
    public int minimumCost(int[] nums) {
        int[] sortedWithoutFirstElement = sortWithIndex1(nums);
        return sortedWithoutFirstElement[0] + sortedWithoutFirstElement[1] + sortedWithoutFirstElement[2];
    }

    public int[] sortWithIndex1(int[] nums) {
        int firstElement = nums[0];
        int[] subArray = Arrays.copyOfRange(nums, 1, nums.length);
        Arrays.sort(subArray);
        int[] result = new int[nums.length];
        result[0] = firstElement;
        System.arraycopy(subArray, 0, result, 1, subArray.length);
        return result;
    }

}
