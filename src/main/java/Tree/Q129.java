package Tree;

public class Q129 {
    public int sumNumbers(TreeNode root) {
        helper(root, 0);
        return sum;
    }
    // Return result
    int sum = 0;

    public void helper(TreeNode root, int currentSum) {
        if (root == null) {
            return ;
        }
        currentSum = currentSum * 10 + root.val;
        if (root.left == null && root.right == null) {
            sum += currentSum;
            return ;
        }
        helper(root.left, currentSum);
        helper(root.right, currentSum);
    }
}
