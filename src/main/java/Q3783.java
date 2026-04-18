public class Q3783 {
    /**
     * You are given an integer n.
     * Define its mirror distance as: abs(n - reverse(n))​​​​​​​ where reverse(n) is the integer formed by reversing the digits of n.
     * Return an integer denoting the mirror distance of n​​​​​​​.
     * abs(x) denotes the absolute value of x.
     * 
     * @param n int
     * @return
     */
    public int mirrorDistance(int n) {
        StringBuilder sb = new StringBuilder();
        sb.append(String.valueOf(n));
        sb.reverse();
        String strN = sb.toString();
        int reverseN = Integer.parseInt(strN);
        return Math.abs(n - reverseN);
    }

}
