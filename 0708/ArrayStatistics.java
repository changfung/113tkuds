public class ArrayStatistics {

    public static void main(String[] args) {
        int[] numbers = {5, 12, 8, 15, 7, 23, 18, 9, 14, 6};
        int sum = 0;
        int max = numbers[0];
        int min = numbers[0];
        int maxIndex = 0;
        int minIndex = 0;
        int countAboveAverage = 0;
        int evenCount = 0;
        int oddCount = 0;

        for (int i = 0; i < numbers.length; i++) {
            int num = numbers[i];
            sum += num;

            if (num > max) {
                max = num;
                maxIndex = i;
            }

            if (num < min) {
                min = num;
                minIndex = i;
            }

            if (num % 2 == 0) {
                evenCount++;
            } else {
                oddCount++;
            }
        }

        double average = (double) sum / numbers.length;

        for (int num : numbers) {
            if (num > average) {
                countAboveAverage++;
            }
        }

        System.out.println("========== 陣列統計分析 ==========");
        System.out.printf("%-20s: %d%n", "總和", sum);
        System.out.printf("%-20s: %.2f%n", "平均值", average);
        System.out.printf("%-20s: %d (索引 %d)%n", "最大值", max, maxIndex);
        System.out.printf("%-20s: %d (索引 %d)%n", "最小值", min, minIndex);
        System.out.printf("%-20s: %d%n", "大於平均值的數量", countAboveAverage);
        System.out.printf("%-20s: %d%n", "偶數數量", evenCount);
        System.out.printf("%-20s: %d%n", "奇數數量", oddCount);
        System.out.println("==================================");
    }
}

