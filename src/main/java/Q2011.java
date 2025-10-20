import java.util.Objects;

public class Q2011 {
    public int finalValueAfterOperations(String[] operations) {
        int result = 0;
        for (String operation : operations) {
            if (Objects.equals(operation, "X++") || Objects.equals(operation,"++X")) {
                result++;
            } else if (Objects.equals(operation, "X--") || Objects.equals(operation, "--X")) {
                result--;
            }
        }
        return result;
    }
}
