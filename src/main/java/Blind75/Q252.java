package Blind75;

import java.util.Arrays;

public class Q252 {
    /**
     * You are given an array of meeting times intervals where intervals[i] = [starti, endi].
     * A person can attend all meetings if no two meeting intervals overlap. Meetings ending at time t and starting at time t do not overlap.
     * Return true if a person can attend all meetings. Otherwise, return false.
     *
     * Sort array (meetings) by start time, then compare neighboring meetings.
     * After sorting, if every meeting ends before or when the next one starts, all meetings can be attended
     *
     * @param intervals
     * @return
     */
    public boolean canAttendMeetings(int[][] intervals) {
        // Sort intervals by each meeting's start time (ascending order)
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));
        // Starting at index 1, compare the current start with the previous end. Return false if they overlap
        for (int i = 1; i < intervals.length; i++) {
            // Use > rather than >=
            if (intervals[i-1][1] > intervals[i][0]) {
                return false;
            }
        }
        // Return true if every comparison passes
        return true;
    }
}
