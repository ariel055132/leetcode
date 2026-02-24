import java.util.Set;

public class Q762 {
    /**
     * Given two integers left and right, return the count of numbers in the inclusive range [left, right] having a prime number of set bits in their binary representation.
     * 
     * @param left
     * @param right
     * @return
     */
    public int countPrimeSetBits(int left, int right) {
        // Primes set for checking primes in O(1) 
        Set<Integer> primes = Set.of(2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31);
        int result = 0;
        // Inclusive range -> left <= right
        for (int index = left; index <= right; index++) {
            // Get the number of 1 in binary integer
            int setBit = Integer.bitCount(index);
            // Determine whether the number of 1 is in primes set
            // If yes, result ++
            if (primes.contains(setBit)) result++;
        }
        return result;
    }

    public boolean checkPrimes(int number) {
        if (number <= 1) return false;
        for (int i = 2; i * i <= number; i++) {
            if (number % i == 0) return false;
        }
        return true;
    }
}
