import java.util.Scanner;

public class temperture {
    public static void main(String[] args) {
        Scanner sc =new Scanner(System.in);
        int C =sc.nextInt();
        int F =(C * 9/5) + 32;
        System.out.println(F);
    }
}
