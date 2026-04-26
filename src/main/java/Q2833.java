public class Q2833 {
    /**
     * Starting at position 0 on a number line, you make n moves. 
     * Each 'L' forces a left step, each 'R' forces a right step, and each '_' can go either way. 
     * Return the maximum absolute distance from the origin you can achieve.
     * @param moves
     * @return
     */
    public int furthestDistanceFromOrigin(String moves) {
        int blank = 0;
        int character = 0;
        for (int i = 0; i < moves.length(); i++) {
            if (moves.charAt(i) == 'L') {
                // count for left
                character--;
            } else if (moves.charAt(i) == 'R') {
                // count for right
                character++;
            } else {
                // count for '_'
                blank++;
            }
        }
        return Math.abs(character) + blank;
    }
}
