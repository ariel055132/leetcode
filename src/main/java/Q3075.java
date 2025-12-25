import java.util.Arrays;

public class Q3075 {
    public long maximumHappinessSum(int[] happiness, int k) {
        long result = 0;
        // In order to obtain the greatest happiness, we should obtain the greatest elements of happiness first
        // Therefore, we need to sort the array in descending order
        Arrays.sort(happiness);
        for (int i = 0, j = happiness.length - 1; i < j; i++, j--) {
            int tmp = happiness[i];
            happiness[i] = happiness[j];
            happiness[j] = tmp;
        }
        // Calculate the greatest happiness
        for (int i = 0; i < k; i++) {
            // Happiness value of all the children that have not been selected till now decreased by 1
            int currentHappiness = happiness[i] - i;
            // If the currentHappiness of child is less than 0, that means it will decrease the maximum happiness
            // Therefore, need to break
            if (currentHappiness < 0) {
                break;
            }
            // Otherwise, add the current happiness to result
            result += currentHappiness;
        }
        return result;
    }
}
