package WeeklyContest493;

public class Q3871 {
    public long countCommas(long n) {
        long result = 0;
        long times1000 = 1000;
        while (times1000 <= n) {
            result += n - times1000;
            times1000 *= 1000;
        }
        return result;
    }
}
