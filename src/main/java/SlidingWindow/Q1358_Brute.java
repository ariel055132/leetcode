package SlidingWindow;

public class Q1358_Brute {
    /**
     * Given a string s consisting only of characters a, b and c.
     * Return the number of substrings containing at least one occurrence of all these characters a, b and c.
     * 
     * Just enumerate all the possible substring.
     * Determine if the substring contains characters a, b and c or not.
     * If Yes, result++
     * 
     * @param s
     * @return
     */
    public int numberOfSubstrings(String s) {
        int result = 0;
        for (int i = 0; i < s.length(); i++) {
            for (int j = i; j < s.length(); j++) {
                StringBuilder sb = new StringBuilder();
                boolean hasA = false;
                boolean hasB = false;
                boolean hasC = false;
                for (int k = i; k <= j; k++) {
                    char ch = s.charAt(k);
                    sb.append(ch);
                    System.out.println(sb.toString());
                    if (ch == 'a') hasA = true;
                    if (ch == 'b') hasB = true;
                    if (ch == 'c') hasC = true;
                }
                if (hasA && hasB && hasC) result++;
            }
        }


        return result;
    }
}
