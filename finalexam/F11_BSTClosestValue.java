import java.util.*;

public class F11_BSTClosestValue {
    static class TreeNode {
        int val;
        TreeNode left, right;
        TreeNode(int v) { val = v; }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        
        String[] tokens = sc.nextLine().split(" ");
        TreeNode root = buildTree(tokens);

        int target = sc.nextInt();

        int closest = findClosestValue(root, target);
        System.out.println(closest);
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

    
    static int findClosestValue(TreeNode root, int target) {
        int closest = root.val;
        TreeNode curr = root;

        while (curr != null) {
            int currDiff = Math.abs(curr.val - target);
            int closestDiff = Math.abs(closest - target);

            if (currDiff < closestDiff) {
                closest = curr.val;
            } else if (currDiff == closestDiff && curr.val < closest) {
              
                closest = curr.val;
            }

            if (target < curr.val) {
                curr = curr.left;
            } else if (target > curr.val) {
                curr = curr.right;
            } else {
               
                return curr.val;
            }
        }

        return closest;
    }
}



