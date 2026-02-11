package BackTracking;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Q17_Back {

    HashMap<Character, String> digitsLetterMap = new HashMap<>();

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

    public List<String> letterCombinations(String digits) {
        int digitlen = digits.length();
        if (digitlen == 0) {
            return List.of();
        }
        List<String> result = new ArrayList<>();
        char[] path = new char[digitlen];
        dfs(0, result, path ,digits.toCharArray());
        return result;
    }

    private void dfs(int i, List<String> ans, char[] path, char[] digits) {
        init();
        if (i == digits.length) {
            ans.add(new String(path));
            return;
        }
        String letters = digitsLetterMap.get(digits[i]);
        for (char c : letters.toCharArray()) {
            path[i] = c;
            dfs(i+1, ans, path, digits);
        }
    }
}
