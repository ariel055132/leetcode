public class Q3000 {
    // Calculate the length of diagonal and area of each element in dimensions
    // Return the area of the rectangle having the longest diagonal
    // If there are multiple rectangles with the longest diagonal, return the area of the rectangle having the maximum area
    public int areaOfMaxDiagonal(int[][] dimensions) {
        if (dimensions == null) {
            return 0;
        }
        int maxArea = 0;
        double maxDiagonal = 0.0;
        for (int i = 0; i < dimensions.length; i++) {
            int currentLength = dimensions[i][0];
            int currentWidth = dimensions[i][1];
            int currentArea = currentLength * currentWidth;
            double currentDiagonal = Math.sqrt((currentWidth * currentWidth) + (currentLength * currentLength));
            if (currentDiagonal > maxDiagonal) {
                maxDiagonal = currentDiagonal;
                maxArea = currentArea;
            } else if (currentDiagonal == maxDiagonal && currentArea > maxArea) {
                maxArea = currentArea;
            }
        }
        return maxArea;
    }
}
