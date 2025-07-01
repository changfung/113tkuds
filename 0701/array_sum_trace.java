public class array_sum_trace {
    public static void main(String[] args) {
        int[] arr = {1, 3, 5};  
        int total = 0;

        for (int i = 0; i < arr.length; i++) {
            int before = total;
            total += arr[i];
            System.out.println("加總過程：total = " + before + " + " + arr[i] + " = " + total);
        }

        System.out.println("總和為：" + total);
    }
}
