public class Q3479 {
    public int numOfUnplacedFruits(int[] fruits, int[] baskets) {
        int result = 0;
        for (int fruit : fruits) {
            boolean placed = false;
            for (int i = 0; i < baskets.length; i++) {
                if (fruit <= baskets[i]) {
                    baskets[i] = 0;
                    placed = true;
                    break;
                }
            }
            if (!placed) {
                result++;
            }
        }

        return result;
    }
}
