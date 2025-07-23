import java.util.*;

public class TreeReconstruction {

    static class TreeNode {
        int data;
        TreeNode left, right;
        TreeNode(int data) { this.data = data; }
    }

    // ===== 根據前序 + 中序重建 =====
    public static TreeNode buildTreeFromPreIn(int[] preorder, int[] inorder) {
        Map<Integer, Integer> inIndexMap = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            inIndexMap.put(inorder[i], i);
        }
        return buildPreInHelper(preorder, 0, preorder.length - 1,
                                inorder, 0, inorder.length - 1, inIndexMap);
    }

    private static TreeNode buildPreInHelper(int[] preorder, int preStart, int preEnd,
                                             int[] inorder, int inStart, int inEnd,
                                             Map<Integer, Integer> inIndexMap) {
        if (preStart > preEnd || inStart > inEnd) return null;

        int rootVal = preorder[preStart];
        TreeNode root = new TreeNode(rootVal);

        int inRootIndex = inIndexMap.get(rootVal);
        int leftTreeSize = inRootIndex - inStart;

        root.left = buildPreInHelper(preorder, preStart + 1, preStart + leftTreeSize,
                                    inorder, inStart, inRootIndex - 1, inIndexMap);

        root.right = buildPreInHelper(preorder, preStart + leftTreeSize + 1, preEnd,
                                     inorder, inRootIndex + 1, inEnd, inIndexMap);

        return root;
    }

    // ===== 根據後序 + 中序重建 =====
    public static TreeNode buildTreeFromPostIn(int[] postorder, int[] inorder) {
        Map<Integer, Integer> inIndexMap = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            inIndexMap.put(inorder[i], i);
        }
        return buildPostInHelper(postorder, 0, postorder.length - 1,
                                inorder, 0, inorder.length - 1, inIndexMap);
    }

    private static TreeNode buildPostInHelper(int[] postorder, int postStart, int postEnd,
                                              int[] inorder, int inStart, int inEnd,
                                              Map<Integer, Integer> inIndexMap) {
        if (postStart > postEnd || inStart > inEnd) return null;

        int rootVal = postorder[postEnd];
        TreeNode root = new TreeNode(rootVal);

        int inRootIndex = inIndexMap.get(rootVal);
        int leftTreeSize = inRootIndex - inStart;

        root.left = buildPostInHelper(postorder, postStart, postStart + leftTreeSize - 1,
                                     inorder, inStart, inRootIndex - 1, inIndexMap);

        root.right = buildPostInHelper(postorder, postStart + leftTreeSize, postEnd - 1,
                                      inorder, inRootIndex + 1, inEnd, inIndexMap);

        return root;
    }

    // ===== 驗證：前序遍歷 =====
    public static void printPreOrder(TreeNode root) {
        if (root == null) return;
        System.out.print(root.data + " ");
        printPreOrder(root.left);
        printPreOrder(root.right);
    }

    // ===== 驗證：中序遍歷 =====
    public static void printInOrder(TreeNode root) {
        if (root == null) return;
        printInOrder(root.left);
        System.out.print(root.data + " ");
        printInOrder(root.right);
    }

    // ===== 驗證：後序遍歷 =====
    public static void printPostOrder(TreeNode root) {
        if (root == null) return;
        printPostOrder(root.left);
        printPostOrder(root.right);
        System.out.print(root.data + " ");
    }

    public static void main(String[] args) {
        // 測試用的遍歷序列
        int[] preorder =  {3, 9, 20, 15, 7};
        int[] inorder =   {9, 3, 15, 20, 7};
        int[] postorder = {9, 15, 7, 20, 3};

        // 1. 前序+中序重建
        TreeNode root1 = buildTreeFromPreIn(preorder, inorder);
        System.out.println("前序+中序重建的樹:");
        System.out.print("前序: ");
        printPreOrder(root1);
        System.out.println();
        System.out.print("中序: ");
        printInOrder(root1);
        System.out.println();
        System.out.print("後序: ");
        printPostOrder(root1);
        System.out.println("\n");

        // 2. 後序+中序重建
        TreeNode root2 = buildTreeFromPostIn(postorder, inorder);
        System.out.println("後序+中序重建的樹:");
        System.out.print("前序: ");
        printPreOrder(root2);
        System.out.println();
        System.out.print("中序: ");
        printInOrder(root2);
        System.out.println();
        System.out.print("後序: ");
        printPostOrder(root2);
        System.out.println();
    }
}

