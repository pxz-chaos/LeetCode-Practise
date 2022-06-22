package 二叉树;



import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName _109_有序链表转换二叉搜索树
 * @Description TODO
 * @Author Zhang Peixin
 * @Date 2021/12/14 21:44
 * @Version 1.0
 */
/*
给定一个单链表，其中的元素按升序排序，将其转换为高度平衡的二叉搜索树。

本题中，一个高度平衡二叉树是指一个二叉树每个节点?的左右两个子树的高度差的绝对值不超过 1。

示例:

给定的有序链表： [-10, -3, 0, 5, 9],

一个可能的答案是：[0, -3, 9, -10, null, 5], 它可以表示下面这个高度平衡二叉搜索树：

      0
     / \
   -3   9
   /   /
 -10  5
通过次数100,593提交次数131,969
请问您在哪类招聘中遇到此题？

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/convert-sorted-list-to-binary-search-tree
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class _109_有序链表转换二叉搜索树 {
    List<Integer> list = new ArrayList<>();

    public TreeNode sortedListToBST(ListNode head) {

        if (head == null) return null;
        addToBST(head);
        System.out.println(list.size());
        return add(list, 0, list.size() - 1);
    }

    public TreeNode add(List<Integer> list, int minIndex, int maxIndex) {
        if (minIndex > maxIndex) {
            return null;
        }
        int mid = (minIndex + maxIndex) / 2;
        TreeNode node = new TreeNode(list.get(mid));
        node.left = add(list, minIndex, mid - 1);
        node.right = add(list, mid + 1, maxIndex);

        return node;
    }

    private void addToBST(ListNode node) {
        if (node == null) return;
        ListNode tmp = node;
        while (tmp != null) {
            list.add(tmp.val);
            tmp = tmp.next;
        }
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
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
