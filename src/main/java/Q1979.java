public class Q1979 {
    /**
     * Given an integer array nums, return the greatest common divisor of the smallest number and largest number in nums.
     * The greatest common divisor of two numbers is the largest positive integer that evenly divides both numbers.
     * 
     * 1. Find out the largest positive integer and smallest positive integer in array nums.
     * 2. Calculate the GCD for the numbers above.
     * @param nums
     * @return
     */
    public int findGCD(int[] nums) {
        int smallestNumber = Integer.MAX_VALUE;
        int largestNumber = Integer.MIN_VALUE;
        for (int num : nums) {
            smallestNumber = Math.min(num, smallestNumber);
            largestNumber = Math.max(num, largestNumber);
        }
        return gcd(smallestNumber, largestNumber);
    }

    public int gcd(int x, int y) {
        if (y == 0) return x;
        return gcd(y, x % y);
    }
}
