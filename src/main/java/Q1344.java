public class Q1344 {
    /**
     * Given two numbers, hour and minutes, return the smaller angle (in degrees) formed between the hour and the minute hand.
     * Answers within 10-5 of the actual value will be accepted as correct.
     * 
     * 1 hour angle change = 360 / 12 = 30
     * 1 minute angle change = 360 / 60 = 6
     * 
     * 1. Convert the minute hand position to degrees
     *    -> minuteAngle = minutes * 6
     * 2. Convert the hour hand position to degrees
     *    -> Each hour is 30 degrees
     *    -> Each minute also moves the hour hand by 0.5 degrees
     *    -> hourAngle = (hour % 12) * 30 + minute * 0.5
     * 3. Compute the absolute difference
     *    -> diff = Math.abs(minuteAngle - hourAngle)
     * 4. Return the smaller angle
     *    -> Math.min(diff, 360 - diff)
     * Note: 0.5 degrees -> 30 / 60 (1:00 -> 2:00 is 30 with 60 minutes, each minute move hour hand by 0.5 degrees)
     * 
     * @param hour
     * @param minutes
     * @return
     */
    public double angleClock(int hour, int minutes) {
        int hourConstantAngle = 30;
        int minuteConstantAngle = 6;
        double minuteAngle = minuteConstantAngle * minutes;
        double hourAngle = hour % 12 * hourConstantAngle + 0.5 * minutes;
        double diff = Math.abs(minuteAngle - hourAngle);
        return Math.min(diff, 360 - diff);
    }
}
