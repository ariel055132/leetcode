package TwoPointers;

import java.util.Arrays;

public class Q948 {
    public int bagOfTokensScore(int[] tokens, int power) {
        Arrays.sort(tokens);
        int result = 0;
        int rs = 0;
        int left = 0;
        int right = tokens.length - 1;
        while (left <= right) {
            if (power >= tokens[left]) {
                power -= tokens[left];
                rs++;
                result = Math.max(rs, result);
                left++;
            } else if (result > 0) {
                power += tokens[right];
                right--;
                rs--;
            } else {
                break;
            }
        }
        return result;
    }
}
