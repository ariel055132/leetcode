package BitManipulation;

public class Operation {
    public int and() {
        return 46 & 51;
    }

    public int or() {
        return 46 | 51;
    }

    public int rightShift() {
        // 1101 (binary form of 13) -> 110 (right shift result) -> 6
        return 13 >> 1;
    }

    public String checkingOddEven(int num) {
        /**
         * Example
         * 1101 (Binary form of 13)
         * 0001 (Binary form of 1)
         * 0001
         */
        if ((num & 1) == 1) {
            return "Odd";
        } else {
            return "Even";
        }
    }

    public int leftShift() {
        // 1101 (binary form of 13) -> 11010 (left shift result)
        // 2^4 + 2^3 + 2^1 + 2^0
        // 16 + 8 + 2 = 26
        return 13 << 1;
    }

    public String decimalToBinary(int n) {
        StringBuilder sb = new StringBuilder();
        while (n > 0) {
            sb.append(n % 2);
            n /= 2;
        }
        return sb.reverse().toString();
    }
}
