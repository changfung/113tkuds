import java.util.Scanner;

public class ds_03 {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        System.out.println("your name:");
        String name = scanner.nextLine();
        System.out.println("your age:");
        int age = scanner.nextInt();
        System.out.println("your city:");
        String city = scanner.nextLine();
        System.out.println(name+age+city);
        scanner.close();

    }
    
}
