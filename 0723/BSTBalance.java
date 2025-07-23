public class BSTBalance {

    static class TreeNode {
        int data;
        TreeNode left, right;
        TreeNode(int data) {
            this.data = data;
        }
    }

    // 1️⃣ 判斷是否為平衡樹
    public static boolean isBalanced(TreeNode root) {
        return checkBalance(root) != -1;
    }

    // 回傳高度，如果不平衡則回傳 -1
    private static int checkBalance(TreeNode node) {
        if (node == null) return 0;

        int leftHeight = checkBalance(node.left);
        int rightHeight = checkBalance(node.right);

        if (leftHeight == -1 || rightHeight == -1) return -1;
        if (Math.abs(leftHeight - rightHeight) > 1) return -1;

        return Math.max(leftHeight, rightHeight) + 1;
    }

    // 2️⃣ 計算節點的平衡因子：左子樹高度 - 右子樹高度
    public static int getBalanceFactor(TreeNode node) {
        return height(node.left) - height(node.right);
    }

    private static int height(TreeNode node) {
        if (node == null) return 0;
        return 1 + Math.max(height(node.left), height(node.right));
    }

    // 3️⃣ 找出最不平衡的節點（平衡因子絕對值最大）
    static class ImbalanceResult {
        TreeNode node;
        int maxImbalance;

        ImbalanceResult() {
            maxImbalance = -1;
        }
    }

    public static TreeNode findMostUnbalancedNode(TreeNode root) {
        ImbalanceResult result = new ImbalanceResult();
        findImbalance(root, result);
        return result.node;
    }

    private static void findImbalance(TreeNode node, ImbalanceResult result) {
        if (node == null) return;

        int balanceFactor = getBalanceFactor(node);
        int absImbalance = Math.abs(balanceFactor);

        if (absImbalance > result.maxImbalance) {
            result.maxImbalance = absImbalance;
            result.node = node;
        }

        findImbalance(node.left, result);
        findImbalance(node.right, result);
    }

    // 輔助：中序列印
    public static void printInOrder(TreeNode root) {
        if (root == null) return;
        printInOrder(root.left);
        System.out.print(root.data + " ");
        printInOrder(root.right);
    }

    public static void main(String[] args) {
        // 建立一個不平衡的 BST
        TreeNode root = new TreeNode(10);
        root.left = new TreeNode(5);
        root.left.left = new TreeNode(3);
        root.left.left.left = new TreeNode(1);
        root.right = new TreeNode(15);

        System.out.print("BST 中序遍歷: ");
        printInOrder(root);
        System.out.println();

        // 1. 判斷是否平衡
        System.out.println("是否為平衡樹: " + isBalanced(root));

        // 2. 根節點平衡因子
        System.out.println("根節點平衡因子: " + getBalanceFactor(root));

        // 3. 找出最不平衡的節點
        TreeNode worst = findMostUnbalancedNode(root);
        if (worst != null) {
            System.out.println("最不平衡節點: " + worst.data);
            System.out.println("其平衡因子: " + getBalanceFactor(worst));
        }
    }
}

