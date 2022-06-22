package 二叉树;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @ClassName _700_二叉搜索树中的搜索
 * @Description TODO
 * @Author Zhang Peixin
 * @Date 2021/12/7 10:05
 * @Version 1.0
 */
public class _700_二叉搜索树中的搜索 {
    private TreeNode root;
    private int size;

    public TreeNode searchBST(TreeNode root, int val) {

        if (root == null) return null;
        if (root.val == val) return root;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            if (node.val == val) return node;
            if (node.left != null) queue.offer(node.left);
            if (node.right != null) queue.offer(node.right);
        }
        return null;
    }

    /**
     * 采用递归的方法
     *
     * @param root
     * @param val
     * @return
     */
    public TreeNode searchBST1(TreeNode root, int val) {
        if (root == null) return null;
        if (root.val == val) return root;
        return root.val > val ? searchBST1(root.left, val) : searchBST1(root.right, val);
    }
    public TreeNode searchBST2(TreeNode root, int val) {
        while (root != null && root.val != val) {
            root = root.val > val ? root.left : root.right;
        }
        return root;
    }
    public TreeNode searchBST3(TreeNode root, int val) {

        if(root==null) return null;
        inOrder(root, val);
        return tmp;
    }
    TreeNode tmp=null;

    private void inOrder(TreeNode node,int val){
        if(node==null) return;
        inOrder(node.left,val);
        if(node.val==val){
            tmp=node;
        }
        inOrder(node.right,val);

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
