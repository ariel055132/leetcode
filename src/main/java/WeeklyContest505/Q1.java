package WeeklyContest505;

public class Q1 {
    /**
     * You are given two integers n and k.
     * A positive integer x is called compatible if it satisfies both of the following conditions:
     * abs(n - x) <= k
     * (n & x) == 0
     * Return the sum of all compatible integers x.
     * 
     * @param n
     * @param k
     * @return
     */
    public int sumOfGoodIntegers(int n, int k) {
        // x must be at least n - k, but also at least 1 because it must be positive. Taking the maximum enforces both requirements.
        int left = Math.max(1, n - k);
        // the largest number within distance k of n. Anything larger is too far away.
        int right = n + k;
        int result = 0;
        
        // check each integer in the interval, and add it only when (n & x) == 0.
        for (int x = left; x <= right; x++) {
            if ((n & x) == 0) {
                result += x;
            }
        }

        return result;
    }
}
