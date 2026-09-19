package WeeklyContest506;

public class Q3 {
    /**
     * You are given a 2D integer array units of size m × n where units[i][j] represents the capacity of the jth unit in the ith device. Each device contains exactly n units.
     * The rating of a device is the minimum capacity among all its units.
     * You may perform the following operation any number of times (including zero):
     * Choose a device i that has not been used as a source before.
     * Remove exactly one unit from device i and add it to any different device.
     * Then mark device i as used, so it cannot be chosen again as a source.
     * Return the maximum possible sum of the ratings of all devices after any number of such operations.
     * 
     * Note:
     * Devices can receive units from multiple devices, regardless of whether they have been selected.
     * The rating of an empty device is 0.
     * @param units
     * @return
     */

    public long maxRatingSum(int[][] units) {
        int n = units[0].length;

        if (n == 1) {
            long sum = 0;
            for (int[] device : units) {
                sum += device[0];
            }
            return sum;
        }

        long secondMinSum = 0;
        int globalMin = Integer.MAX_VALUE;
        int smallestSecondMin = Integer.MAX_VALUE;

        for (int[] device : units) {
            int min1 = Integer.MAX_VALUE;
            int min2 = Integer.MAX_VALUE;

            for (int x : device) {
                if (x < min1) {
                    // The previous minimum becomes second-smallest.
                    min2 = min1;
                    min1 = x;
                } else if (x < min2) {
                    // x can be second-smallest, including a duplicate minimum.
                    min2 = x;
                }
            }

            globalMin = Math.min(globalMin, min1);
            secondMinSum += min2;
            smallestSecondMin = Math.min(smallestSecondMin, min2);
        }

        return secondMinSum - smallestSecondMin + globalMin;
    }
}
