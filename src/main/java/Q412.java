import java.util.ArrayList;
import java.util.List;

public class Q412 {
    /**
     * Given an integer n, return a string array answer (1-indexed) where:
     * answer[i] == "FizzBuzz" if i is divisible by 3 and 5.
     * answer[i] == "Fizz" if i is divisible by 3.
     * answer[i] == "Buzz" if i is divisible by 5.
     * answer[i] == i (as a string) if none of the above conditions are true.
     * 
     * @param n
     * @return
     */
    public List<String> fizzBizz(int n) {
        List<String> result = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            // Whether i is divisible by 3
            boolean divisibleBy3 = false;
            // Whether i is divisible by 5
            boolean divisibleBy5 = false;
            if (i % 3 == 0) {
                divisibleBy3 = true;
            }
            if (i % 5 == 0) {
                divisibleBy5 = true;
            }
            // If i is divisible by 3 and 5 at the same time, return FizzBuzz
            if (divisibleBy3 == true && divisibleBy5 == true) {
                result.add("FizzBuzz");
            } else if (divisibleBy3 == true && divisibleBy5 == false) {
                // i is divisible by 3 only, return Fizz
                result.add("Fizz");
            } else if (divisibleBy3 == false && divisibleBy5 == true) {
                // i is divisible by 5 only, return Buzz
                result.add("Buzz");
            } else {
                // Return i if none of the above conditions are true
                result.add(String.valueOf(i));
            }    
        }
        return result;
    }
}
