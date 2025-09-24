package Tree;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class Q102 {
    public List<List<Integer>> levelOrder(TreeNode root) {
        // Base Case: Return empty if tree is empty
        if (root == null) {
            return List.of();
        }
        // Initialization
        // result: Stores final answer (lists of levels)
        // treeNodeQueue: BFS queue to process nodes
        // Add root to start traversal
        List<List<Integer>> result = new ArrayList<>();
        Queue<TreeNode> treeNodeQueue = new ArrayDeque<>();
        treeNodeQueue.add(root);
        while (!treeNodeQueue.isEmpty()) {
            // Current level size
            int n = treeNodeQueue.size();
            // Current level values
            List<Integer> vals = new ArrayList<>();
            while (n-- > 0) {
                TreeNode node = treeNodeQueue.poll();
                vals.add(node.val);
                if (node.left != null) treeNodeQueue.add(node.left);
                if (node.right != null) treeNodeQueue.add(node.right);
            }
            result.add(vals);
        }
        return result;
    }
}
