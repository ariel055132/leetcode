package Quests;

public class Q2 {
    /**
     * Given the array nums consisting of 2n elements in the form [x1,x2,...,xn,y1,y2,...,yn].
     *
     * Return the array in the form [x1,y1,x2,y2,...,xn,yn].
     *
     * Just observe, can find out that the index of x1, x2, ... will be even number
     * and the index of y1, y2, ... will be odd number
     *
     * @param nums int[]
     * @param n int
     * @return int[]
     */
    public int[] shuffle(int[] nums, int n) {
        int[] result = new int[2 * n];
        for (int i = 0; i < n; i++) {
            result[2 * i] = nums[i]; // x1, x2, x....
            result[2 * i + 1] = nums[i + n]; // y1, y2, y....
        }
        return result;
    }
}
