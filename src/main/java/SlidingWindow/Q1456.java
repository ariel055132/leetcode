package SlidingWindow;

import java.util.Set;

public class Q1456 {
    public int maxVowels(String s, int k) {
        int left = 0;
        int result = 0;
        Set<Character> vowels = Set.of('a', 'e', 'i', 'o', 'u');
        for (int right = 0; right < s.length(); right++) {
            if (vowels.contains(right)) {
                result++;
            }
            left = right - k + 1;
            if (left <= 0) {
                continue;
            }

        }

        return result >= k ? k : result;
    }
    }
