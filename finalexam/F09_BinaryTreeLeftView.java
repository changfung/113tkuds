import java.util.*;

public class F09_BinaryTreeLeftView {
    static class TreeNode {
        int val;
        TreeNode left, right;
        TreeNode(int v) {
            val = v;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        
        String[] tokens = sc.nextLine().split(" ");
        TreeNode root = buildTree(tokens);

        List<Integer> leftView = getLeftView(root);

        System.out.print("LeftView:");
        for (int val : leftView) {
            System.out.print(" " + val);
        }
        System.out.println();
    }

    
    static TreeNode buildTree(String[] data) {
        if (data.length == 0 || data[0].equals("-1")) return null;

        TreeNode root = new TreeNode(Integer.parseInt(data[0]));
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int i = 1;

        while (i < data.length) {
            TreeNode current = queue.poll();

            
            if (i < data.length && !data[i].equals("-1")) {
                current.left = new TreeNode(Integer.parseInt(data[i]));
                queue.offer(current.left);
            }
            i++;

            
            if (i < data.length && !data[i].equals("-1")) {
                current.right = new TreeNode(Integer.parseInt(data[i]));
                queue.offer(current.right);
            }
            i++;
        }

        return root;
    }

    static List<Integer> getLeftView(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) return result;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            int levelSize = queue.size();
            for (int i = 0; i < levelSize; i++) {
                TreeNode curr = queue.poll();
                if (i == 0) {
                    result.add(curr.val);
                }
                if (curr.left != null) queue.offer(curr.left);
                if (curr.right != null) queue.offer(curr.right);
            }
        }

        return result;
    }
}


