import java.util.Scanner;

public class FactorialExampleinput {

    // 計算階乘
    public static int factorial(int n) {
        if (n <= 1) {
            return 1;
        }
        return n * factorial(n - 1);
    }

    // 產生計算步驟字串
    public static String factorialWithSteps(int n) {
        if (n == 0) {
            return "1"; // 0! 特例
        }

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
        Scanner scanner = new Scanner(System.in);
        System.out.print("請輸入一個非負整數：");

        if (scanner.hasNextInt()) {
            int input = scanner.nextInt();
            if (input < 0) {
                System.out.println("錯誤：請輸入非負整數。");
            } else {
                System.out.println(input + "! = " + factorialWithSteps(input));
            }
        } else {
            System.out.println("錯誤：輸入不是整數。");
        }

        scanner.close();
    }
}

