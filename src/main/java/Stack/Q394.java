package Stack;

import java.util.Stack;

public class Q394 {
    public String decodeString(String s) {
        StringBuilder result = new StringBuilder();
        Stack<Integer> numStack = new Stack<>(); // Stack for saving the number of occurence times
        Stack<String> strStack = new Stack<>();
        int num = 0;
        String currentStr = "";
        for (char ch : s.toCharArray()) {

            if (ch >= '0' && ch <= '9') {
                num = num * 10 + (ch - '0');
            } else if (ch == '[') {
                strStack.push(currentStr);
                currentStr = "";
                numStack.push(num);
                num = 0;
            } else if (ch == ']') {
                String string = currentStr;
                currentStr = strStack.pop();
                int count = numStack.pop();
                while (count > 0) {
                    result.append(string);
                    count--;
                }
            } else {
                // English Character
                currentStr += ch;
            }
        }
        return result.toString();
    }
}
