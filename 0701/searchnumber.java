import java.util.Scanner;

public class searchnumber {
    public static void main(String[] args) {
        int[] s = {1, 3, 5, 7, 9, 11, 13};
        Scanner scanner = new Scanner(System.in);

        System.out.println("輸入查找數字");
        int x = scanner.nextInt();
        boolean found = false;

        for (int num : s) {
            System.out.println("比對中: x = " + x + "，目前元素 = " + num);
            if (num == x) {
                found = true;
                break;
            }
        }

        if (found) {
            System.out.println("Yes");
        } else {
            System.out.println("No");
        }

        scanner.close();
    }
}

