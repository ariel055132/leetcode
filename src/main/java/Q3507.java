import java.util.ArrayList;

public class Q3507 {
    public int minimumPairRemoval(int[] nums) {
        int result = 0;
        ArrayList<Integer> list = new ArrayList<>();
        for (int num : nums) list.add(num);

        while (!isNonDecreasing(list)) {
            int currentMin = Integer.MAX_VALUE;
            int index = 0;
            for (int i = 1; i < list.size(); i++) {
                int currentSum = list.get(i - 1) + list.get(i);
                if (currentSum < currentMin) {
                    currentMin = currentSum;
                    index = i;
                }
            }
            list.set(index, currentMin);
            list.remove(index - 1);
            result++;
        }

        return result;
    }

    public boolean isNonDecreasing(ArrayList<Integer> nums) {
        for (int i = 1; i < nums.size(); i++) {
            if (nums.get(i) < nums.get(i - 1)) return false;
        }
        return true;
    }
}
