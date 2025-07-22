public class fibonacci {

    public static int fibonacci(int n) {
        // 基本情況：前兩項固定為 0 和 1
        if (n == 0) return 0;
        if (n == 1) return 1;

        // 遞迴關係：fib(n) = fib(n-1) + fib(n-2)
        return fibonacci(n - 1) + fibonacci(n - 2);
    }

    public static void main(String[] args) {
        System.out.println("fibonacci(0) = " + fibonacci(0));  // 0
        System.out.println("fibonacci(1) = " + fibonacci(1));  // 1
        System.out.println("fibonacci(5) = " + fibonacci(5));  // 5
        System.out.println("fibonacci(10) = " + fibonacci(10)); // 55
    }
}

