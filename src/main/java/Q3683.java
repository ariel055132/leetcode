public class Q3683 {
    /**
     * You are given a 2D integer array tasks where tasks[i] = [si, ti].
     * Each [si, ti] in tasks represents a task with start time si that takes ti units of time to finish.
     * Return the earliest time at which at least one task is finished.
     *
     * Traverse array
     * Add the start time and finished time of each elements
     * Use Math.min to find the minimum time for the task is finished.
     *
     * @param tasks
     * @return
     */
    public int earliestTime(int[][] tasks) {
        int result = Integer.MAX_VALUE;
        for (int i = 0; i < tasks.length; i++) {
            int start = tasks[i][0];
            int end = tasks[i][1];
            result = Math.min(result, start + end);
        }
        return result;
    }
}
