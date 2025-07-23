import java.util.*;

public class TreeLevelTraversal {

    static class TreeNode {
        int data;
        TreeNode left, right;

        TreeNode(int data) {
            this.data = data;
        }
    }

    // 1️⃣ 每層節點分層儲存
    public static List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) return result;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> level = new ArrayList<>();

            for (int i = 0; i < size; i++) {
                TreeNode current = queue.poll();
                level.add(current.data);

                if (current.left != null) queue.offer(current.left);
                if (current.right != null) queue.offer(current.right);
            }

            result.add(level);
        }

        return result;
    }

    // 2️⃣ 之字形層序遍歷
    public static List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) return result;

        Queue<TreeNode> queue = new LinkedList<>();
        boolean leftToRight = true;
        queue.offer(root);

        while (!queue.isEmpty()) {
            int size = queue.size();
            LinkedList<Integer> level = new LinkedList<>();

            for (int i = 0; i < size; i++) {
                TreeNode current = queue.poll();

                if (leftToRight) {
                    level.addLast(current.data);
                } else {
                    level.addFirst(current.data);
                }

                if (current.left != null) queue.offer(current.left);
                if (current.right != null) queue.offer(current.right);
            }

            result.add(level);
            leftToRight = !leftToRight;
        }

        return result;
    }

    // 3️⃣ 只印出每層的最後一個節點
    public static void printLastNodeOfEachLevel(TreeNode root) {
        if (root == null) return;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        System.out.print("每層最後一個節點: ");
        while (!queue.isEmpty()) {
            int size = queue.size();
            TreeNode last = null;

            for (int i = 0; i < size; i++) {
                TreeNode current = queue.poll();
                last = current;

                if (current.left != null) queue.offer(current.left);
                if (current.right != null) queue.offer(current.right);
            }

            // 印出當層最後一個節點
            if (last != null) {
                System.out.print(last.data + " ");
            }
        }
        System.out.println();
    }

    public static void main(String[] args) {
        // 測試樹：[1, 2, 3, 4, 5, 6, 7]
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);

        // 1️⃣ 分層儲存
        System.out.println("普通層序遍歷：");
        List<List<Integer>> levels = levelOrder(root);
        for (List<Integer> level : levels) {
            System.out.println(level);
        }

        // 2️⃣ 之字形層序遍歷
        System.out.println("\n之字形層序遍歷：");
        List<List<Integer>> zigzagLevels = zigzagLevelOrder(root);
        for (List<Integer> level : zigzagLevels) {
            System.out.println(level);
        }

        // 3️⃣ 印出每層最後一個節點
        System.out.println("\n只印出每層最後一個節點：");
        printLastNodeOfEachLevel(root);
    }
}

