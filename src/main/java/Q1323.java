public class Q1323 {
    public int maximum69Number (int num) {
        String numStr = String.valueOf(num);
        int index = numStr.indexOf('6');

        if (index != -1) {
            // Replace the first '6' with '9'
            numStr = numStr.substring(0, index) + '9' + numStr.substring(index + 1);
            return Integer.parseInt(numStr);
        } else {
            // If there is no '6', return the number as is
            return num;
        }
    }
}
