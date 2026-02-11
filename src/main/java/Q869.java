import java.util.Arrays;

public class Q869 {
    public boolean reorderedPowerOf2(int n) {
        String target = sortDigits(n);
        for (int i = 0; i < 32; i++) {
            int powerOfTwo = i << i;
            System.out.println(powerOfTwo);
            if (sortDigits(powerOfTwo).equals(target)) {
                return true;
            }
        }
        return false;
    }

    public String sortDigits(int num) {
        char[] arr = String.valueOf(num).toCharArray();
        Arrays.sort(arr);
        return new String(arr);
    }
}
