public class Q788 {
    /**
     * An integer x is a good if after rotating each digit individually by 180 degrees, we get a valid number that is different from x. 
     * Each digit must be rotated - we cannot choose to leave it alone.
     * 
     * A number is valid if each digit remains a digit after rotation. For example:
     * 0, 1, and 8 rotate to themselves (valid & unchanged)
     * 2 and 5 rotate to each other (valid & change to another digit)
     * 6 and 9 rotate to each other (valid & change to another digit)
     * the rest of the numbers (3, 4, 7) do not rotate to any other number and become invalid.
     * 
     * A number is good iff:
     * 1. It contains no invalid digit (3, 4, 7) and
     * 2. It contains at least one changing digit (2, 5, 6, 9)
     * As 0,1,8 do not make the number good by themselves
     * @param n
     * @return
     */
    public int rotatedDigits(int n) {
        // Initialize answer result = 0
        int result = 0;
        for (int i = 1; i <= n; i++) {
            boolean goodNumber = false;
            int tmp = i;
            while (tmp > 1) {
                // check all the digits of numbers
                int d = tmp % 10;
                // 3, 4, 7 are invalid after invalid 
                if (d == 3 || d == 4 || d == 7) {
                    goodNumber = false; 
                    break;
                } 
                // 2,5,6,9 -> valid and also changed the number
                if (d == 2 || d == 5 || d == 6 || d == 9) goodNumber = true;
                tmp /= 10;
            }
            if (goodNumber) result++;
        } 
        return result;
    }
}


