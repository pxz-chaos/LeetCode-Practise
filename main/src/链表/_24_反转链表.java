package 链表;

/**
 * @ClassName _反转链表
 * @Description TODO
 * @Author Zhang Peixin
 * @Date 2021/11/20 15:04
 * @Version 1.0
 */
/*
定义一个函数，输入一个链表的头节点，反转该链表并输出反转后链表的头节点。

?

示例:

输入: 1->2->3->4->5->NULL
输出: 5->4->3->2->1->NULL

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/fan-zhuan-lian-biao-lcof
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class _24_反转链表 {


    public ListNode reverseList(ListNode head) {
        ListNode temp = head;
        ListNode newHead = null;

        if (head == null || head.next == null) return head;
        while (true) {
            if (temp == null) {
                break;
            }
            ListNode next = temp.next;//暂存一下
            //交换
            temp.next = newHead;
            newHead= temp;
            temp = next;//后移
        }

        return newHead;
    }

    // Definition for singly-linked list.
    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

}
