import java.util.*;

public class TreePathProblems {

    static class TreeNode {
        int data;
        TreeNode left, right;

        TreeNode(int data) {
            this.data = data;
        }
    }

    // 1️⃣ 找出所有根到葉節點的路徑
    public static List<List<Integer>> allPaths(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> currentPath = new ArrayList<>();
        dfsPaths(root, currentPath, result);
        return result;
    }

    private static void dfsPaths(TreeNode node, List<Integer> path, List<List<Integer>> result) {
        if (node == null) return;

        path.add(node.data);

        if (node.left == null && node.right == null) {
            result.add(new ArrayList<>(path));  // 是葉節點 → 儲存路徑
        } else {
            dfsPaths(node.left, path, result);
            dfsPaths(node.right, path, result);
        }

        path.remove(path.size() - 1);  // 回溯
    }

    // 2️⃣ 判斷是否存在總和為目標的根到葉節點路徑
    public static boolean hasPathSum(TreeNode root, int targetSum) {
        if (root == null) return false;

        // 是葉節點且總和正好
        if (root.left == null && root.right == null) {
            return targetSum == root.data;
        }

        // 遞迴檢查左右子樹
        int newTarget = targetSum - root.data;
        return hasPathSum(root.left, newTarget) || hasPathSum(root.right, newTarget);
    }

    // 3️⃣ 找出總和最大的根到葉節點路徑
    public static List<Integer> maxSumPath(TreeNode root) {
        List<Integer> maxPath = new ArrayList<>();
        maxSumPathHelper(root, new ArrayList<>(), 0, new int[]{Integer.MIN_VALUE}, maxPath);
        return maxPath;
    }

    private static void maxSumPathHelper(TreeNode node, List<Integer> currentPath, int currentSum,
                                         int[] maxSum, List<Integer> maxPath) {
        if (node == null) return;

        currentPath.add(node.data);
        currentSum += node.data;

        if (node.left == null && node.right == null) {
            if (currentSum > maxSum[0]) {
                maxSum[0] = currentSum;
                maxPath.clear();
                maxPath.addAll(new ArrayList<>(currentPath));
            }
        } else {
            maxSumPathHelper(node.left, currentPath, currentSum, maxSum, maxPath);
            maxSumPathHelper(node.right, currentPath, currentSum, maxSum, maxPath);
        }

        currentPath.remove(currentPath.size() - 1);  // 回溯
    }

    public static void main(String[] args) {
        /*
         測試樹結構：
                 5
                / \
               4   8
              /   / \
             11  13  4
            /  \       \
           7    2       1

         路徑總和：例如 5→4→11→2 = 22
         最大路徑：5→8→4→1 = 18
         */
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(4);
        root.right = new TreeNode(8);
        root.left.left = new TreeNode(11);
        root.left.left.left = new TreeNode(7);
        root.left.left.right = new TreeNode(2);
        root.right.left = new TreeNode(13);
        root.right.right = new TreeNode(4);
        root.right.right.right = new TreeNode(1);

        // 1️⃣ 所有根到葉的路徑
        System.out.println("所有根到葉節點的路徑：");
        List<List<Integer>> paths = allPaths(root);
        for (List<Integer> path : paths) {
            System.out.println(path);
        }

        // 2️⃣ 是否存在某目標總和的路徑
        int targetSum = 22;
        System.out.println("\n是否存在總和為 " + targetSum + " 的路徑: " + hasPathSum(root, targetSum));

        // 3️⃣ 最大總和路徑
        List<Integer> maxPath = maxSumPath(root);
        System.out.println("\n最大總和路徑: " + maxPath);
    }
}

