public class BSTKthElement {

    static class TreeNode {
        int data;
        TreeNode left, right;

        TreeNode(int data) {
            this.data = data;
        }
    }

    // 用來追蹤中序過程中目前的計數與結果
    static class Counter {
        int count = 0;      // 已拜訪的節點數
        int result = -1;    // 存放第k小的值
    }

    // 主函式：找出第k小的值
    public static int findKthSmallest(TreeNode root, int k) {
        Counter counter = new Counter();
        inOrderKth(root, k, counter);
        return counter.result;
    }

    // 中序走訪 + 早停機制
    private static void inOrderKth(TreeNode node, int k, Counter counter) {
        if (node == null || counter.count >= k) return;

        inOrderKth(node.left, k, counter);  // 左子樹

        counter.count++;
        if (counter.count == k) {
            counter.result = node.data;
            return;
        }

        inOrderKth(node.right, k, counter); // 右子樹
    }

    public static void main(String[] args) {
        // 建立 BST: [20, 10, 30, 5, 15, 25, 35]
        TreeNode root = new TreeNode(20);
        root.left = new TreeNode(10);
        root.right = new TreeNode(30);
        root.left.left = new TreeNode(5);
        root.left.right = new TreeNode(15);
        root.right.left = new TreeNode(25);
        root.right.right = new TreeNode(35);

        // 測試不同 k 值
        for (int k = 1; k <= 7; k++) {
            int value = findKthSmallest(root, k);
            System.out.println("第 " + k + " 小的元素是: " + value);
        }
    }
}

