import java.util.Scanner;

public class ds_02 {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        System.out.println("c1:");
        double c1 = scanner.nextDouble();
        double circle = Math.PI*c1*c1;
        System.out.println("ans:" + circle);
        scanner.close();

    }
    
}
