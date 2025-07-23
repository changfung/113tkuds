public class TreeComparison {

    static class TreeNode {
        int data;
        TreeNode left, right;

        TreeNode(int data) {
            this.data = data;
        }
    }

    // 1️⃣ 判斷兩個樹是否完全相同
    public static boolean isSameTree(TreeNode s, TreeNode t) {
        if (s == null && t == null) return true;
        if (s == null || t == null) return false;
        if (s.data != t.data) return false;
        return isSameTree(s.left, t.left) && isSameTree(s.right, t.right);
    }

    // 2️⃣ 判斷 t 是否是 s 的子樹
    public static boolean isSubtree(TreeNode s, TreeNode t) {
        if (t == null) return true;  // 空樹是所有樹的子樹
        if (s == null) return false;
        if (isSameTree(s, t)) return true;
        return isSubtree(s.left, t) || isSubtree(s.right, t);
    }

    // 3️⃣ 找出兩個樹的最大公共子樹 (返回最大公共子樹的根節點)
    // 方法：用遞迴找出兩樹相同的子樹，紀錄最大大小的子樹根節點
    // 輔助類別儲存結果
    static class Result {
        TreeNode node = null;
        int size = 0;
    }

    public static TreeNode largestCommonSubtree(TreeNode root1, TreeNode root2) {
        Result res = new Result();
        largestCommonSubtreeHelper(root1, root2, res);
        return res.node;
    }

    // 回傳以 root1、root2 為根的子樹大小，並更新 Result
    private static int largestCommonSubtreeHelper(TreeNode n1, TreeNode n2, Result res) {
        if (n1 == null || n2 == null) return 0;

        if (n1.data == n2.data) {
            int leftSize = largestCommonSubtreeHelper(n1.left, n2.left, res);
            int rightSize = largestCommonSubtreeHelper(n1.right, n2.right, res);

            int totalSize = leftSize + rightSize + 1;
            if (totalSize > res.size) {
                res.size = totalSize;
                res.node = n1;  // 或 n2，都一樣大小
            }
            return totalSize;
        } else {
            // 這裡不相等，子樹不能繼續匹配，改為0
            largestCommonSubtreeHelper(n1.left, n2, res);
            largestCommonSubtreeHelper(n1.right, n2, res);
            largestCommonSubtreeHelper(n1, n2.left, res);
            largestCommonSubtreeHelper(n1, n2.right, res);
            return 0;
        }
    }

    // 輔助印出中序
    public static void printInOrder(TreeNode root) {
        if (root == null) return;
        printInOrder(root.left);
        System.out.print(root.data + " ");
        printInOrder(root.right);
    }

    public static void main(String[] args) {
        // 範例樹 s
        TreeNode s = new TreeNode(3);
        s.left = new TreeNode(4);
        s.right = new TreeNode(5);
        s.left.left = new TreeNode(1);
        s.left.right = new TreeNode(2);

        // 範例樹 t
        TreeNode t = new TreeNode(4);
        t.left = new TreeNode(1);
        t.right = new TreeNode(2);

        // 1. 判斷兩樹是否完全相同
        System.out.println("兩樹是否完全相同？ " + isSameTree(s, t)); // false

        // 2. 判斷 t 是否為 s 的子樹
        System.out.println("t 是否為 s 的子樹？ " + isSubtree(s, t)); // true

        // 3. 找最大公共子樹
        TreeNode lcs = largestCommonSubtree(s, t);
        System.out.print("最大公共子樹中序遍歷: ");
        printInOrder(lcs);  // 印出最大公共子樹的節點值
        System.out.println();
    }
}

