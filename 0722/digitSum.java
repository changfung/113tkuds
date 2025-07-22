public class digitSum {

    public static int digitSum(int n) {
        // 停止條件：當 n 為個位數時
        if (n < 10) {
            return n;
        }
        // 取出最後一位 + 遞迴剩下的部分
        return (n % 10) + digitSum(n / 10);
    }

    public static void main(String[] args) {
        System.out.println("digitSum(1234) = " + digitSum(1234)); // 10
        System.out.println("digitSum(56789) = " + digitSum(56789)); // 35
        System.out.println("digitSum(9) = " + digitSum(9)); // 9
    }
}
