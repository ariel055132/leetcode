package Blind75;

import java.util.Arrays;

public class Q253 {
    /**
     * Given an array of meeting time intervals intervals where intervals[i] = [starti, endi], return the minimum number of conference rooms required.
     *
     * Process meetings in start-time order, reusing an available room whenever possible
     *
     * @param intervals
     * @return
     */
    public int minMeetingRooms(int[][] intervals) {
        int result = 0;
        if (intervals.length == 0) {
            return result;
        }
        int[] start = new int[intervals.length];
        int[] end = new int[intervals.length];
        int startIndex = 0;
        int endIndex = 0;
        for (int i = 0; i < intervals.length; i++) {
            start[i] = intervals[i][0];
            end[i] = intervals[i][1];
        }
        Arrays.sort(start);
        Arrays.sort(end);
        /**
         * start[startIndex]: the next meeting's start time.
         * end[endIndex]: the earliest ending that has not yet been used to justify reusing a room
         * result: the number of rooms allocated so far
         */
        while (startIndex < intervals.length) {
            // For each start time, check whether an unused ending is at or before it.
            // If so, reuse that room and advance endIndex
            if (start[startIndex] >= end[endIndex]) {
                endIndex++;
            } else {
                // Otherwise, allocate another room
                result++;
            }
            startIndex++;
        }

        return result;
    }
}
