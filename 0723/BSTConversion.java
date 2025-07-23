
public class BSTConversion {

    static class TreeNode {
        int data;
        TreeNode left, right;

        TreeNode(int data) {
            this.data = data;
        }
    }

    // 1️⃣ BST 轉換為排序的雙向鏈表（中序線索化）
    // 回傳雙向鏈表的head節點
    public static TreeNode bstToDoublyList(TreeNode root) {
        if (root == null) return null;

        TreeNode[] prev = new TreeNode[1];  // 保存中序遍歷時前一個節點
        TreeNode[] head = new TreeNode[1];  // 保存鏈表頭節點

        inorderToDoubly(root, prev, head);

        return head[0];
    }

    private static void inorderToDoubly(TreeNode node, TreeNode[] prev, TreeNode[] head) {
        if (node == null) return;

        inorderToDoubly(node.left, prev, head);

        if (prev[0] == null) {
            // 第一個節點，設為頭
            head[0] = node;
        } else {
            // 前一個節點的right指向當前節點，當前節點的left指向前一節點
            prev[0].right = node;
            node.left = prev[0];
        }
        prev[0] = node;

        inorderToDoubly(node.right, prev, head);
    }

    // 2️⃣ 將排序陣列轉換為平衡BST
    public static TreeNode sortedArrayToBST(int[] nums) {
        return sortedArrayToBSTHelper(nums, 0, nums.length - 1);
    }

    private static TreeNode sortedArrayToBSTHelper(int[] nums, int left, int right) {
        if (left > right) return null;

        int mid = left + (right - left) / 2;
        TreeNode root = new TreeNode(nums[mid]);

        root.left = sortedArrayToBSTHelper(nums, left, mid - 1);
        root.right = sortedArrayToBSTHelper(nums, mid + 1, right);

        return root;
    }

    // 3️⃣ BST 節點值改為所有大於等於該節點值的節點值總和（累加樹）
    public static TreeNode convertBST(TreeNode root) {
        int[] sum = new int[1];  // 累計總和
        convertBSTHelper(root, sum);
        return root;
    }

    private static void convertBSTHelper(TreeNode node, int[] sum) {
        if (node == null) return;

        // 反中序遍歷：右 → 根 → 左
        convertBSTHelper(node.right, sum);

        sum[0] += node.data;
        node.data = sum[0];

        convertBSTHelper(node.left, sum);
    }

    // ===== 方便印出中序遍歷結果 =====
    public static void printInOrder(TreeNode root) {
        if (root == null) return;
        printInOrder(root.left);
        System.out.print(root.data + " ");
        printInOrder(root.right);
    }

    // ===== 印出雙向鏈表 =====
    public static void printDoublyList(TreeNode head) {
        TreeNode current = head;
        System.out.print("雙向鏈表（正向）：");
        while (current != null) {
            System.out.print(current.data + " ");
            if (current.right == null) break;
            current = current.right;
        }
        System.out.print("\n雙向鏈表（反向）：");
        while (current != null) {
            System.out.print(current.data + " ");
            current = current.left;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        // 建立 BST 範例
        TreeNode root = new TreeNode(4);
        root.left = new TreeNode(2);
        root.right = new TreeNode(6);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(3);
        root.right.left = new TreeNode(5);
        root.right.right = new TreeNode(7);

        System.out.println("原 BST 中序遍歷:");
        printInOrder(root);
        System.out.println();

        // 1. BST轉雙向鏈表
        TreeNode head = bstToDoublyList(root);
        printDoublyList(head);

        // 2. 排序陣列轉平衡 BST
        int[] sortedArr = {1, 2, 3, 4, 5, 6, 7};
        TreeNode balancedRoot = sortedArrayToBST(sortedArr);
        System.out.println("排序陣列轉平衡BST中序遍歷:");
        printInOrder(balancedRoot);
        System.out.println();

        // 3. BST轉換為累加樹
        TreeNode convertedRoot = convertBST(balancedRoot);
        System.out.println("累加樹中序遍歷:");
        printInOrder(convertedRoot);
        System.out.println();
    }
}

