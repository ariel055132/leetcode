package Tree;

public class BaseTreeTest {
    public boolean areTreesEqual(TreeNode tree1, TreeNode tree2) {
        if (tree1 == null && tree2 == null) return true;
        if (tree1 == null || tree2 == null) return false;
        return tree1.val == tree2.val &&
                areTreesEqual(tree1.left, tree2.left) &&
                areTreesEqual(tree1.right, tree2.right);
    }
}
