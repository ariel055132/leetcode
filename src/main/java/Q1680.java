public class Q1680 {
    /**
     * Optimized approach without bit manipulation:
     * Instead of building a huge string, process each number incrementally.
     * For each number i, calculate how many bits it has, then:
     * result = (result * 2^bitLength + i) % mod
     * 
     * This avoids string concatenation and BigInteger conversion overhead.
     * Time: O(n log n), Space: O(1)
     */
    public int concatenatedBinary(int n) {
        long result = 0;
        int mod = 1000000007;
        
        for (int i = 1; i <= n; i++) {
            // Get the number of bits in current number
            int bitLength = (int) (Math.log(i) / Math.log(2)) + 1;
            
            // Calculate 2^bitLength
            long power = 1;
            for (int j = 0; j < bitLength; j++) {
                power *= 2;
            }
            
            // Concatenate: multiply result by 2^bitLength and add i
            result = (result * power + i) % mod;
        }
        
        return (int) result;
    }

    /**
     *     public int concatenatedBinary(int n) {
        String str = "";
        int mod = 1000000007;
        for(int i=1; i<=n; i++){
            str+=Integer.toBinaryString(i);
            long val = Long.parseLong(str,2);
            val = val%mod;
            str = Long.toBinaryString(val);
        }
        return (int)Long.parseLong(str,2);
    }
     */


    /**
     * import java.math.BigInteger;

class Solution {
    public int concatenatedBinary(int n) {
                StringBuilder bin = new StringBuilder();
        int mod = 1000000007; 
        for (int i = 1; i <= n; i++) {
           bin.append(Integer.toBinaryString(i));
        }
        BigInteger integer = new BigInteger(bin.toString(), 2);
        integer = integer.mod(new BigInteger(String.valueOf(mod)));
        return integer.intValue();
    }
}
     */
}
