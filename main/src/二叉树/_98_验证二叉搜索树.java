package 二叉树;

import javax.print.DocFlavor;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.concurrent.TimeUnit;

/**
 * @ClassName _98_验证二叉搜索树
 * @Description TODO
 * @Author Zhang Peixin
 * @Date 2021/12/7 10:49
 * @Version 1.0
 */
public class _98_验证二叉搜索树 {
    private ArrayList<Integer> list = new ArrayList<>();
    long pre = Long.MIN_VALUE;

    public boolean isValidBST(TreeNode root) {

        inOrder(root);//中序遍历
        for (int i = 1; i < list.size(); i++) {
            if (list.get(i) <= list.get(i - 1)) return false;
        }

        return true;
    }

    private void inOrder(TreeNode node) {
        if (node == null) return;

        inOrder(node.left);
        list.add(node.val);
        inOrder(node.right);

    }

    public boolean isValidBST1(TreeNode root) {
        if (root == null) {
            return true;
        }
        // 访问左子树
        if (!isValidBST(root.left)) {
            return false;
        }
        // 访问当前节点：如果当前节点小于等于中序遍历的前一个节点，说明不满足BST，返回 false；否则继续遍历。
        if (root.val <= pre) {
            return false;
        }
        pre = root.val;
        // 访问右子树
        return isValidBST(root.right);
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
