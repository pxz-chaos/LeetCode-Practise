package 二叉树;

import java.util.*;

/**
 * @ClassName _173_二叉搜索树迭代器
 * @Description TODO
 * @Author Zhang Peixin
 * @Date 2021/12/14 9:45
 * @Version 1.0
 */
/*
实现一个二叉搜索树迭代器类BSTIterator ，表示一个按中序遍历二叉搜索树（BST）的迭代器：
BSTIterator(TreeNode root) 初始化 BSTIterator 类的一个对象。BST 的根节点 root 会作为构造函数的一部分给出。指针应初始化为一个不存在于 BST 中的数字，且该数字小于 BST 中的任何元素。
boolean hasNext() 如果向指针右侧遍历存在数字，则返回 true ；否则返回 false 。
int next()将指针向右移动，然后返回指针处的数字。
注意，指针初始化为一个不存在于 BST 中的数字，所以对 next() 的首次调用将返回 BST 中的最小元素。

你可以假设?next()?调用总是有效的，也就是说，当调用 next()?时，BST 的中序遍历中至少存在一个下一个数字。

?

示例：


输入
["BSTIterator", "next", "next", "hasNext", "next", "hasNext", "next", "hasNext", "next", "hasNext"]
[[[7, 3, 15, null, null, 9, 20]], [], [], [], [], [], [], [], [], []]
输出
[null, 3, 7, true, 9, true, 15, true, 20, false]

解释
BSTIterator bSTIterator = new BSTIterator([7, 3, 15, null, null, 9, 20]);
bSTIterator.next();    // 返回 3
bSTIterator.next();    // 返回 7
bSTIterator.hasNext(); // 返回 True
bSTIterator.next();    // 返回 9
bSTIterator.hasNext(); // 返回 True
bSTIterator.next();    // 返回 15
bSTIterator.hasNext(); // 返回 True
bSTIterator.next();    // 返回 20
bSTIterator.hasNext(); // 返回 False
?

提示：

树中节点的数目在范围 [1, 105] 内
0 <= Node.val <= 106
最多调用 105 次 hasNext 和 next 操作

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/binary-search-tree-iterator
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class _173_二叉搜索树迭代器 {

    Queue<Integer> queue;

    public _173_二叉搜索树迭代器(TreeNode root) {
        queue = new LinkedList<>();
        inOrder(root);
    }

    public int next() {

        return queue.poll();
    }

    public boolean hasNext() {

        return !queue.isEmpty();
    }

    private void inOrder(TreeNode node) {
        if (node == null) return;
        inOrder(node.left);
        queue.add(node.val);
        inOrder(node.right);
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

    public static void main(String[] args) {
        Set<Integer> set = new LinkedHashSet<>();
        set.add(10);
        set.add(20);
        set.add(30);
        Integer next = set.iterator().next();
        System.out.println(next);
    }
}
