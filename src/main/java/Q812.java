public class Q812 {
    public double largestTriangleArea(int[][] p) {
        // Use the shoelace formula -> A = (1/2) [x1 (y2 – y3 ) + x2 (y3 – y1 ) + x3(y1 – y2)]
        // Use Absolute value to avoid negative result~
        double result = 0.0;
        for (int i = 0; i < p.length; i++) {
            for (int j = i + 1; j < p.length; j++) {
                for (int k = j + 1; k < p.length; k++) {
                    int x1 = p[i][0], y1 = p[i][1];
                    int x2 = p[j][0], y2 = p[j][1];
                    int x3 = p[k][0], y3 = p[k][1];

                    double area = 0.5 * Math.abs(x1 * (y2 - y3) + x2 * (y3 - y1) + x3 * (y1 - y2));
                    result = Math.max(result, area);
                }
            }
        }
        return result;
    }
}
