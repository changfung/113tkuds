class TreeNode {
    int data;
    TreeNode left;
    TreeNode right;

    public TreeNode(int data) {
        this.data = data;
        this.left = null;
        this.right = null;
    }
}

public class BinaryTreeExample {

    // 前序走訪：根 -> 左 -> 右
    public static void preOrder(TreeNode root) {
        if (root == null) {
            return;
        }
        System.out.print(root.data + " ");
        preOrder(root.left);
        preOrder(root.right);
    }

    // 計算樹的高度
    public static int getHeight(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int leftHeight = getHeight(root.left);
        int rightHeight = getHeight(root.right);
        return 1 + Math.max(leftHeight, rightHeight);
    }

    // 計算節點總數
    public static int countNodes(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return 1 + countNodes(root.left) + countNodes(root.right);
    }

    // 搜尋特定值
    public static boolean search(TreeNode root, int target) {
        if (root == null) {
            return false;
        }
        if (root.data == target) {
            return true;
        }
        return search(root.left, target) || search(root.right, target);
    }

    public static void main(String[] args) {
        // 建立測試樹（9 個節點，高度為 5）
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);

        root.left.left = new TreeNode(4);
        root.left.left.left = new TreeNode(6);
        root.left.left.left.left = new TreeNode(9);

        root.right.right = new TreeNode(5);
        root.right.right.right = new TreeNode(7);
        root.right.right.right.right = new TreeNode(8);

        System.out.print("前序走訪: ");
        preOrder(root);
        System.out.println();

        System.out.println("樹的高度: " + getHeight(root));   // 5
        System.out.println("節點總數: " + countNodes(root));  // 9
        System.out.println("搜尋 4: " + search(root, 4));     // true
        System.out.println("搜尋 6: " + search(root, 6));     // true
        System.out.println("搜尋 9: " + search(root, 9));     // true
        System.out.println("搜尋 10: " + search(root, 10));   // false
    }
}

