public class Q3754 {
    /**
     * You are given an integer n.
     * Form a new integer x by concatenating all the non-zero digits of n in their original order. If there are no non-zero digits, x = 0.
     * Let sum be the sum of digits in x.
     * Return an integer representing the value of x * sum.
     * 
     * Simulate as the question stated.
     * 
     * @param n
     * @return
     */
    public long sumAndMultiply(int n) {
        StringBuilder sb = new StringBuilder();
        // Repeatedly calculate n % 10 to extract the last digit
        while (n != 0) {
            int digit = n % 10;
            // Append the digit if it is not zero
            if (digit != 0) sb.append(digit);
            // Remove the last digit 
            n /= 10;
        }
        // Reverse the collected digits to form x
        String str = sb.reverse().toString();
        // If no digits were collected, returned 0
        if (str.isBlank()) return 0;
        long x = (long) Integer.parseInt(str);
        long sum = 0L;
        // Calculate the digit sum
        for (int i = 0; i < str.length(); i++) {
            sum += (long) (str.charAt(i) - '0');
        }
        return x * sum;

    }
}
