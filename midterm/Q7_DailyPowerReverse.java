import java.util.*;

public class Q7_DailyPowerReverse {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int[] usage = new int[7];
        for (int i = 0; i < 7; i++) {
            usage[i] = sc.nextInt();
        }

        // 雙指標原地交換
        int left = 0, right = 6;
        while (left < right) {
            int temp = usage[left];
            usage[left] = usage[right];
            usage[right] = temp;
            left++;
            right--;
        }

        // 輸出反轉後的用電量
        for (int i = 0; i < 7; i++) {
            System.out.print(usage[i]);
            if (i < 6) System.out.print(" ");
        }
        System.out.println();

        sc.close();
    }
}



