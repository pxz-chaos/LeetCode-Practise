package 链表;

/**
 * @ClassName _142_环形链表II
 * @Description TODO
 * @Author Zhang Peixin
 * @Date 2021/11/22 16:23
 * @Version 1.0
 */
/*
给定一个链表，返回链表开始入环的第一个节点。?如果链表无环，则返回?null。

如果链表中有某个节点，可以通过连续跟踪 next 指针再次到达，则链表中存在环。 为了表示给定链表中的环，评测系统内部使用整数 pos 来表示链表尾连接到链表中的位置（索引从 0 开始）。如果 pos 是 -1，则在该链表中没有环。注意：pos 不作为参数进行传递，仅仅是为了标识链表的实际情况。

不允许修改 链表。

?

示例 1：



输入：head = [3,2,0,-4], pos = 1
输出：返回索引为 1 的链表节点
解释：链表中有一个环，其尾部连接到第二个节点。
示例?2：



输入：head = [1,2], pos = 0
输出：返回索引为 0 的链表节点
解释：链表中有一个环，其尾部连接到第一个节点。
示例 3：



输入：head = [1], pos = -1
输出：返回 null
解释：链表中没有环。

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/linked-list-cycle-ii
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class _142_环形链表II {
    public ListNode detectCycle(ListNode head) {
        //判断有没有环？
        //这里采用快慢指针
        //定义一个快指针和慢指针
        ListNode slow = head, fast = head;

        //如果只有一个元素或者为空的时候，直接返回null
        if (head == null || head.next == null) return null;
        //开始判断有没有环
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                ListNode point = head;//头节点不能动，所以来个辅助指针
                while (point != slow) {

                    slow = slow.next;
                    point=point.next;
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
