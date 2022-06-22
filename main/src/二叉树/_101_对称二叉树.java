package 二叉树;

/**
 * @ClassName _101_对称二叉树
 * @Description TODO
 * @Author Zhang Peixin
 * @Date 2021/12/15 11:41
 * @Version 1.0
 */
public class _101_对称二叉树 {
    public boolean isSymmetric(TreeNode root) {
        return check(root, root);

    }

    private boolean check(TreeNode p, TreeNode q) {
        if (p == null && q == null) {
            return true;
        } else if (p == null || q == null) {
            return false;
        } else if (p.val != q.val) {
            return false;
        }

        return check(p.left, q.right) && check(p.right, q.left);
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
