import java.util.HashMap;
import java.util.Map;

public class Q2260 {
    /**
     * You are given an integer array cards where cards[i] represents the value of the ith card. A pair of cards are matching if the cards have the same value.
     * Return the minimum number of consecutive cards you have to pick up to have a pair of matching cards among the picked cards. If it is impossible to have matching cards, return -1.
     *
     * @param cards int[]
     * @return result int
     */
    public int minimumCardPickUp(int[] cards) {
        int result = Integer.MAX_VALUE;
        // Key: Value of the card; Value index of the card
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < cards.length; i++) {
            // Add the card to the map if map does not contain that card
            if (map.get(cards[i]) == null) {
                map.put(cards[i], i);
            } else {
                // If same card is found, update the result
                result = Math.min(i, i - map.get(cards[i]) + 1);
                // Update the position of the cards
                map.put(cards[i], i);
            }
        }
        // If results still remains Integer.MAX_VALUE, means that no cards have the same value in array, therefore return -1.
        // Otherwise, return the updated result
        return result == Integer.MAX_VALUE ? -1 : result;
    }
}
