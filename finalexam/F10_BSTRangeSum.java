import java.util.*;

public class F10_BSTRangeSum {
    static class TreeNode {
        int val;
        TreeNode left, right;
        TreeNode(int v) { val = v; }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

    
        String[] tokens = sc.nextLine().split(" ");
        TreeNode root = buildTree(tokens);

        int L = sc.nextInt();
        int R = sc.nextInt();

        int sum = rangeSumBST(root, L, R);
        System.out.println(sum);
    }

    
    static TreeNode buildTree(String[] data) {
        if (data.length == 0 || data[0].equals("-1")) return null;

        TreeNode root = new TreeNode(Integer.parseInt(data[0]));
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int i = 1;

        while (i < data.length) {
            TreeNode cur = queue.poll();

            if (i < data.length && !data[i].equals("-1")) {
                cur.left = new TreeNode(Integer.parseInt(data[i]));
                queue.offer(cur.left);
            }
            i++;

            if (i < data.length && !data[i].equals("-1")) {
                cur.right = new TreeNode(Integer.parseInt(data[i]));
                queue.offer(cur.right);
            }
            i++;
        }
        return root;
    }

    
    static int rangeSumBST(TreeNode root, int L, int R) {
        if (root == null) return 0;

        if (root.val < L) {
            
            return rangeSumBST(root.right, L, R);
        } else if (root.val > R) {
            
            return rangeSumBST(root.left, L, R);
        } else {
            
            return root.val + rangeSumBST(root.left, L, R) + rangeSumBST(root.right, L, R);
        }
    }
}



