import java.util.List;

public class Q422 {
    /**
     * Given an array of strings words, return true if it forms a valid word square.
     * Traverse the list
     * If the character in row and col are different, that is a invalid word square.
     * 
     * @param words List<String>
     * @returț
     */
    public boolean validWordSquare(List<String> words) {
        // Traverse the List with row and col
        // Compare whether the character in row and col are the same
        // If not the same, return false
        // After traversal, return true
        for (int i = 0; i < words.size(); i++) {
            String col = words.get(i); // Debug
            for (int j = 0; j < words.get(i).length(); j++) {
                String row = words.get(j); // Debug
                char w = words.get(i).charAt(j);
                char v = words.get(j).charAt(i);
                if (w != v) return false;
            }
        }
        return true;
    }
}
