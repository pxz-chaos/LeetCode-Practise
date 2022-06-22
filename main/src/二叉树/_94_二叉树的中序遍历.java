package 二叉树;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName _94_二叉树的中序遍历
 * @Description TODO
 * @Author Zhang Peixin
 * @Date 2021/12/13 10:30
 * @Version 1.0
 */
/*
给定一个二叉树的根节点 root ，返回它的 中序 遍历。
输入：root = [1,null,2,3]
输出：[1,3,2]
示例 2：

输入：root = []
输出：[]
示例 3：

输入：root = [1]
输出：[1]

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/binary-tree-inorder-traversal
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class _94_二叉树的中序遍历 {
    List<Integer> list = new ArrayList<>();

    public List<Integer> inorderTraversal(TreeNode root) {
        inOrder(root);
        return list;

    }


    private void inOrder(TreeNode node) {
        if (node == null) return;
        inOrder(node.left);
        list.add(node.val);
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
}
