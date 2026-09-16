package Heap;

import java.util.Map;
import java.util.PriorityQueue;
import java.util.TreeMap;

public class Q1086 {
    /**
     * Given a list of the scores of different students, items, where items[i] = [IDi, scorei] represents one score from a student with IDi, calculate each student's top five average.
     * Return the answer as an array of pairs result, where result[j] = [IDj, topFiveAveragej] represents the student with IDj and their top five average. Sort result by IDj in increasing order.
     * A student's top five average is calculated by taking the sum of their top five scores and dividing it by 5 using integer division.
     * 
     * Using heap to maintain the student's top five score, and calculate the average by dividing it by 5
     * 
     * @param items int[][]
     * @return int[][]
     */
    public int[][] highFive(int[][] items) {
        // Using a map to maintain the top five score of each students
        TreeMap<Integer, PriorityQueue<Integer>> map = new TreeMap<>();
        // Traverse the list of the scores of different students items
        for (int[] item : items) {
            int id = item[0]; // student id
            int score = item[1]; // score
            if (!map.containsKey(id)) {
                PriorityQueue<Integer> heap = new PriorityQueue<>();
                heap.add(score);
                map.put(id, heap);
            } else {
                PriorityQueue<Integer> heap = map.get(id);
                heap.add(score);
                if (heap.size() > 5) {
                    heap.poll();
                }
                map.put(id, heap);
            }
        }
        
        int index = 0;
        int[][] result = new int[map.size()][2];
        for (Map.Entry<Integer, PriorityQueue<Integer>> entry : map.entrySet()) {
            int id = entry.getKey();
            PriorityQueue<Integer> value = entry.getValue();
            int sum = 0;
            int size = value.size();
            while (!value.isEmpty()) {
                sum += value.poll();
            }
            sum /= size;
            result[index][0] = id;
            result[index][1] = sum;
            index++;
        }
        return result;
    }
}
