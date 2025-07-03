public class array_mode_count_map {
    public static void main(String[] args) {
        int[] arr = {3, 7, 3, 1, 1, 1};

        int mode = arr[0];
        int maxCount = 0;

        // 用來記錄是否已經比對過該值
        boolean[] visited = new boolean[arr.length];

        for (int i = 0; i < arr.length; i++) {
            if (visited[i]) continue; // 如果已經比對過，就跳過

            int count = 0;

            for (int j = 0; j < arr.length; j++) {
                if (arr[j] == arr[i]) {
                    count++;
                    visited[j] = true; // 標記這個值已比對過
                }
            }

            System.out.println("比對中：" + arr[i] + " 出現次數 = " + count);

            if (count > maxCount) {
                maxCount = count;
                mode = arr[i];
            }
        }

        System.out.println("眾數為：" + mode + "，出現 " + maxCount + " 次");
    }
}