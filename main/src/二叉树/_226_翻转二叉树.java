package 二叉树;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @ClassName _226_翻转二叉树
 * @Description TODO
 * @Author Zhang Peixin
 * @Date 2021/12/6 10:31
 * @Version 1.0
 */
/*
翻转一棵二叉树。

示例：

输入：

     4
   /   \
  2     7
 / \   / \
1   3 6   9
输出：

     4
   /   \
  7     2
 / \   / \
9   6 3   1
备注:

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/invert-binary-tree
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class _226_翻转二叉树 {
    /**
     * 采用前序遍历
     * @param root
     * @return
     */
    public TreeNode invertTree(TreeNode root) {
        if (root == null) return null;
        if (root.left == null && root.right == null) return root;
        //进行交换
        TreeNode tmp = root.right;
        root.right = root.left;
        root.left = tmp;

        invertTree(root.left);
        invertTree(root.right);

        return root;
    }

    /**
     * 采用层序遍历
     * @param root
     * @return
     */
    public TreeNode invertTree1(TreeNode root) {
        if (root == null) return null;
        if (root.left == null && root.right == null) return root;

        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            TreeNode tmp = node.right;
            node.right = node.left;
            node.left = tmp;
            if (node.left != null) {
                queue.offer(node.left);
            }
            if (node.right != null) {
                queue.offer(node.right);
            }
        }

        return root;
    }

    public static class TreeNode {
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


}
