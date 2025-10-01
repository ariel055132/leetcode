public class Q1518 {
    public int numWaterBottles(int numBottles, int numExchange) {
        int maximumBottles = numBottles; // maximumBottles at least equal to numBottles
        while (numBottles >= numExchange) {
            int remainder = numBottles % numExchange; // As numBottles may not divisible by numExchange, we need to save the remainder for future exchange
            numBottles /= numExchange; // the bottles after exchange
            maximumBottles += numBottles; // add the bottles after exchange to result
            numBottles += remainder; // numBottles + remainder
        }
        return maximumBottles;
    }
}
