public class SimpleBinaryTree {
    static class TreeNode {
        int data;
        TreeNode left;
        TreeNode right;

        public TreeNode(int data) {
            this.data = data;
        }
    }

    // 印出樹的結構（橫向，右邊在上，左邊在下）
    public static void printTree(TreeNode node, int level) {
        if (node == null) {
            return;
        }

        printTree(node.right, level + 1);  // 先印右子樹

        for (int i = 0; i < level; i++) {
            System.out.print("    ");  // 縮排用
        }
        System.out.println(node.data);  // 印出目前節點

        printTree(node.left, level + 1);  // 再印左子樹
    }

    public static void main(String[] args) {
        // 建立一個簡單的二元樹
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);

        // 顯示結構（純資料）
        System.out.println("樹的結構:");
        System.out.println("根節點: " + root.data);
        System.out.println("左子樹: " + root.left.data);
        System.out.println("右子樹: " + root.right.data);
        System.out.println("左子樹的左子樹: " + root.left.left.data);
        System.out.println("左子樹的右子樹: " + root.left.right.data);

        // 使用 printTree 印出圖形結構
        System.out.println("\n圖形化樹的結構:");
        printTree(root, 0);
    }
}

