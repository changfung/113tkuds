import java.util.Arrays;

public class ArrayUtility {
    public static void printArray(int[] array) {
        System.out.println(Arrays.toString(array));
    }

    public static void reverseArray(int[] array) {
        int left = 0;
        int right = array.length - 1;
        while (left < right) {
            int temp = array[left];
            array[left] = array[right];
            array[right] = temp;
            left++;
            right--;
        }
    }

    public static int[] copyArray(int[] array) {
        int[] copy = new int[array.length];
        for (int i = 0; i < array.length; i++) {
            copy[i] = array[i];
        }
        return copy;
    }

    public static int findSecondLargest(int[] array) {
        int largest = Integer.MIN_VALUE;
        int second = Integer.MIN_VALUE;

        for (int num : array) {
            if (num > largest) {
                second = largest;
                largest = num;
            } else if (num > second && num < largest) {
                second = num;
            }
        }

        return second;
    }

    public static void main(String[] args) {
        int[] original = {3, 7, 1, 9, 4, 6, 8, 2, 5};

        System.out.println("原始陣列:");
        printArray(original);

        int[] copy = copyArray(original);
        System.out.println("\n複製陣列:");
        printArray(copy);

        reverseArray(original);
        System.out.println("\n原地反轉後的陣列:");
        printArray(original);

        int secondLargest = findSecondLargest(original);
        System.out.println("\n陣列中的第二大數值: " + secondLargest);
    }
}

