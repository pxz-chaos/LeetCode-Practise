package 链表;

/**
 * @ClassName _237_删除链表中的节点
 * @Description TODO
 * @Author Zhang Peixin
 * @Date 2021/11/20 14:42
 * @Version 1.0
 */
/*
输入：head = [4,5,1,9], node = 5
输出：[4,1,9]
解释：指定链表中值为?5?的第二个节点，那么在调用了你的函数之后，该链表应变为 4 -> 1 -> 9

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/delete-node-in-a-linked-list
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */

/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode(int x) { val = x; }
 * }
 */
public class _237_删除链表中的节点 {
    public void deleteNode(ListNode node) {
        //没有头节点，只有待删除的节点3
        //因为node只知道下级，不知道上级。所以直接删除自己是不可能的。
        //那我们就直接把node搞成node的下一级，把下一级删除不就完了吗
        //4,5,1,9->4,1,1,9->4,1,9
        node.val = node.next.val;
        node.next = node.next.next;

    }
}

class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}