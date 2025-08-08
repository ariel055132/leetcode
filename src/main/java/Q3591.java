import java.util.HashMap;

public class Q3591 {
    public boolean checkPrimeFrequency(int[] nums) {
        HashMap<Integer, Integer> numsFreqMap = new HashMap<>();
        for (int num : nums) {
            numsFreqMap.put(num, numsFreqMap.getOrDefault(num, 0) + 1);
        }
        for (int freq : numsFreqMap.values()) {
            if (isPrime(freq)) {
                return true;
            }
        }
        return false;
    }

    private boolean isPrime(int freq) {
        if (freq < 2) {
            return false;
        }
        for (int i = 2; i * i <= freq; i++) {
            if (freq % i == 0) {
                return false;
            }
        }
        return true;
    }
}
