package 链表;

import java.util.HashMap;

/**
 * @ClassName _141_环形链表
 * @Description TODO
 * @Author Zhang Peixin
 * @Date 2021/11/21 12:54
 * @Version 1.0
 */
/*
给你一个链表的头节点 head ，判断链表中是否有环。

如果链表中有某个节点，可以通过连续跟踪 next 指针再次到达，则链表中存在环。 为了表示给定链表中的环，评测系统内部使用整数 pos 来表示链表尾连接到链表中的位置（索引从 0 开始）。如果 pos 是 -1，则在该链表中没有环。注意：pos 不作为参数进行传递，仅仅是为了标识链表的实际情况。

如果链表中存在环，则返回 true 。 否则，返回 false 。

?

示例 1：



输入：head = [3,2,0,-4], pos = 1
输出：true
解释：链表中有一个环，其尾部连接到第二个节点。

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/linked-list-cycle
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class _141_环形链表 {
    public static boolean hasCycle(ListNode head) {

        if (head == null || head.next == null) return false;
        //快慢指针等价于相遇问题，如果他们绕着环形路径跑，一个慢，一个快，总有相遇的时刻，如果不是环形，永远都不会相遇
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            //fast走两步，slow走一步
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) return true;
        }

        return false;
    }


    public static void main(String[] args) {
        ListNode head = new ListNode(0);
        head.next = new ListNode(1);
        head.next.next=head;
        System.out.println(hasCycle(head));
    }

    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }
}
