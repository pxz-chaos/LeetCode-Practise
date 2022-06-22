package 链表;

/**
 * @ClassName _23_合并K个升序链表
 * @Description TODO
 * @Author Zhang Peixin
 * @Date 2021/12/17 11:21
 * @Version 1.0
 */
/*
给你一个链表数组，每个链表都已经按升序排列。

请你将所有链表合并到一个升序链表中，返回合并后的链表。

?

示例 1：

输入：lists = [[1,4,5],[1,3,4],[2,6]]
输出：[1,1,2,3,4,4,5,6]
解释：链表数组如下：
[
  1->4->5,
  1->3->4,
  2->6
]
将它们合并到一个有序链表中得到。
1->1->2->3->4->4->5->6
示例 2：

输入：lists = []
输出：[]
示例 3：

输入：lists = [[]]
输出：[]
?

提示：

k == lists.length
0 <= k <= 10^4
0 <= lists[i].length <= 500
-10^4 <= lists[i][j] <= 10^4
lists[i] 按 升序 排列
lists[i].length 的总和不超过 10^4

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/merge-k-sorted-lists
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class _23_合并K个升序链表 {
    public ListNode mergeKLists(ListNode[] lists) {
        ListNode list = null;
        int i = 0;
        while (i < lists.length) {
            list = mergeTwoLists(list, lists[i]);
            i++;
        }
        return list;
    }

    private ListNode mergeTwoLists(ListNode l1, ListNode l2) {

        ListNode prehead = new ListNode(-1);

        ListNode prev = prehead;
        while (l1 != null && l2 != null) {
            if (l1.val <= l2.val) {
                prev.next = l1;
                l1 = l1.next;
            } else {
                prev.next = l2;
                l2 = l2.next;
            }
            prev = prev.next;
        }

        // 合并后 l1 和 l2 最多只有一个还未被合并完，我们直接将链表末尾指向未合并完的链表即可，这个也考虑了l1或者l2不为空的情况
        prev.next = l1 == null ? l2 : l1;

        return prehead.next;

    }

    public ListNode mergeKLists1(ListNode[] lists) {

        if (lists.length < 1) {
            return null;
        } else if (lists.length == 1) {
            return lists[0];
        }

        int k = lists.length - 1;
        while (k > 0) {
            int index = 0;  //表示两条链表合并完毕后插入的数组下标
            for (int i = 0; i <= k; i += 2) {
                if (i == k) {  //表示k此时指向的链表是落单的链表
                    lists[index] = lists[i];
                    index++;
                } else {
                    lists[index] = mergeTwoLists(lists[i], lists[i + 1]);
                    index++;
                }
            }
            k = index - 1;
        }

        //当上述循环退出的时候，表示数组中只剩余最后一条链表

        return lists[0];
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
