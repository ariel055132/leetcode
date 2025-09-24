package Tree;

import java.util.ArrayDeque;
import java.util.Queue;

public class Q513 {
    public int findBottomLeftValue(TreeNode root) {
        // Base Case: Return null / empty if tree is empty
        if (root == null) {
            return 0;
        }
        Queue<TreeNode> treeNodeQueue = new ArrayDeque<>();
        treeNodeQueue.add(root);
        while (!treeNodeQueue.isEmpty()) {
            root = treeNodeQueue.poll();
            if (root.right != null) treeNodeQueue.add(root.right);
            if (root.left != null) treeNodeQueue.add(root.left);
        }
        return root.val;
    }
}
