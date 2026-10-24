package StringAlgorithms;


public class Q2409 {
    /**
     * Alice and Bob are traveling to Rome for separate business meetings.
     * You are given 4 strings arriveAlice, leaveAlice, arriveBob, and leaveBob. Alice will be in the city from the dates arriveAlice to leaveAlice (inclusive), while Bob will be in the city from the dates arriveBob to leaveBob (inclusive). Each will be a 5-character string in the format "MM-DD", corresponding to the month and day of the date.
     * Return the total number of days that Alice and Bob are in Rome together.
     * You can assume that all dates occur in the same calendar year, which is not a leap year. Note that the number of days per month can be represented as: [31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31].
     *
     * By observing the example, we can conclude as follows:
     * Max(arriveAlice, arriveBob) - Min(leaveAlice, leaveBob) + 1
     * However, comparing month/day pairs directly is awkward.
     * Therefore, we need to convert each date into a day-of-year number.
     * Then, each person's stay is just a range of integers, so that we can use the formula
     *
     * @param arriveAlice
     * @param leaveAlice
     * @param arriveBob
     * @param leaveBob
     * @return
     */
    public int countDaysTogether(String arriveAlice, String leaveAlice, String arriveBob, String leaveBob) {
        int[] month = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        int[] prefixMonth = new int[month.length + 1];
        for (int i = 0; i < month.length; i++) {
            prefixMonth[i + 1] = month[i] + prefixMonth[i];
        }
        int arriveAliceDays = calculateDays(arriveAlice, prefixMonth);
        int leaveAliceDays = calculateDays(leaveAlice, prefixMonth);
        int arriveBobDays = calculateDays(arriveBob, prefixMonth);
        int leaveBobDays = calculateDays(leaveBob, prefixMonth);



        return Math.max(0, Math.min(leaveAliceDays, leaveBobDays) - Math.max(arriveAliceDays, arriveBobDays) + 1);
    }

    private int calculateDays(String date, int[] prefixMonth) {
        int month = Integer.parseInt(date.substring(0, 2));
        int day = Integer.parseInt(date.substring(3));
        return prefixMonth[month - 1] + day;
    }
}
