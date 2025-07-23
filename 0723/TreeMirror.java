public class TreeMirror {

    static class TreeNode {
        int data;
        TreeNode left, right;

        TreeNode(int data) {
            this.data = data;
        }
    }

    // 1️⃣ 判斷是否為對稱樹（左右互為鏡像）
    public static boolean isSymmetric(TreeNode root) {
        if (root == null) return true;
        return isMirror(root.left, root.right);
    }

    // 輔助函式：比較兩棵子樹是否互為鏡像
    private static boolean isMirror(TreeNode t1, TreeNode t2) {
        if (t1 == null && t2 == null) return true;
        if (t1 == null || t2 == null) return false;
        return t1.data == t2.data &&
               isMirror(t1.left, t2.right) &&
               isMirror(t1.right, t2.left);
    }

    // 2️⃣ 將一棵樹轉換為鏡像樹（直接修改原樹）
    public static void mirror(TreeNode root) {
        if (root == null) return;
        // 先遞迴左右子樹
        mirror(root.left);
        mirror(root.right);
        // 再交換左右子節點
        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;
    }

    // 3️⃣ 比較兩棵樹是否互為鏡像
    public static boolean areMirrors(TreeNode t1, TreeNode t2) {
        return isMirror(t1, t2);
    }

    // 中序走訪（可用於觀察鏡像效果）
    public static void inorder(TreeNode root) {
        if (root == null) return;
        inorder(root.left);
        System.out.print(root.data + " ");
        inorder(root.right);
    }

    public static void main(String[] args) {
        // 測試用樹（對稱樹）
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(2);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(4);
        root.right.left = new TreeNode(4);
        root.right.right = new TreeNode(3);

        System.out.println("是否為對稱樹: " + isSymmetric(root)); // true

        System.out.print("中序遍歷（原樹）: ");
        inorder(root); // 3 2 4 1 4 2 3
        System.out.println();

        // 鏡像樹
        mirror(root);
        System.out.print("中序遍歷（鏡像後）: ");
        inorder(root); // 3 2 4 1 4 2 3（其實也是對稱的）
        System.out.println();

        // 比較兩棵樹是否為鏡像
        TreeNode treeA = new TreeNode(1);
        treeA.left = new TreeNode(2);
        treeA.right = new TreeNode(3);

        TreeNode treeB = new TreeNode(1);
        treeB.left = new TreeNode(3);
        treeB.right = new TreeNode(2);

        System.out.println("treeA 和 treeB 是否互為鏡像: " + areMirrors(treeA, treeB)); // true
    }
}
