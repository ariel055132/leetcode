public class Q1732 {
    /**
     * There is a biker going on a road trip. The road trip consists of n + 1 points at various altitudes. The biker starts his trip on point 0 with altitude equal 0.
     * You are given an integer array gain of length n where gain[i] is the net gain in altitude between points i​​​​​​ and i + 1 for all (0 <= i < n). Return the highest altitude of a point.
     * 
     * Traverse the array, calculate the altitude, compare the current altitude with result
     * 
     * @param gain
     * @return
     */
    public int largestAltitude(int[] gain) {
        int result = 0;
        int tmp = 0;
        for (int g : gain) {
            tmp += g;
            result = Math.max(result, tmp);
        }
        return result;
    }
}
