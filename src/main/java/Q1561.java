import java.util.Arrays;

public class Q1561 {
    public int maxCoins(int[] piles) {
        int result = 0;
        Arrays.sort(piles);
        for (int i = piles.length / 3; i < piles.length; i += 2) {
            result += piles[i];
        }
        return result;
    }
}
