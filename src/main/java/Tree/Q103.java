package Tree;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Queue;

public class Q103 {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        // Base Case: Return empty if tree is empty
        if (root == null) {
            return List.of();
        }
        // Need to traverse the node's values in zigzag order
        // Which means root does not need to change, and the next layer need to reverse, etc.
        boolean isEven = false;
        List<List<Integer>> result = new ArrayList<>();
        Queue<TreeNode> treeNodeQueue =  new ArrayDeque<>();
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
            // Determine need to reverse the list elements or not
            // If it is even number of layer need to reverse
            if (isEven) {
                Collections.reverse(vals);
            }
            result.add(vals);
            isEven = !isEven;
        }
        return result;
    }
}
