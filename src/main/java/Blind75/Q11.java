package Blind75;


public class Q11 {
    public int maxArea(int[] height) {
        int left = 0; // left pointer
        int right = height.length - 1; // right pointer
        int maxArea = 0; // maximum area found so far

        while (left < right) {
            int width = right - left; // calculate width between the two pointers
            int currentHeight = Math.min(height[left], height[right]); // find the shorter height
            int currentArea = width * currentHeight; // calculate the area
            maxArea = Math.max(maxArea, currentArea); // update maxArea if currentArea is larger
            // move the pointer pointing to the shorter height inward
            if (height[left] < height[right]) {
                left++; // move the left pointer to the right if left height is smaller
            } else {
                right--; // move the right pointer to the left if right height is smaller or equal
            }
        }

        return maxArea;
    }
}
