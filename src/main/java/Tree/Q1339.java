package Tree;

import java.util.ArrayList;
import java.util.List;

public class Q1339 {
    List<Integer> allTreeSum = new ArrayList<>();

    public int maxProduct(TreeNode root) {
        long result = 0;
        long totalTreeSum = treeSum(root);
        return (int) result % 1000000007;
    }

    private int treeSum(TreeNode root) {
        if (root == null) return 0;
        int leftSum = treeSum(root.left);
        int rightSum = treeSum(root.right);
        int totalSum = leftSum + rightSum + root.val;
        allTreeSum.add(totalSum);
        return totalSum;
    }
}
