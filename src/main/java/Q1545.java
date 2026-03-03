public class Q1545 {
    /**
     * Given two positive integers n and k, the binary string Sn is formed as follows:
     * 1. S1 = "0"
     * 2. Si = (Si - 1) + "1" + reverse(invert(Si - 1)) for i > 1
     * Where + denotes the concatenation operation, reverse(x) returns the reversed string x, and invert(x) inverts all the bits in x (0 changes to 1 and 1 changes to 0).
     * Return the kth bit in Sn.
     * It's guaranteed that k is valid for the given n.
     * 
     * Constraints range:
     * 1 <= n <= 20
     * 1 <= k <= 2^n - 1
     * 
     * Brute Force as range of n is small (20)
     * 1. Generate the sequence with n.
     * 2. Once the sequence completes, return the k-1 th (0-indexed) charactered of the string
     * 
     * @param n
     * @param k
     * @return
     */
    public char findKthBit(int n, int k) {
        StringBuilder sb = new StringBuilder();
        // 1. Rule: S1 = "0"
        sb.append("0"); 
        for (int i = 1; i < n; i++) {
            // 2. Rule:  Si = (Si - 1) + "1" + reverse(invert(Si - 1)) for i > 1
            // -> Si = (Si - 1) + "1"
            sb.append('1');
            // Do the reverse for i > 1
            for (int j = sb.length() - 2; j >= 0; j--) {
                char invertedBit = sb.charAt(j) == '1' ? '0' : '1';
                sb.append(invertedBit);
            }
        }
        String result = sb.toString();
        return result.charAt(k-1);
    }
    
}
