public class Q1295 {
    public int findNumbers(int[] nums) {
        int evenNumbers = 0;
        for (int num : nums) {
            String str = String.valueOf(num);
            if (str.length() % 2 == 0) {
                evenNumbers++;
            }
        }
        return evenNumbers;
    }
}
