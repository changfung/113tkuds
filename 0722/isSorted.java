public class isSorted {

    public static boolean isSorted(int[] arr, int index) {
        // 停止條件：到達陣列結尾或只有一個元素
        if (index >= arr.length - 1) {
            return true;
        }

        // 若目前元素大於下一個元素，則非升序
        if (arr[index] > arr[index + 1]) {
            return false;
        }

        // 遞迴檢查下一個索引
        return isSorted(arr, index + 1);
    }

    public static void main(String[] args) {
        int[] arr1 = {1, 2, 3, 4, 5};
        int[] arr2 = {3, 2, 1};
        int[] arr3 = {5};
        int[] arr4 = {1, 2, 2, 3}; // 可包含相等元素，仍算升序

        System.out.println("arr1 是否升序？ " + isSorted(arr1, 0)); // true
        System.out.println("arr2 是否升序？ " + isSorted(arr2, 0)); // false
        System.out.println("arr3 是否升序？ " + isSorted(arr3, 0)); // true
        System.out.println("arr4 是否升序？ " + isSorted(arr4, 0)); // true
    }
}

