package Tree;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class Q513_test {
    @Test
    @DisplayName("test 1")
    void test1() {
        Q513 q513 = new Q513();
        int expectResult = 1;
        int actualResult = q513.findBottomLeftValue(tree1());
        Assertions.assertEquals(expectResult, actualResult);
    }

    TreeNode tree1() {
        TreeNode root = new TreeNode(2);
        TreeNode leftNode = new TreeNode(1);
        TreeNode rightNode = new TreeNode(3);
        root.left = leftNode;
        root.right = rightNode;
        return root;
    }
}
