package 二叉树;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @ClassName _102_二叉树的层序遍历
 * @Description TODO
 * @Author Zhang Peixin
 * @Date 2021/12/15 12:24
 * @Version 1.0
 */
public class _102_二叉树的层序遍历 {
    public List<List<Integer>> levelOrder(TreeNode root) {
        if (root == null) return new ArrayList<>();

        List<List<Integer>> list = new ArrayList<>();

        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.add(root);

        while (!queue.isEmpty()) {
             int count=queue.size();
            List<Integer> list1 = new ArrayList<Integer>();
            while (count > 0) {

                TreeNode node = queue.poll();
                list1.add(node.val);

                if (node.left != null) queue.offer(node.left);
                if (node.right != null) queue.offer(node.right);
                count--;
            }
            list.add(list1);
        }
        return list;
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
