public class GradeProcessor {
    public static void main(String[] args) {
        int[] grades = {78, 85, 92, 67, 88, 95, 73, 90};

        int total = 0;
        int max = grades[0];
        int min = grades[0];
        int maxIndex = 0;
        int minIndex = 0;

        for (int i = 0; i < grades.length; i++) {
            total += grades[i];

            if (grades[i] > max) {
                max = grades[i];
                maxIndex = i;
            }

            if (grades[i] < min) {
                min = grades[i];
                minIndex = i;
            }
        }

        double average = (double) total / grades.length;

        System.out.println("總分: " + total);
        System.out.printf("平均分數: %.2f\n", average);
        System.out.println("最高分: " + max + "，索引位置: " + maxIndex);
        System.out.println("最低分: " + min + "，索引位置: " + minIndex);

        int countAboveAverage = 0;
        for (int grade : grades) {
            if (grade > average) {
                countAboveAverage++;
            }
        }
        System.out.println("超過平均分的學生人數: " + countAboveAverage);
        System.out.println("\n學生成績列表:");
        for (int i = 0; i < grades.length; i++) {
            System.out.println("學生編號 " + (i + 1) + ": " + grades[i]);
        }
    }
}

