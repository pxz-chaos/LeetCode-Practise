package 链表;

/**
 * @ClassName _203_移除链表元素
 * @Description TODO
 * @Author Zhang Peixin
 * @Date 2021/11/21 14:29
 * @Version 1.0
 */
/*
给你一个链表的头节点 head 和一个整数 val ，请你删除链表中所有满足 Node.val == val 的节点，并返回 新的头节点 。
输入：head = [1,2,6,3,4,5,6], val = 6
输出：[1,2,3,4,5]
示例 2：

输入：head = [], val = 1
输出：[]

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/remove-linked-list-elements
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class _203_移除链表元素 {
    public ListNode removeElements(ListNode head, int val) {
        ListNode temp = head;
        if (head == null) return head;

        //删除值相同的头结点后，可能新的头结点也值相等，用循环解决
        while (head != null && head.val == val) {
            head = head.next;
        }

        boolean flag = false;
        while (temp.next != null) {
            if (temp.next.val == val) {
                flag = true;
                break;
            }
            temp = temp.next;
        }
        if (flag) {
            temp.next = temp.next.next;
            removeElements(head, val);
        }

        return head;
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
}
