public class Q3612 {
    public String processStr(String s) {
        // Edge Case: If String s is null, return the empty string
        if (s == null) {
            return "";
        }
        StringBuilder resultBuilder = new StringBuilder();
        for (char ch : s.toCharArray()) {
            if (ch >= 'a' && ch <= 'z') {
                // If the character is a lowercase English letter, append it to result
                resultBuilder.append(ch);
            } else if (ch == '#') {
                // If the character is '#', duplicates the current result and appends it
                resultBuilder.append(resultBuilder);
            } else if (ch == '*' && resultBuilder.length() > 0) {
                // If the character is '*', removes the last character from result, if it exists.
                // Therefore, need to do the length checking (if it exists)
                resultBuilder.deleteCharAt(resultBuilder.length() - 1);
            } else if (ch == '%') {
                // If the character is '%', reverses the current result
                resultBuilder.reverse();
            }
        }
        return resultBuilder.toString();
    }
}
