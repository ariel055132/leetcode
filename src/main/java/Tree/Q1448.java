package Tree;

public class Q1448 {
    public int goodNodes(TreeNode root) {
        return dfs(root, root.val);
    }

    public int dfs(TreeNode root, int max) {
        if (root == null) {
            return 0;
        }
        int left = dfs(root.left, Math.max(max, root.val));
        int right = dfs(root.right, Math.max(max, root.val));
        return left + right + (max <= root.val ? 1 : 0);
    }
}
