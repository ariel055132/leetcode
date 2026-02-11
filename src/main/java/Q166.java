import java.util.HashMap;

public class Q166 {
    public String fractionToDecimal(int numerator, int denominator) {
        StringBuilder stringBuilder = new StringBuilder();
        if (numerator == 0) {
            return "0";
        }
        // Negative Number Case
        if ( (numerator < 0 && denominator > 0) || (numerator > 0 && denominator < 0)) {
            stringBuilder.append("-");
        }

        // Convert it to long to avoid integer overflow
        long num = Math.abs((long) numerator);
        long den = Math.abs((long) denominator);

        String integerPart = String.valueOf(num / den);
        stringBuilder.append(integerPart);

        // Remaining Part -> for calculating decimal part
        num %= den;

        // Means that the result does not contain decimal part -> return the result
        if (num == 0) {
            return stringBuilder.toString();
        }

        // decimal part, append . first
        stringBuilder.append(".");

        HashMap<Long, Integer> hashMap = new HashMap<>();

        while (num != 0) {
            num *= 10;
            stringBuilder.append(num / den);
            num %= den;
            if (hashMap.containsKey(num)) {
                int index = hashMap.get(num);
                stringBuilder.insert(index, "(");
                stringBuilder.append(")");
                break;
            } else {
                hashMap.put(num, stringBuilder.length());
            }
        }

        return stringBuilder.toString();
    }
}
