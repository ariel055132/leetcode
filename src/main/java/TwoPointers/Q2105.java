package TwoPointers;

public class Q2105 {
    public int minimumRefill(int[] plants, int capacityA, int capacityB) {
        int result = 0;
        int left = 0;
        int right = plants.length - 1;
        int cA = capacityA;
        int cB = capacityB;
        // Traverse the array with left and right pointers (simulate watering from Alice and Bob)
        while (left < right) {
            // Alice does not have enough water for watering plants, need to refill, result++
            if (plants[left] > cA) {
                cA = capacityA;
                result++;
            }
            // Bob does not have enough water for watering plants, need to refill, result++
            if (plants[right] > cB) {
                cB = capacityB;
                result++;
            }
            cA -= plants[left];
            cB -= plants[right];
            left++;
            right--;
        }

        if (left == right && cA < plants[left] && cB <plants[right]) result++;
        return result;
    }
}
