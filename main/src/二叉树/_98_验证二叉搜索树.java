package ������;

import javax.print.DocFlavor;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.concurrent.TimeUnit;

/**
 * @ClassName _98_��֤����������
 * @Description TODO
 * @Author Zhang Peixin
 * @Date 2021/12/7 10:49
 * @Version 1.0
 */
public class _98_��֤���������� {
    private ArrayList<Integer> list = new ArrayList<>();
    long pre = Long.MIN_VALUE;

    public boolean isValidBST(TreeNode root) {

        inOrder(root);//�������
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
        // ����������
        if (!isValidBST(root.left)) {
            return false;
        }
        // ���ʵ�ǰ�ڵ㣺�����ǰ�ڵ�С�ڵ������������ǰһ���ڵ㣬˵��������BST������ false���������������
        if (root.val <= pre) {
            return false;
        }
        pre = root.val;
        // ����������
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
