import java.util.Scanner;

public class showname {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNextLine()){
            System.out.println(sc.nextLine());
        }
        sc.close();

    }
}

