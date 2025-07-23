import java.util.*;

public class BSTValidation {

    static class TreeNode {
        int data;
        TreeNode left, right;

        TreeNode(int data) {
            this.data = data;
        }
    }

    // ✅ 1. 驗證是否為有效 BST（中序法）
    public static boolean isValidBST(TreeNode root) {
        return validate(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    private static boolean validate(TreeNode node, long min, long max) {
        if (node == null) return true;
        if (node.data <= min || node.data >= max) return false;
        return validate(node.left, min, node.data) && validate(node.right, node.data, max);
    }

    // ✅ 2. 找出不符合 BST 的節點（中序走訪並檢查遞增性）
    public static List<TreeNode> findInvalidNodes(TreeNode root) {
        List<TreeNode> invalidNodes = new ArrayList<>();
        findInvalidNodesHelper(root, Long.MIN_VALUE, Long.MAX_VALUE, invalidNodes);
        return invalidNodes;
    }

    private static void findInvalidNodesHelper(TreeNode node, long min, long max, List<TreeNode> invalid) {
        if (node == null) return;

        if (node.data <= min || node.data >= max) {
            invalid.add(node);
        }

        findInvalidNodesHelper(node.left, min, Math.min(max, node.data), invalid);
        findInvalidNodesHelper(node.right, Math.max(min, node.data), max, invalid);
    }

    // ✅ 3. 計算最少移除節點數，使其成為合法 BST
    public static int minNodesToRemove(TreeNode root) {
        return countInvalidNodes(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    private static int countInvalidNodes(TreeNode node, long min, long max) {
        if (node == null) return 0;

        if (node.data <= min || node.data >= max) {
            // 整個子樹都不能算進 BST，要全部移除
            return countAllNodes(node);
        }

        return countInvalidNodes(node.left, min, node.data)
             + countInvalidNodes(node.right, node.data, max);
    }

    // 輔助：計算一棵樹的總節點數
    private static int countAllNodes(TreeNode node) {
        if (node == null) return 0;
        return 1 + countAllNodes(node.left) + countAllNodes(node.right);
    }

    public static void main(String[] args) {
        /*
         測試樹結構（非法 BST）:
                   10
                  /  \
                5     8  <-- 8 應在左邊，錯誤
               / \   / \
              2   6 12  4 <-- 12 應在右邊，正確；4 是錯誤的（應在左邊更深）
         */
        TreeNode root = new TreeNode(10);
        root.left = new TreeNode(5);
        root.right = new TreeNode(8);
        root.left.left = new TreeNode(2);
        root.left.right = new TreeNode(6);
        root.right.left = new TreeNode(12);
        root.right.right = new TreeNode(4);

        // 1. 驗證 BST
        System.out.println("是否為合法 BST: " + isValidBST(root));

        // 2. 找出不合法節點
        List<TreeNode> invalid = findInvalidNodes(root);
        System.out.print("不合法節點值: ");
        for (TreeNode node : invalid) {
            System.out.print(node.data + " ");
        }
        System.out.println();

        // 3. 計算最少移除幾個節點才能讓它成為合法 BST
        int minRemovals = minNodesToRemove(root);
        System.out.println("最少需要移除節點數: " + minRemovals);
    }
}

