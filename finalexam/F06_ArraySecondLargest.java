import java.util.*;

public class F06_ArraySecondLargest {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        int[] result = findMaxSecond(arr, 0, n - 1); // result[0] = max, result[1] = second max
        System.out.println("SecondMax: " + result[1]);
    }

    static int[] findMaxSecond(int[] arr, int left, int right) {
        if (left == right) {
            return new int[] { arr[left], Integer.MIN_VALUE };
        }

        int mid = (left + right) / 2;
        int[] leftPair = findMaxSecond(arr, left, mid);
        int[] rightPair = findMaxSecond(arr, mid + 1, right);

        int max, second;

        if (leftPair[0] > rightPair[0]) {
            max = leftPair[0];
            second = Math.max(leftPair[1], rightPair[0]);
        } else {
            max = rightPair[0];
            second = Math.max(rightPair[1], leftPair[0]);
        }

        return new int[] { max, second };
    }
}

/*
 * Time Complexity: O(n)
 * 說明：每層遞迴會把陣列分成兩半，共有 log n 層，且每層會做常數次合併比較（O(1)），
 * 因此整體時間複雜度為 O(n)。
 *
 * Space Complexity: O(log n)
 * 說明：每次遞迴佔用一層呼叫堆疊，最深為 log n 層，因此空間複雜度為 O(log n)。
 */

