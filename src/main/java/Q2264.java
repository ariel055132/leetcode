import java.util.HashSet;
import java.util.Set;

public class Q2264 {
    public String largestGoodInteger(String num) {

        Set<Integer> numSaved = new HashSet<>(); // Remove the duplicate digits
        // Traverse the string to find the largest good integer, save the digits to numSaved
        for (int i = 0; i < num.length() - 2; i++) {
            if (num.charAt(i) == num.charAt(i + 1) && num.charAt(i) == num.charAt(i + 2)) {
                numSaved.add(Character.getNumericValue(num.charAt(i)));
            }
        }
        // If no good integer is found, return an empty string
        if (numSaved.isEmpty()) {
            return "";
        } else {
            // Find the maximum digit in numSaved and return it as a string repeated 3 times
            int max = numSaved.stream().max(Integer::compareTo).orElse(-1);
            return String.valueOf(max).repeat(3);
        }
    }
}
