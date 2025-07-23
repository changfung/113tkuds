import java.util.*;

public class TreeDistance {

    static class TreeNode {
        int data;
        TreeNode left, right;

        TreeNode(int data) {
            this.data = data;
        }
    }

    // 1️⃣ 計算任意兩個節點間的距離
    public static int distance(TreeNode root, int a, int b) {
        TreeNode lca = findLCA(root, a, b);
        int d1 = findDepth(lca, a, 0);
        int d2 = findDepth(lca, b, 0);
        return d1 + d2;
    }

    // 找 Lowest Common Ancestor
    private static TreeNode findLCA(TreeNode root, int a, int b) {
        if (root == null) return null;
        if (root.data == a || root.data == b) return root;

        TreeNode left = findLCA(root.left, a, b);
        TreeNode right = findLCA(root.right, a, b);

        if (left != null && right != null) return root;
        return (left != null) ? left : right;
    }

    // 找從 root 到目標值的深度
    private static int findDepth(TreeNode root, int val, int depth) {
        if (root == null) return -1;
        if (root.data == val) return depth;

        int left = findDepth(root.left, val, depth + 1);
        if (left != -1) return left;

        return findDepth(root.right, val, depth + 1);
    }

    // 2️⃣ 找出樹的直徑（最長路徑）
    static class DiameterResult {
        int diameter = 0;
    }

    public static int treeDiameter(TreeNode root) {
        DiameterResult result = new DiameterResult();
        computeHeightForDiameter(root, result);
        return result.diameter;
    }

    private static int computeHeightForDiameter(TreeNode node, DiameterResult result) {
        if (node == null) return 0;

        int left = computeHeightForDiameter(node.left, result);
        int right = computeHeightForDiameter(node.right, result);

        result.diameter = Math.max(result.diameter, left + right); // 通過該節點的最大距離

        return Math.max(left, right) + 1;
    }

    // 3️⃣ 找出距離根節點為 k 的所有節點
    public static List<Integer> nodesAtDistanceK(TreeNode root, int k) {
        List<Integer> result = new ArrayList<>();
        collectNodesAtK(root, k, result);
        return result;
    }

    private static void collectNodesAtK(TreeNode node, int k, List<Integer> result) {
        if (node == null) return;
        if (k == 0) {
            result.add(node.data);
            return;
        }
        collectNodesAtK(node.left, k - 1, result);
        collectNodesAtK(node.right, k - 1, result);
    }

    // 🔁 中序遍歷
    public static void printInOrder(TreeNode root) {
        if (root == null) return;
        printInOrder(root.left);
        System.out.print(root.data + " ");
        printInOrder(root.right);
    }

    public static void main(String[] args) {
        // 建立範例樹
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.right = new TreeNode(6);
        root.left.left.left = new TreeNode(7);

        System.out.print("中序遍歷: ");
        printInOrder(root);
        System.out.println();

        // 1. 任意兩節點距離
        System.out.println("節點 7 和 5 間的距離: " + distance(root, 7, 5)); // 輸出 4

        // 2. 樹的直徑
        System.out.println("樹的直徑: " + treeDiameter(root)); // 最長路徑節點數（邊數）

        // 3. 距離根節點為 k 的節點
        int k = 2;
        List<Integer> nodes = nodesAtDistanceK(root, k);
        System.out.println("距離根節點為 " + k + " 的節點: " + nodes);
    }
}

