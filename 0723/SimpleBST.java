public class SimpleBST {
    static class TreeNode {
        int data;
        TreeNode left;
        TreeNode right;
        
        public TreeNode(int data) {
            this.data = data;
        }
    }

    // 搜尋值
    public static boolean search(TreeNode root, int target) {
        if (root == null) return false;
        if (root.data == target) return true;
        
        if (target < root.data) {
            return search(root.left, target);
        } else {
            return search(root.right, target);
        }
    }

    public static void main(String[] args) {
        // 手動建立一個包含 8 個節點的 BST
        TreeNode root = new TreeNode(50);
        root.left = new TreeNode(30);
        root.right = new TreeNode(70);
        root.left.left = new TreeNode(20);
        root.left.right = new TreeNode(40);
        root.right.left = new TreeNode(60);
        root.right.right = new TreeNode(80);
        root.right.left.left = new TreeNode(55);

        // 測試搜尋 (共 5 筆)
        System.out.println("搜尋 30: " + search(root, 30));   // true
        System.out.println("搜尋 40: " + search(root, 40));   // true
        System.out.println("搜尋 60: " + search(root, 60));   // true
        System.out.println("搜尋 25: " + search(root, 25));   // false
        System.out.println("搜尋 55: " + search(root, 55));   // true
    }
}
