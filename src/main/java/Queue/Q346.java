package Queue;

import java.util.ArrayDeque;
import java.util.Queue;

public class Q346 {
    /**
     * Given a stream of integers and a window size, calculate the moving average of all integers in the sliding window.
     * Implement the MovingAverage (Q346) class:
     * MovingAverage(int size) Initializes the object with the size of the window size.
     * double next(int val) Returns the moving average of the last size values of the stream.
     */
    int size;
    Queue<Integer> queue = new ArrayDeque<>();
    double sum = 0.0;
    // Initialization with constructor
    public Q346(int size) {
        this.size = size;
    }
    
    public double next(int val) {
        queue.add(val);
        sum += val;
        if (queue.size() > size) {
            // Poll is used to maintain the last size values of the stream by popping the furthest element in queue
            sum -= queue.poll();
        }
        // Calculate the moving average
        // Math.min is used as the size of queue may not equal to the size of the window size
        return sum / Math.min(queue.size(), size);
    }
}
