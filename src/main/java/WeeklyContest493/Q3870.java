package WeeklyContest493;

public class Q3870 {
    /**
     * 
     * Constraints
     * 0 <= n <= 10^5 (100000)
     * 100,000 (only one commas will be used)
     * 
     * @param n
     * @return
     */
    public int countCommas(int n) {
        if (n < 1000) {
            return 0;
        } 
        return n - 999;
    }
    
}
