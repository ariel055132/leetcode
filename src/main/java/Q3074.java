import java.util.Arrays;

public class Q3074 {
    public int minimumBoxes(int[] apple, int[] capacity) {
        int result = 0;
        int appleSum = Arrays.stream(apple).sum();
        Arrays.sort(capacity);
        // In order to use minimum boxes to do tha apple distribution, we need to use the greatest capacity of boxes first, and so on
        for (int i = 0, j = capacity.length - 1; i < j; i++, j--) {
            int tmp = capacity[i];
            capacity[i] = capacity[j];
            capacity[j] = tmp;
        }
        //
        for (int i = 0; i < capacity.length; i++) {
            // Distributing the apple
            appleSum -= capacity[i];
            result++;
            // If appleSum <= 0, that means finish distributing, break the loop
            if (appleSum <= 0) break;
        }
        return result;
    }
}
