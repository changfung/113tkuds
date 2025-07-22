// 節點定義
class ListNode {
    int val;
    ListNode next;

    public ListNode(int val) {
        this.val = val;
        this.next = null;
    }
}

public class printReverse {

    // 使用遞迴反向列印
    public static void printReverse(ListNode head) {
        if (head == null) {
            return;
        }
        printReverse(head.next);  // 遞迴到底
        System.out.print(head.val + " "); // 回溯時列印
    }

    public static void main(String[] args) {
        // 建立測試鏈結串列：1 -> 2 -> 3 -> 4 -> 5
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);

        System.out.print("反向列印結果：");
        printReverse(head);  // 輸出：5 4 3 2 1
    }
}

