public class TreeStatistics {

    // 定義樹節點
    static class TreeNode {
        int data;
        TreeNode left, right;

        TreeNode(int data) {
            this.data = data;
        }
    }

    // 計算節點總和
    public static int sum(TreeNode root) {
        if (root == null) return 0;
        return root.data + sum(root.left) + sum(root.right);
    }

    // 找出最大值
    public static int findMax(TreeNode root) {
        if (root == null) return Integer.MIN_VALUE;
        int maxLeft = findMax(root.left);
        int maxRight = findMax(root.right);
        return Math.max(root.data, Math.max(maxLeft, maxRight));
    }

    // 找出最小值
    public static int findMin(TreeNode root) {
        if (root == null) return Integer.MAX_VALUE;
        int minLeft = findMin(root.left);
        int minRight = findMin(root.right);
        return Math.min(root.data, Math.min(minLeft, minRight));
    }

    // 計算葉節點數量
    public static int countLeaves(TreeNode root) {
        if (root == null) return 0;
        if (root.left == null && root.right == null) return 1;
        return countLeaves(root.left) + countLeaves(root.right);
    }

    // 計算樹的高度（深度）
    public static int height(TreeNode root) {
        if (root == null) return 0;
        return 1 + Math.max(height(root.left), height(root.right));
    }

    public static void main(String[] args) {
        // 建立一棵測試用的樹
        TreeNode root = new TreeNode(10);
        root.left = new TreeNode(5);
        root.right = new TreeNode(20);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(7);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(25);

        // 執行統計功能
        System.out.println("節點總和: " + sum(root));                     // 10+5+20+3+7+15+25 = 85
        System.out.println("最大值: " + findMax(root));                   // 25
        System.out.println("最小值: " + findMin(root));                   // 3
        System.out.println("葉節點數量: " + countLeaves(root));           // 4 (3,7,15,25)
        System.out.println("樹的高度: " + height(root));                  // 3
    }
}

