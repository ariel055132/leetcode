public class Q1009 {
    /**
     * The complement of an integer is the integer you get when you flip all the 0's to 1's and all the 1's to 0's in its binary representation.
     * For example, The integer 5 is "101" in binary and its complement is "010" which is the integer 2.
     * Given an integer n, return its complement.
     * 
     * @param n
     * @return
     */
    public int bitwiseComplement(int n) {
        int result = 0;
        // Convert n to binary form
        String binary = Integer.toBinaryString(n);
        StringBuilder sb = new StringBuilder();
        // Traverse the binary form of n, flip all the 0's to 1's and all the 1's to 0's 
        for (int i = 0; i < binary.length(); i++) {
            if (binary.charAt(i) == '0') {
                sb.append(1);
            } else {
                sb.append(0);
            }
        }
        String newBinary = sb.toString();
        // Convert the binary form to integer
        result = Integer.parseInt(newBinary, 2);
        return result;
    }
}
