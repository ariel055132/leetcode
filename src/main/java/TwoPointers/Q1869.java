package TwoPointers;

public class Q1869 {
    public boolean checkZeroOnes(String s) {
        int n = s.length();
        int i = 0;
        int r0 = 0; int r1 = 0;
        while (i < n) {
            int start = i;
            i++;
            while (i < n && s.charAt(i) == s.charAt(i - 1)) {
                i++;
            }
            if (s.charAt(i - 1) == '0') {
                r0 = Math.max(r0, i - start);
            } else {
                r1 = Math.max(r1, i - start);
            }
        }
        return r1 > r0;
    }
}
