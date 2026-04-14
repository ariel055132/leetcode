package HashTable;

import java.util.HashMap;
import java.util.Map;

public class Q1056 {
    public boolean confusingNumber(int n) {
        // Map to save the numbers with its rotated form
        Map<Character, Integer> map = new HashMap<>();
        map.put('0', 0); 
        map.put('1', 1);
        map.put('6', 9);
        map.put('8', 8);
        map.put('9', 6);
        // Form the rotated string
        String strN = Integer.toString(n);
        StringBuilder sb = new StringBuilder();
        for (char ch : strN.toCharArray()) {
            if (!map.containsKey(ch)) {
                return false;
            } 
            sb.append(map.get(ch));
        }
        // As example will do the reverse
        sb.reverse();
        // Compare it is confusing number, parse to number to ignore leading zeros
        return Integer.parseInt(sb.toString()) != n;
        
    }
}
