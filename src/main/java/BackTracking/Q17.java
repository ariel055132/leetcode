package BackTracking;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Q17 {
    HashMap<Character, String> digitsLetterMap = new HashMap<>();

    public List<String> letterCombinations(String digits) {
        init();
        List<String> result = new ArrayList<>();
        if (digits.length() == 0) {
            return result;
        }

        for (int i = 0; i < digits.length(); i++) {
            List<String> tmpResult = new ArrayList<>();
            Character currentChar = digits.charAt(i);
            String letter = digitsLetterMap.get(currentChar);
            for (int j = 0; j < letter.length(); j++) {
                for (int k = 0; k < result.size(); k++) {
                    tmpResult.add(result.get(j) + result.get(k));
                }
            }
            result = tmpResult;
        }
        return result;
    }

    void init() {
        digitsLetterMap.put('1', "");
        digitsLetterMap.put('2', "abc");
        digitsLetterMap.put('3', "def");
        digitsLetterMap.put('4', "ghi");
        digitsLetterMap.put('5', "jkl");
        digitsLetterMap.put('6', "mno");
        digitsLetterMap.put('7', "pqrs");
        digitsLetterMap.put('8', "tuv");
        digitsLetterMap.put('9', "wxyz");
    }
}
