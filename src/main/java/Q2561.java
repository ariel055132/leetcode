import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Q2561 {
    public long minCost(int[] basket1, int[] basket2) {
        HashMap<Integer, Integer> basket1And2FreqMap = new HashMap<>();
        for (int fruit : basket1) {
            basket1And2FreqMap.put(fruit, basket1And2FreqMap.getOrDefault(fruit, 0) + 1);
        }
        long result = Long.MAX_VALUE;
        for (Map.Entry<Integer, Integer> entry : basket1And2FreqMap.entrySet()) {
            if (entry.getValue() % 2 != 0) {
                return -1; // If any fruit has an odd count, return -1 (value do not become the same after swappintg)
            }
            result = Math.min(result, entry.getKey());
        }
        List<Long> fruit_to_swap = new ArrayList<>();
        Map<Integer, Integer> count1 = new HashMap<>();
        for (int fruit : basket1) count1.put(fruit, count1.getOrDefault(fruit, 0) + 1);

        for (Map.Entry<Integer, Integer> entry : basket1And2FreqMap.entrySet()) {
            int fruit = entry.getKey();
            int diff = basket1And2FreqMap.getOrDefault(fruit, 0) - entry.getValue() / 2;
            for (int i = 0; i < Math.abs(diff); i++) {
                fruit_to_swap.add((long) fruit);
            }
        }

        long totalCost = 0;
        int swapsToMake = fruit_to_swap.size() / 2;
        for (int i = 0; i < swapsToMake; i++) {
            totalCost += Math.min(fruit_to_swap.get(i), 2 * result);
        }

        return totalCost;
    }
}
