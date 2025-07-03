import java.util.Scanner;

public class ASCII {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        char ch = sc.next().charAt(0);
        if (Character.isUpperCase(ch)) {
            int asciiValue = (int) ch;
            System.out.println(asciiValue);
        }

        sc.close();
    }
}
