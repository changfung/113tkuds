import java.util.ArrayList;

public class BSTRangeQuery {

    // 節點定義
    static class TreeNode {
        int data;
        TreeNode left, right;

        TreeNode(int data) {
            this.data = data;
        }
    }

    // 主函數：回傳範圍內的節點值（已排序）
    public static ArrayList<Integer> rangeQuery(TreeNode root, int min, int max) {
        ArrayList<Integer> result = new ArrayList<>();
        inOrderRange(root, min, max, result);
        return result;
    }

    // 中序走訪 + 範圍判斷
    private static void inOrderRange(TreeNode node, int min, int max, ArrayList<Integer> result) {
        if (node == null) return;

        // 只有在有可能在範圍內的子樹才走訪
        if (node.data > min) {
            inOrderRange(node.left, min, max, result);
        }

        if (node.data >= min && node.data <= max) {
            result.add(node.data);
        }

        if (node.data < max) {
            inOrderRange(node.right, min, max, result);
        }
    }

    public static void main(String[] args) {
        // 建立 BST：[20, 10, 30, 5, 15, 25, 35]
        TreeNode root = new TreeNode(20);
        root.left = new TreeNode(10);
        root.right = new TreeNode(30);
        root.left.left = new TreeNode(5);
        root.left.right = new TreeNode(15);
        root.right.left = new TreeNode(25);
        root.right.right = new TreeNode(35);

        // 範圍查詢 [12, 27]
        ArrayList<Integer> result = rangeQuery(root, 12, 27);
        System.out.println("範圍 [12, 27] 的節點值: " + result);  // 應輸出 [15, 20, 25]
    }
}

