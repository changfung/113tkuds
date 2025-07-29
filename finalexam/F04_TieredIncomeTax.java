import java.util.*;

public class F04_TieredIncomeTax {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(); 

        long totalTax = 0;

        for (int i = 0; i < n; i++) {
            int income = sc.nextInt();
            int tax = calculateTax(income);
            System.out.println("Tax: $" + tax);
            totalTax += tax;
        }

        System.out.println("Average: $" + (totalTax / n));
    }

    static int calculateTax(int income) {
        int tax = 0;

        if (income <= 560000) {
            tax = (int)(income * 0.05);
        } else if (income <= 1260000) {
            tax = (int)(560000 * 0.05 + (income - 560000) * 0.12);
        } else if (income <= 2520000) {
            tax = (int)(560000 * 0.05 + (1260000 - 560000) * 0.12 + (income - 1260000) * 0.20);
        } else if (income <= 4720000) {
            tax = (int)(560000 * 0.05 + (1260000 - 560000) * 0.12 + (2520000 - 1260000) * 0.20 + (income - 2520000) * 0.30);
        } else {
            tax = (int)(560000 * 0.05 + (1260000 - 560000) * 0.12 + (2520000 - 1260000) * 0.20
                    + (4720000 - 2520000) * 0.30 + (income - 4720000) * 0.40);
        }

        return tax;
    }
}

/*
 * Time Complexity: O(n)
 * 說明：主程式逐筆讀取 n 筆年收入並呼叫常數時間的稅額計算函式，因此整體執行時間與輸入筆數呈線性關係。
 *
 * Space Complexity: O(1)
 * 說明：只使用常數變數儲存總稅額與當前收入，不需要額外依收入筆數配置空間。
 */
