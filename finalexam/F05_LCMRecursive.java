import java.util.*;

public class F05_LCMRecursive {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();

        int gcd = gcdSub(a, b);
        int lcm = a * b / gcd;

        System.out.println("LCM: " + lcm);
    }

    static int gcdSub(int a, int b) {
        if (a == b) {
            return a;
        } else if (a > b) {
            return gcdSub(a - b, b);
        } else {
            return gcdSub(a, b - a);
        }
    }
}

/*
 * Time Complexity: O(max(a, b))
 * 說明：輾轉相減法每次遞迴最多減少一單位，最壞情況下需要遞迴 max(a, b) 次，因此為線性時間。
 *
 * Space Complexity: O(max(a, b))
 * 說明：每次遞迴呼叫會佔用一層呼叫堆疊，最壞情況下呼叫深度為 max(a, b)，因此空間也為線性。
 */

