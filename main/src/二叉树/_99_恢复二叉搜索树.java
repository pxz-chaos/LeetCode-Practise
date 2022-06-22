package ¶þ²æÊ÷;

/**
 * @ClassName _99_»Ö¸´¶þ²æËÑË÷Ê÷
 * @Description TODO
 * @Author Zhang Peixin
 * @Date 2021/12/14 10:36
 * @Version 1.0
 */
public class _99_»Ö¸´¶þ²æËÑË÷Ê÷ {
    TreeNode t1, t2, pre;

    public void recoverTree(TreeNode root) {
        inorder(root);
        int temp = t1.val;
        t1.val = t2.val;
        t2.val = temp;
    }

    public void inorder(TreeNode node) {
        if (node == null) return;
        inorder(node.left);
        if (pre != null && pre.val > node.val) {
            if (t1 == null) t1 = pre;
            t2 = node;
        }
        pre = node;
        inorder(node.right);
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
