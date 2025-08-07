public class Q3477 {
    public int numOfUnplacedFruits(int[] fruits, int[] baskets) {
        int result = fruits.length;
        for (int i = 0; i < fruits.length; i++) {
            for (int j = 0; j < baskets.length; j++) {
                if (fruits[i] <= baskets[j]) {
                    result--; // A fruit can be placed in a basket
                    baskets[j] = 0; // Mark the basket as used
                    break; // Exit the inner loop once a basket is found
                }
            }
        }
        return result;
    }
}
