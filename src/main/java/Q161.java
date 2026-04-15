public class Q161 {
    public boolean isOneEditDistance(String s, String t) {
        int sLen = s.length();
        int tLen = t.length();
        if (Math.abs(tLen - sLen) > 1) {
            return false;
        }
        int indexS = 0;
        int indexT = 0;
        while (indexS < sLen && indexT < tLen && s.charAt(indexS) == t.charAt(indexT)) {
            indexS++;
            indexT++;
        }
        // String s == String t -> return false
        if (indexS == sLen && indexT == tLen) {
            return false;
        }
        // With difference, start decide deletion, insertion, and replacing
        if (sLen == tLen) {
            // Replacing when two string have the same length
            String newS = s.substring(indexS + 1);
            String newT = t.substring(indexT);
            return newS.equals(newT);
        } else if (sLen > tLen) {
            // Insertion / Deletion when both string do not have the same length
            String newS = s.substring(indexS + 1);
            String newT = t.substring(indexT);
            return newS.equals(newT);
        } else {
            String newS = s.substring(indexS);
            String newT = t.substring(indexT + 1);
            return newS.equals(newT);
        }

    }
}
