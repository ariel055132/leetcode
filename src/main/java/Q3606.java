import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Q3606 {
    /**
     * .
     * @param code String[] Coupon Identifier
     * @param businessLine String[] Business category of the coupon
     * @param isActive boolean[] indicating whether the coupon is currently active
     * @return List<String> all codes of valid coupons
     */
    public List<String> validateCoupons(String[] code, String[] businessLine, boolean[] isActive) {
        List<String> result = new ArrayList<>();
        List<String> electronicsCoupons = new ArrayList<>();
        List<String> groceryCoupons = new ArrayList<>();
        List<String> pharmacyCoupons = new ArrayList<>();
        List<String> restaurantCoupons = new ArrayList<>();
        for (int i = 0; i < isActive.length; i++) {
            if (isActive[i]) { // The coupon is valid when it is active
                // The businessLine we needed are (electronics, grocery, pharmacy, restaurant)
                if (businessLine[i].equals("electronics") || businessLine[i].equals("grocery") || businessLine[i].equals("pharmacy") || businessLine[i].equals("restaurant")) {
                    if (code[i].length() == 0) continue;
                    boolean valid = true;
                    for (int j = 0; j < code[i].length(); j++) {
                        char ch = code[i].charAt(j);
                        // Determine whether the character in code is valid, invalid -> skip / valid -> keep checking until finished
                        if (!Character.isLetterOrDigit(ch) && ch != '_') {
                            valid = false;
                            break;
                        }
                    }
                    if (valid) {
                        if (businessLine[i].startsWith("e")) {
                            electronicsCoupons.add(code[i]);
                        }
                        if (businessLine[i].startsWith("g")) {
                            groceryCoupons.add(code[i]);
                        }
                        if (businessLine[i].startsWith("p")) {
                            pharmacyCoupons.add(code[i]);
                        }
                        if (businessLine[i].startsWith("r")) {
                            restaurantCoupons.add(code[i]);
                        }
                    }
                }
            }
        }

        // Add the coupon result to result respectively
        // The result needs to be sorted first by their businessLine in order: electronics, grocery, pharmacy, restaurant
        Collections.sort(electronicsCoupons);
        Collections.sort(groceryCoupons);
        Collections.sort(pharmacyCoupons);
        Collections.sort(restaurantCoupons);
        result.addAll(electronicsCoupons);
        result.addAll(groceryCoupons);
        result.addAll(pharmacyCoupons);
        result.addAll(restaurantCoupons);

        return result;
    }
}
