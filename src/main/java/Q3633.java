public class Q3633 {
    /**
     * You are given two categories of theme park attractions: land rides and water rides.
     * Land rides
     * 1. landStartTime[i] – the earliest time the ith land ride can be boarded.
     * 2. landDuration[i] – how long the ith land ride lasts.
     * 
     * Water rides
     * 1. waterStartTime[j] – the earliest time the jth water ride can be boarded.
     * 2. waterDuration[j] – how long the jth water ride lasts.
     * 
     * A tourist must experience exactly one ride from each category, in either order.
     * A ride may be started at its opening time or any later moment.
     * If a ride is started at time t, it finishes at time t + duration.
     * Immediately after finishing one ride the tourist may board the other (if it is already open) or wait until it opens.
     * Return the earliest possible time at which the tourist can finish both rides
     * 
     * @param landStartTime
     * @param landDuration
     * @param waterStartTime
     * @param waterDuration
     * @return
     */
    public int earliestFinishTime(int[] landStartTime, int[] landDuration, int[] waterStartTime, int[] waterDuration) {
        int result = Integer.MAX_VALUE;
        int minLandDuration = Integer.MAX_VALUE;
        int minWaterDuration = Integer.MAX_VALUE;

        for (int i = 0; i < landDuration.length; i++) {
            minLandDuration = Math.min(minLandDuration, landStartTime[i] + landDuration[i]);
        }

        for (int i = 0; i < waterDuration.length; i++) {
            minWaterDuration = Math.min(minWaterDuration, waterStartTime[i] + waterDuration[i]);
            // land first, then water side
            result = Math.min(result, Math.max(minLandDuration, waterStartTime[i]) + waterDuration[i]);
        }

        for (int i = 0; i < landDuration.length; i++) {
            // Water first, then land side
            result = Math.min(result, Math.max(minWaterDuration, landStartTime[i]) + landDuration[i]);
        }

        return result;
    }
}
