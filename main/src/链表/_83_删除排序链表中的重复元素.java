package 链表;


/**
 * @ClassName _83_删除排序链表中的重复元素
 * @Description TODO
 * @Author Zhang Peixin
 * @Date 2021/11/21 15:19
 * @Version 1.0
 */
/*
存在一个按升序排列的链表，给你这个链表的头节点 head ，请你删除所有重复的元素，使每个元素 只出现一次 。
返回同样按升序排列的结果链表。
输入：head = [1,1,2]
输出：[1,2]
示例 2：
输入：head = [1,1,2,3,3]
输出：[1,2,3]
提示：

链表中节点数目在范围 [0, 300] 内
-100 <= Node.val <= 100
题目数据保证链表已经按升序排列
通过次数337,839提交次数628,012

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/remove-duplicates-from-sorted-list
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class _83_删除排序链表中的重复元素 {


    public ListNode deleteDuplicates1(ListNode head) {
        if (head == null) return null;
        ListNode p = head;
        while (p.next != null) {

            if (p.val == p.next.val) {
                p.next = p.next.next;
            } else {

                p = p.next;
            }
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
