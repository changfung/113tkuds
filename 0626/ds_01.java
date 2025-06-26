import java.util.Scanner;

public class ds_01 {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        System.out.println("n1:");
        int n1 = scanner.nextInt();
        System.out.println("n2:");
        int n2 = scanner.nextInt();
        int sum = n1 + n2;
        System.out.println("ans:" + sum);
        scanner.close();

    }
}
