package Blind75;

public class Q121 {
    public int maxProfit(int[] prices) {
        int left = 0;
        int result = 0;

        for (int right = 0; right < prices.length; right++) {
            // Calculate the current Profit
            int currentProfit = prices[right] - prices[left];
            // If the price of left index > right index, should do the exchange, otherwise no profit can be found
            if (prices[left] > prices[right]) {
                left = right;
            }
            result = Math.max(result, currentProfit);
        }
        return result;
    }
}
