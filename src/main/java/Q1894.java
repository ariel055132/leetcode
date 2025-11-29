public class Q1894 {
    public int chalkReplacer(int[] chalk, int k) {
        // Step 1: Calculate the total chalk needed for one complete round
        // This represents the sum of chalk all students use in one full cycle
        long chalkSum = 0;
        for (int ch : chalk) {
            chalkSum += ch;
        }

        // Step 2: Skip complete rounds using modulo operation
        // After k % chalkSum, we only need to handle the remaining chalk
        // This optimization reduces time complexity from O(k) to O(n)
        k %= chalkSum;

        // Step 3: Simulate the final incomplete round to find who runs out
        // Iterate through students and subtract their chalk usage
        for (int i = 0; i < chalk.length; i++) {
            k -= chalk[i];

            // If remaining chalk becomes negative, current student needs to replace it
            // This student cannot complete their turn with the available chalk
            if (k < 0) {
                return i;
            }
        }

        // Edge case: If we complete the loop without running out,
        // the first student (index 0) will need to replace chalk
        // (though mathematically this shouldn't happen after modulo operation)
        return 0;
    }
}
