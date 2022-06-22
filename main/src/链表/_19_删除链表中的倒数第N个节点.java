package 链表;

/**
 * @ClassName _19_删除链表中的倒数第N个节点
 * @Description Run
 * @Author Zhang Peixin
 * @Date 2021/12/15 14:52
 * @Version 1.0
 */
public class _19_删除链表中的倒数第N个节点 {
    public ListNode removeNthFromEnd(ListNode head, int n) {

        int size = size(head);
        if (head.next == null) return null;//只有一个元素
        if (head.next != null && n == size) {//删除头节点
            size--;
            return head.next;
        }
        int i = 1;
        ListNode node = head;
        while (i != size - n) {
            node = node.next;
            i++;
        }

        node.next = node.next.next;
        size--;
        return head;
    }

    public int size(ListNode node) {
        int size = 0;
        if (node == null) return 0;
        while (node != null) {
            node = node.next;
            size++;
        }
        return size;
    }

   public class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    public static void main(String[] args) {
        System.out.println(10);
    }
}
