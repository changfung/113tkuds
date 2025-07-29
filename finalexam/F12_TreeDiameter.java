import java.util.*;

public class F12_TreeDiameter {
    static class TreeNode {
        int val;
        TreeNode left, right;
        TreeNode(int v) { val = v; }
    }

    static int diameter = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String[] tokens = sc.nextLine().split(" ");
        TreeNode root = buildTree(tokens);

        diameter = 0;
        height(root);

        System.out.println(diameter);
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

    
    static int height(TreeNode node) {
        if (node == null) return 0;

        int leftH = height(node.left);
        int rightH = height(node.right);

        
        diameter = Math.max(diameter, leftH + rightH);

        
        return Math.max(leftH, rightH) + 1;
    }
}


