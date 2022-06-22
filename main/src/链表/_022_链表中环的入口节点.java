package 链表;

/**
 * @ClassName _022_链表中环的入口节点
 * @Description TODO
 * @Author Zhang Peixin
 * @Date 2021/11/21 16:12
 * @Version 1.0
 */
/*
给定一个链表，返回链表开始入环的第一个节点。 从链表的头节点开始沿着 next 指针进入环的第一个节点为环的入口节点。如果链表无环，则返回?null。

为了表示给定链表中的环，我们使用整数 pos 来表示链表尾连接到链表中的位置（索引从 0 开始）。 如果 pos 是 -1，则在该链表中没有环。注意，pos 仅仅是用于标识环的情况，并不会作为参数传递到函数中。

说明：不允许修改给定的链表。

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/c32eOV
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class _022_链表中环的入口节点 {
    public static void main(String[] args) {

    }

    public ListNode detectCycle(ListNode head) {
        //先判断有没有环
        if (head == null || head.next == null) return null;
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                //point与slow相遇就为环的入口

                //根据数学推导，s到环入口的路程刚好是头节点到环的入口的路程
                ListNode point = head;
                while (point != slow) {
                    point = point.next;
                    slow = slow.next;
                }
                return point;
            }
        }
        return null;
    }


    class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }
}
