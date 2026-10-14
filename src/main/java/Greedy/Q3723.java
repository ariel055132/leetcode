package Greedy;

public class Q3723 {
    /**
     * You are given two positive integers num and sum.
     * A positive integer n is good if it satisfies both of the following:
     * The number of digits in n is exactly num.
     * The sum of digits in n is exactly sum.
     * The score of a good integer n is the sum of the squares of digits in n.
     * Return a string denoting the good integer n that achieves the maximum score.
     * If there are multiple possible integers, return the maximum one.
     * If no such integer exists, return an empty string.
     *
     * For a fixed digit sum, concentrating the sum into larger digits increases the score.
     * For example, 9^2 + 0^2 = 81 is greater than 5^2 + 4^2 = 41,
     * even though both pairs contain two digits with a total sum of 9.
     *
     * More generally, for digits {@code a >= b}, moving one unit from b to a
     * increases the score by {@code 2 * (a - b) + 2}, which is positive.
     * This move is valid while {@code a < 9} and {@code b > 0}.
     *
     * Therefore, use as many 9s as possible, followed by any remaining nonzero digit,
     * then fill the remaining positions with zeros. Place larger digits first to obtain
     * the largest number among those with the same maximum score.
     * For example, both 89 and 98 score 145, but 98 is larger (Example 2).
     *
     * The maximum digit sum of a num-digit number is {@code 9 * num}.
     * If sum exceeds this limit, no solution exists, so return an empty string immediately.
     * For example, one digit cannot have a sum of 10 (Example 3).
     *
     * @param num
     * @param sum
     * @return
     */
    public String maxSumOfSquares(int num, int sum) {
        // If sum > 9 * num, return ""; even filling every position with 9 cannot reach the required sum (Example 3)
        if (num * 9 < sum) return "";
        StringBuilder sb = new StringBuilder();
        while (num > 0) {
            // Choose digit = Math.min(9, sum) for the next position
            int digit = Math.min(9, sum);
            // Append that digit and subtract it from the remaining sum
            sb.append(digit);
            sum -= digit;
            // Repeat until all num positions are filled. Once sum becomes 0, append zeros
            num--;
        }
        if (sum == 0) {
            return sb.toString();
        }
        return "";
    }
}
