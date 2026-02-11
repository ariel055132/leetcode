package Tree;

import java.util.ArrayList;
import java.util.List;

public class Q1161 {
    /**
     * Given the root of a binary tree, the level of its root is 1, the level of its children is 2, and so on.
     * Return the smallest level x such that the sum of all the values of nodes at level x is maximal.
     */
    public int maxLevelSum(TreeNode root) {
        int result = 0;
        int level = 0; // record the tree level
        List<Integer> levelSum = new ArrayList<>();
        dfs(root, 0, levelSum);
        for (int i = 0; i < levelSum.size(); i++) {
            if (result < levelSum.get(i)) {
                result = levelSum.get(i);
                level = i + 1;
            }
        }
        return level;
    }

    private void dfs(TreeNode node, int level, List<Integer> levelSumList) {
        // If tree is null, just return
        if (node == null) return;
        // Do something
        if (levelSumList.size() == level) {
            levelSumList.add(node.val);
        } else {
            levelSumList.set(level, levelSumList.get(level) + node.val);
        }

        // Traverse left subtree
        dfs(node.left, level + 1, levelSumList);
        // Traverse right subtree
        dfs(node.right, level + 1, levelSumList);
    }
}
