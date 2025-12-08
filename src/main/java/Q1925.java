public class Q1925 {
     /**
     * A square triple (a,b,c) is a triple where a, b, and c are integers and a^2 + b^2 = c^2
     * Given an integer n, return the number of square triples such that 1 <= a, b, c <= n.
      *
      * Iterate through all possible values of a and b from 1 to n
      * For each pair, calculate c = Sqrt(a^2+b^2)
      * Count the triple if c is an integer and c <= n
     *
     * @param n
     * @return
     */
    public int countTriples(int n) {
        int result = 0;
        for (int a = 1; a <= n; a++) {
            for (int b = 1; b <= n; b++) {
                int c = (int) Math.sqrt(a*a + b*b);
                if (c <= n && (c*c == a*a + b*b)) result++;
            }
        }

        return result;
    }
}
