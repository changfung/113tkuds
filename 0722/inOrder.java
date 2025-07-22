// 假設 TreeNode 類別已定義如下：
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

public class inOrder {

    // 中序走訪：左 -> 根 -> 右
    public static void inOrder(TreeNode root) {
        if (root == null) {
            return;
        }
        inOrder(root.left);           // 走訪左子樹
        System.out.print(root.data + " ");  // 拜訪根節點
        inOrder(root.right);          // 走訪右子樹
    }

    public static void main(String[] args) {
        /*
            測試樹結構：
                1
               / \
              2   3
             / \
            4   5
            中序應為：4 2 5 1 3
        */
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);

        System.out.print("中序走訪結果：");
        inOrder(root);  // 輸出：4 2 5 1 3
    }
}

