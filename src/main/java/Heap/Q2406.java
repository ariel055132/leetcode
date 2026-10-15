package Heap;

import java.util.Arrays;
import java.util.PriorityQueue;

public class Q2406 {
    /**
     * You are given a 2D integer array intervals where intervals[i] = [lefti, righti] represents the inclusive interval [lefti, righti].
     * You have to divide the intervals into one or more groups such that each interval is in exactly one group, and no two intervals that are in the same group intersect each other.
     * Return the minimum number of groups you need to make.
     * Two intervals intersect if there is at least one common number between them. For example, the intervals [1, 5] and [5, 8] intersect.
     *
     * Process intervals in start time order, reuse an existing group whenever possible
     * Use min-heap stores one end time per-group the end of the last interval assigned to that group
     *
     * For current interval [start, end], 2 cases:
     * pq.peek() < start: that group can accept the interval. Remove its previous end, then insert the current end.
     * pq.peek() >= start: even the earliest-ending group overlaps the current interval. Every existing group is unavailable, create another group
     *
     * @param intervals
     * @return
     */
    public int minGroups(int[][] intervals) {
        // Sort intervals by their start values
        Arrays.sort(intervals, (a,b) -> Integer.compare(a[0], b[0]));
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int [] interval : intervals) {
            // If a group can be reused, remove its old end
            if (!pq.isEmpty() && pq.peek() < interval[0]) {
                pq.poll();
            }
            // Always insert the current's interval's end
            pq.add(interval[1]);
        }
        return pq.size();
    }
}
