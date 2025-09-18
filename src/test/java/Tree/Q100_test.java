package Tree;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class Q100_test {
    @Test
    @DisplayName("test1")
    void test1() {
        Q100 q100 = new Q100();
        boolean expectResult = true;
        boolean actualResult = q100.isSameTree(tree1(), tree1());
        Assertions.assertEquals(expectResult, actualResult);
    }

    @Test
    @DisplayName("test 2")
    void test2() {
        Q100 q100 = new Q100();
        boolean expectResult = true;
        boolean actualResult = q100.isSameTree(null, null);
        Assertions.assertEquals(expectResult, actualResult);
    }

    @Test
    @DisplayName("test 3")
    void test3() {
        Q100 q100 = new Q100();
        boolean expectResult = false;
        boolean actualResult = q100.isSameTree(tree2(), tree3());
        Assertions.assertEquals(expectResult, actualResult);
    }

    @Test
    @DisplayName("Test 4")
    void test4() {
        Q100 q100 = new Q100();
        boolean expectResult = false;
        boolean actualResult = q100.isSameTree(tree4(), tree5());
        Assertions.assertEquals(expectResult, actualResult);
    }

    TreeNode tree1() {
        TreeNode root = new TreeNode(1);
        TreeNode left = new TreeNode(2);
        TreeNode right = new TreeNode(3);
        root.left = left;
        root.right = right;
        return root;
    }

    TreeNode tree2() {
        TreeNode root = new TreeNode(1);
        TreeNode left = new TreeNode(2);
        root.left = left;
        return root;
    }

    TreeNode tree3() {
        TreeNode root = new TreeNode(1);
        TreeNode right = new TreeNode(2);
        root.right = right;
        return root;
    }

    TreeNode tree4() {
        TreeNode root = new TreeNode(1);
        TreeNode left = new TreeNode(2);
        TreeNode right = new TreeNode(1);
        root.left = left;
        root.right = right;
        return root;
    }

    TreeNode tree5() {
        TreeNode root = new TreeNode(1);
        TreeNode left = new TreeNode(1);
        TreeNode right = new TreeNode(2);
        root.left = left;
        root.right = right;
        return root;
    }

}
