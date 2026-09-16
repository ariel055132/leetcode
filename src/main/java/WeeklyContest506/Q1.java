package WeeklyContest506;

public class Q1 {
    /**
     * You are given a positive integer n.
     * Let digitSum be the sum of the digits of n, and let squareSum be the sum of the squares of the digits of n.
     * An integer is called good if squareSum - digitSum >= 50.
     * Return true if n is good. Otherwise, return false.
     * 
     * Simulate as the question stated.
     * 
     * 
     * @param n
     * @return
     */
    public boolean checkGoodInteger(int n) {
        int digitSum = 0;
        int squareSum = 0;
        while (n != 0) {
            int digit = n % 10;
            digitSum += digit;
            squareSum += digit * digit;
            n /= 10;
        }

        return squareSum - digitSum >= 50;
    }
}
