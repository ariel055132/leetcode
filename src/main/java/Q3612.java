public class Q3612 {
    public String processStr(String s) {
        if (s == null) {
            return "";
        }
        StringBuilder resultBuilder = new StringBuilder();
        for (char ch : s.toCharArray()) {
            if (ch >= 'a' && ch <= 'z') {
                resultBuilder.append(ch);
            } else if (ch == '#') {
                resultBuilder.append(resultBuilder);
            } else if (ch == '*' && resultBuilder.length() > 0) {
                resultBuilder.deleteCharAt(resultBuilder.length() - 1);
            } else if (ch == '%') {
                resultBuilder.reverse();
            }
        }
        return resultBuilder.toString();
    }
}
