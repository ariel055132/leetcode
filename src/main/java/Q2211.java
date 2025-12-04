import java.util.Stack;

public class Q2211 {
    public int countCollisions(String directions) {
        int result = 0;
        Stack<Character> stk = new Stack<>();
        stk.push(directions.charAt(0));
        for (int i = 1; i < directions.length(); i++) {
            char currDirection = directions.charAt(i);
            if ((stk.peek() == 'R' && currDirection == 'L')) {
                result += 2;
                stk.pop();
                currDirection = 'S';
            } else if ((stk.peek() == 'S') && currDirection == 'L') {
                result++;
                currDirection = 'S';
            }

            // make sure that stack is R, and current Direction is S, collision++
            while (!stk.isEmpty() && (stk.peek() == 'R' && currDirection =='S')) {
                result++;
                stk.pop();
            }
            stk.push(currDirection);
        }


        return result;
    }
}
