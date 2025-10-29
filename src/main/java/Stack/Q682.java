package Stack;

import java.util.LinkedList;

public class Q682 {
    /**
     * Use LinkedList to implement the operation in operations list.
     *
     * @param operations String[]
     * @return result int (the sum of all the scores on the record after applying all the operations.)
     */
    public int calPoints(String[] operations) {
        LinkedList<Integer> list = new LinkedList<>();
        for (String op : operations) {
            if (op.equals("C")) {
                list.removeLast();
            } else if (op.equals("D")) {
                int currentScore = list.getLast();
                list.add(currentScore * 2);
            } else if (op.equals("+")) {
                int lastScore = list.getLast();
                int prevScore = list.get(list.size() - 2);
                list.add(lastScore + prevScore);
            } else {
                list.add(Integer.parseInt(op));
            }
        }

        int result = 0;
        for (int i = 0; i < list.size(); i++) {
            result += list.get(i);
        }

        return result;
    }
}
