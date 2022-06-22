package 二叉树;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @ClassName _110_平衡二叉树
 * @Description TODO
 * @Author Zhang Peixin
 * @Date 2021/12/9 9:53
 * @Version 1.0
 */
/*
给定一个二叉树，判断它是否是高度平衡的二叉树。

本题中，一棵高度平衡二叉树定义为：

一个二叉树每个节点?的左右两个子树的高度差的绝对值不超过 1 。

?

示例 1：


输入：root = [3,9,20,null,null,15,7]
输出：true
示例 2：


输入：root = [1,2,2,3,3,null,null,4,4]
输出：false
示例 3：

输入：root = []
输出：true
?

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/balanced-binary-tree
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。

 */
public class _110_平衡二叉树 {
    public boolean isBalanced(TreeNode root) {
        if (root == null) return true;

        return Math.abs(height1(root.left) - height1(root.right)) <= 1;
    }


    private int height(TreeNode node) {
        if (node == null) return 0;
        //使用层序遍历
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(node);
        int size = 0;
        int height = 1;
        while (!queue.isEmpty()) {
            TreeNode pollNode = queue.poll();
            size--;
            if (pollNode.left != null) queue.offer(pollNode);
            if (pollNode.right != null) queue.offer(pollNode);
            if (size == 0) {
                size = queue.size();
                height++;
            }
        }

        return height;
    }

    private int height1(TreeNode node){
        //采用递归的方法
        if (node == null) return 0;
        return Math.max(height1(node.left), height1(node.right)) + 1;
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
}
