public class gcd {

    // 使用遞迴實作歐幾里德演算法
    public static int gcd(int a, int b) {
        if (b == 0) {
            return a; // 當 b 為 0 時，a 即為最大公因數
        }
        return gcd(b, a % b); // 遞迴呼叫
    }

    public static void main(String[] args) {
        System.out.println("GCD(48, 18) = " + gcd(48, 18)); // 6
        System.out.println("GCD(100, 25) = " + gcd(100, 25)); // 25
        System.out.println("GCD(7, 3) = " + gcd(7, 3)); // 1
    }
}