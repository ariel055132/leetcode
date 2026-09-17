package Tree;

import java.util.ArrayList;
import java.util.List;

public class Q366 {
    /**
     * Given the root of a binary tree, collect a tree's nodes as if you were doing this:
     * Collect all the leaf nodes.
     * Remove all the leaf nodes.
     * Repeat until the tree is empty.
     * 
     * @param root
     * @return
     */
    public List<List<Integer>> findLeaves(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        // Remove one layer per iteration, keeping the root.
        while (root.left != null || root.right != null) {
            List<Integer> tmp = new ArrayList<>();
            dfs(root, tmp);
            result.add(tmp);
        }
        // The root is always the final group.
        result.add(List.of(root.val));
        return result;
    }

    public TreeNode dfs(TreeNode node, List<Integer> result) {
        if (node == null) return null;
        // Check before recursion so newly formed leaves
        // remain until the next round.
        if (node.left == null && node.right == null) {
            result.add(node.val);
            return null;
        }
        node.left = dfs(node.left, result);
        node.right = dfs(node.right, result);
        return node;
    }
}
