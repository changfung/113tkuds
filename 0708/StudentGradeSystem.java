public class StudentGradeSystem {

    public static char getGrade(int score) {
        if (score >= 90) return 'A';
        else if (score >= 80) return 'B';
        else if (score >= 70) return 'C';
        else return 'D';
    }

    public static void printGradeReport(int[] scores) {
        int aCount = 0, bCount = 0, cCount = 0, dCount = 0;
        int total = 0;
        int maxScore = scores[0], minScore = scores[0];
        int maxIndex = 0, minIndex = 0;

        for (int i = 0; i < scores.length; i++) {
            int score = scores[i];
            total += score;

            if (score > maxScore) {
                maxScore = score;
                maxIndex = i;
            }
            if (score < minScore) {
                minScore = score;
                minIndex = i;
            }

            char grade = getGrade(score);
            switch (grade) {
                case 'A': aCount++; break;
                case 'B': bCount++; break;
                case 'C': cCount++; break;
                case 'D': dCount++; break;
            }
        }

        double average = (double) total / scores.length;

        int aboveAverageCount = 0;
        for (int score : scores) {
            if (score > average) {
                aboveAverageCount++;
            }
        }
        double aboveAverageRate = ((double) aboveAverageCount / scores.length) * 100;

        System.out.println("====== 學生成績報告 ======");
        System.out.println("總人數: " + scores.length);
        System.out.printf("全班平均分數: %.2f%n", average);
        System.out.println("最高分: " + maxScore + "（學生編號 " + (maxIndex + 1) + "）");
        System.out.println("最低分: " + minScore + "（學生編號 " + (minIndex + 1) + "）");
        System.out.printf("高於平均的學生比例: %.1f%%\n", aboveAverageRate);

        System.out.println("\n--- 等級分布 ---");
        System.out.println("A 等級人數: " + aCount);
        System.out.println("B 等級人數: " + bCount);
        System.out.println("C 等級人數: " + cCount);
        System.out.println("D 等級人數: " + dCount);

        System.out.println("\n--- 詳細成績列表 ---");
        System.out.println("編號\t分數\t等級");
        System.out.println("-----------------------");
        for (int i = 0; i < scores.length; i++) {
            System.out.printf("%d\t%d\t%c%n", (i + 1), scores[i], getGrade(scores[i]));
        }

        System.out.println("========================");
    }

    public static void main(String[] args) {
        int[] scores = {85, 92, 78, 96, 87, 73, 89, 94, 81, 88};

        printGradeReport(scores);
    }
}

