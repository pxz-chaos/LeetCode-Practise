package 二叉树;

/**
 * @ClassName _450_删除二叉搜索树中的节点
 * @Description TODO
 * @Author Zhang Peixin
 * @Date 2021/12/7 22:17
 * @Version 1.0
 */
public class _450_删除二叉搜索树中的节点 {
    TreeNode parent;

    public TreeNode deleteNode(TreeNode root, int key) {
        return null;
    }

    public TreeNode predecessor(TreeNode node) {
        //前驱结点就是该节点的最右的那个节点
        //比如中序遍历为，1,2,3,4,5,6,7,8
        //7的前驱结点就是6
        if (node == null) return null;

        // 前驱节点在左子树当中（left.right.right.right....）
        TreeNode p = node.left;
        if (p != null) {
            while (p.right != null) {
                p = p.right;
            }
            return p;
        }

        // 从父节点、祖父节点中寻找前驱节点
       /* while (node.parent != null && node == node.parent.left) {
            node = node.parent;
        }


        return node.parent;*/

        return null;
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
