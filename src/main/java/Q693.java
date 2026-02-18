public class Q693 {
    /**
     * Given a positive integer, check whether it has alternating bits: namely, if two adjacent bits will always have different values.
     * 
     * @param n integer
     * @return result
     */
    public boolean hasAlternatingBits(int n) {
        // 1. Convert the integer to binary form
        String binaryString = Integer.toBinaryString(n);
        // 2. Traverse the binary form string to find out whether it has alternating bits
        for (int i = 1; i < binaryString.length(); i++) {
            if (binaryString.charAt(i - 1) == binaryString.charAt(i)) {
                return false;
            }
        }
        return true;
    }
}
