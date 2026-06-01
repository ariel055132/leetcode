import java.util.Arrays;

public class Q2144 {
    /**
     * A shop is selling candies at a discount. For every two candies sold, the shop gives a third candy for free.
     * The customer can choose any candy to take away for free as long as the cost of the chosen candy is less than or equal to the minimum cost of the two candies bought.
     * For example, if there are 4 candies with costs 1, 2, 3, and 4, and the customer buys candies with costs 2 and 3, they can take the candy with cost 1 for free, but not the candy with cost 4.
     * Given a 0-indexed integer array cost, where cost[i] denotes the cost of the ith candy, return the minimum cost of buying all the candies.
     * 
     * To maximize saving, make the cheapest candy in each triple free. (For example {6, 7, 9} -> Buy 7, 9, get 6 free)
     * Sort array in ascending order, process from largest to smallest, and in each of three consecutive picks from that order:
     * pay for the first two most expensive, skip the cheapest
     * @param cost
     * @return
     */
    public int minimumCost(int[] cost) {
        int result = 0;
        Arrays.sort(cost);
        int count = 0;
        for (int i = cost.length - 1; i >= 0; i--) {
            if (count != 2) {
                result += cost[i];
                count++;
            } else {
                count = 0;
            }
        }
        return result;
    }
}
