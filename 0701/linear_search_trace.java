import java.util.Scanner;

public class linear_search_trace {
    public static void main(String[] args) {
        int[] s = {1, 3, 5, 7, 9};
        Scanner scanner = new Scanner(System.in);

        System.out.print("請輸入要搜尋的數字：");
        int target = scanner.nextInt();
        boolean found = false;

        for (int num : s) {
            System.out.println("比對中：" + target + " vs " + num);
            if (num == target) {
                found = true;
                break;
            }
        }

        if (found) {
            System.out.println("結果：找到");
        } else {
            System.out.println("結果：未找到");
        }

        scanner.close();
    }
}
