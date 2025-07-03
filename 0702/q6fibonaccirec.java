import java.util.Scanner;

public class q6fibonaccirec {
    static int callCount = 0;

    public static int fib(int n) {
        callCount++; 
        if (n == 0) return 0;
        if (n == 1) return 1;
        return fib(n - 1) + fib(n - 2);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();

        int result = fib(n);
        System.out.println(result);
        System.out.println(callCount);
    }
}