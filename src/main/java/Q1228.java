public class Q1228 {
    /**
     * In some array arr, the values were in arithmetic progression: 
     * the values arr[i + 1] - arr[i] are all equal for every 0 <= i < arr.length - 1.
     * 
     * A value from arr was removed that was not the first or last value in the array.
     * Given arr, return the removed value.
     * 
     * Key Insights:
     * With one missing term, the first and last values are still correct.
     * Therefore, the common difference is (array[lastIndex] - arr[0]) / array.length (aka. n)
     * Walk the sequence from array[0] in steps of difference
     * The first position where the array value does not match the expected term is where the gap is 
     * the missing number is that expected value.
     * 
     * Note: divide by current length of the array, but not current length - 1.
     * Because the full sequence had n + 1 terms.
     *  
     * @param arr int[]
     * @return expect int (removed value)
     */
    public int missingNumber(int[] arr) {
        int difference = (arr[arr.length - 1] - arr[0]) / arr.length;
        int expect = arr[0];
        for (int val : arr) {
            // Found the missing number, just return it
            if (val != expect) return expect;
            expect += difference;
        }
        // If the loop finishes (all equal steps, d == 0), return expect (or arr[0])
        return expect;
    }
}
