public class FactorialExample {

    // 計算階乘
    public static int factorial(int n) {
        if (n <= 1) {
            return 1;
        }
        return n * factorial(n - 1);
    }

    // 產生計算步驟字串
    public static String factorialWithSteps(int n) {
        StringBuilder steps = new StringBuilder();
        int result = 1;

        for (int i = n; i > 0; i--) {
            result *= i;
            steps.append(i);
            if (i > 1) {
                steps.append(" x ");
            }
        }

        steps.append(" = ").append(result);
        return steps.toString();
    }

    public static void main(String[] args) {
        System.out.println("3! = " + factorialWithSteps(3)); // 輸出：3! = 3 x 2 x 1 = 6
        System.out.println("5! = " + factorialWithSteps(5)); // 輸出：5! = 5 x 4 x 3 x 2 x 1 = 120
        System.out.println("0! = 1"); // 特例，0! = 1
    }
}

