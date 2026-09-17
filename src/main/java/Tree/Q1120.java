package Tree;

public class Q1120 {
    private double result = 0;
    public double maximumAverageSubtree(TreeNode root) {
        calculateAverage(root);
        return result;
    }

    // int[] for saving the number of node in tree, sum value of nodes in the tree
    public double[] calculateAverage(TreeNode node) {
        if (node == null) return new double[]{0.0, 0};
        double[] left = new double[2];
        double[] right = new double[2];
        if (node.left != null) left = calculateAverage(node.left);
        if (node.right != null) right = calculateAverage(node.right);
        
        double sum = node.val + left[0] + right[0];
        double n = left[1] + right[1] + 1;
        
        result = Math.max(result, sum / n);
        return new double[]{sum, n};
    }
}
