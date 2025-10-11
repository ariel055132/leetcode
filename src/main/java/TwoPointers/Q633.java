package TwoPointers;

public class Q633 {
    /**
     * Given a non-negative integer c, decide whether there are two integers a and b such that a2 + b2 = c.
     *
     * @param c int (non-negative integer)
     * @return boolean
     */
    public boolean judgeSquareSum(int c) {
        int left = 0;
        int right = c;
        while (left < right) {
            int currentSum = left * left + right * right;
            if (currentSum == c) {
                return true;
            } else if (currentSum < c) {
                left++;
            } else {
                right--;
            }
        }
        return false;
    }
}
