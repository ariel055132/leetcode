public class Q66 {
    /**
     * You are given a large integer represented as an integer array digits, where each digits[i] is the ith digit of the integer. The digits are ordered from most significant to least significant in left-to-right order. The large integer does not contain any leading 0's.
     * Increment the large integer by one and return the resulting array of digits.
     */
    public int[] plusOne(int[] digits) {
        // Traverse the array from the last to the front for simulating addition
        for (int i = digits.length - 1; i >= 0; i--) {
            // If the last digit is less than 9, just do the addition and return the result
            if (digits[i] < 9) {
                digits[i]++;
                return digits;
            } else if (digits[i] == 9) {
                // If the last digit is 9, need to turn it as 0
                digits[i] = 0;
            }
        }
        // Dealing the situation of array is all of 9
        // As the initialization of array in java is always be 0
        // that's why we need to turn the first element of array to 1
        digits = new int[digits.length + 1];
        digits[0] = 1;

        return digits;
    }
}
