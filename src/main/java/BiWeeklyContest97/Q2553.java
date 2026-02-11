package BiWeeklyContest97;

public class Q2553 {
    public int[] separateDigits(int[] nums) {
        StringBuilder sb = new StringBuilder();

        for (int num : nums) {
            sb.append(String.valueOf(num));
        }

        int n = sb.length();
        int[] result = new int[n];

        int i = 0;
        for (char ch: sb.toString().toCharArray()) {
            result[i++] = ch - '0';
        }

        return result;
    }
}
