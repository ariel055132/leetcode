package WeeklyContest505;

import java.util.ArrayList;
import java.util.List;

public class Q2 {
    /**
     * You are given two integers n and k. 
     * The cost of a binary string s is defined as the sum of all indices i (0-based) such that s[i] == '1'. 
     * A binary string is considered valid if:
     * It does not contain two consecutive '1' characters.
     * Its cost is less than or equal to k.
     * Return a list of all valid binary strings of length n in any order.
     * 
     * Just generate all possible binary string, and save the valid result and return
     * 
     * @param n
     * @param k
     * @return
     */
    public List<String> generateValidStrings(int n, int k) {
        List<String> result = new ArrayList<>();
        generateBinaryStringPossibilities("", n, k, result);
        return result;
    }

    private void generateBinaryStringPossibilities(String currentString, int n, int k, List<String> result) {
        if (currentString.length() == n) {
            if (isValid(currentString, k)) {
                result.add(currentString);
            }
            return;
        }
        generateBinaryStringPossibilities(currentString + '0', n, k, result);
        generateBinaryStringPossibilities(currentString + '1', n, k, result);
    }

    private boolean isValid(String str, int k) {
        int cost = 0; // Calculate the cost of the str
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == '1') {
                cost += i;
                // Rule 1: The string contains two consecutive '1' characters -> invalid
                if (i > 0 && str.charAt(i - 1) == '1') {
                    return false;
                }
            }
        }
        return cost <= k; // Rule 2: Cost must be less than or equal to k
    }
}
