import java.util.Random;

public class ds_06 {
    public static void main(String[] args) {
        Random random = new Random();

        int[] numbers = new int[10];

        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = random.nextInt(100) + 1; 
        }

        int max = numbers[0];
     
        for (int i = 1; i < numbers.length; i++) {
            if (numbers[i] > max) {
                max = numbers[i];
            }
        }  
        System.out.println("num：");
        for (int num : numbers) {
            System.out.print(num + " ");
        }
        System.out.println("max：" + max);
    }
}
