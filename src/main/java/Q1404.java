import java.math.BigInteger;

public class Q1404 {
    /**
     * Given the binary representation of an integer as a string s, return the number of steps to reduce it to 1 under the following rules:
     * If the current number is even, you have to divide it by 2.
     * If the current number is odd, you have to add 1 to it.
     * 
     * @param s String (Binary representation of an integer as String)
     * @return result int (the number of steps to reduce it to 1)
     */
    public int numSteps(String s) {
        int result = 0;
        // As the length of string may have 500, therefore using Int and Long will lead to overflow.
        // BigInteger need to be used.
        BigInteger decimal = new BigInteger(s, 2);
        while (!decimal.equals(BigInteger.ONE)) {
            // If the current number is even, divide it by 2
            if (decimal.mod(BigInteger.TWO).equals(BigInteger.ZERO)) {
                decimal = decimal.divide(BigInteger.TWO);
                result++;
            } 
            else {
                // Else, add one to the Big Integer
                decimal = decimal.add(BigInteger.ONE);
                result++;
            }
        }

        return result;
    }
}
