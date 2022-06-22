package 二叉树;

import java.util.LinkedList;

/**
 * @ClassName _951_翻转等价二叉树
 * @Description TODO
 * @Author Zhang Peixin
 * @Date 2021/12/6 11:34
 * @Version 1.0
 */
/*
我们可以为二叉树 T 定义一个翻转操作，如下所示：选择任意节点，然后交换它的左子树和右子树。

只要经过一定次数的翻转操作后，能使 X 等于 Y，我们就称二叉树 X 翻转等价于二叉树 Y。

编写一个判断两个二叉树是否是翻转等价的函数。这些树由根节点?root1 和 root2?给出。

?

示例：

输入：root1 = [1,2,3,4,5,6,null,null,null,7,8], root2 = [1,3,2,null,6,4,5,null,null,null,null,8,7]
输出：true
解释：我们翻转值为 1，3 以及 5 的三个节点。

?

提示：

每棵树最多有?100?个节点。
每棵树中的每个值都是唯一的、在 [0, 99]?范围内的整数。
?

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/flip-equivalent-binary-trees
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class _951_翻转等价二叉树 {
    public boolean flipEquiv(TreeNode root1, TreeNode root2) {

        if (root1 == null || root2 == null) return false;
        TreeNode root = invert(root1);
        LinkedList<TreeNode> queue1 = new LinkedList<>();
        LinkedList<TreeNode> queue2 = new LinkedList<>();
        queue1.offer(root);
        queue2.offer(root2);

        while (!queue1.isEmpty() && !queue2.isEmpty()) {
            TreeNode node1 = queue1.poll();
            TreeNode node2 = queue2.poll();
            if (node1.val != node2.val) {
                continue;
            }

            /*flag = node1.val == node2.val;*/

            if (node1.left != null) {
                queue1.offer(node1.left);

            }
            if (node1.right != null) {
                queue1.offer(node1.right);

            }

            if (node2.left != null) {
                queue2.offer(node2.left);
            }
            if (node2.right != null) {
                queue2.offer(node2.right);

            } else {
                return true;
            }
        }

        return false;
    }

    private TreeNode invert(TreeNode root) {
        if (root == null) return null;
        TreeNode tmp = root.right;
        root.right = root.left;
        root.left = tmp;
        invert(root.left);
        invert(root.right);
        return root;
    }

    public boolean flipEquiv1(TreeNode root1, TreeNode root2) {
        if (root1 == null && root2 == null) return true;
        if (root1 == null || root2 == null) return false;
        if (root1.val == root2.val) {
            return (flipEquiv1(root1.left, root2.left)
                    && flipEquiv(root1.right, root2.right))
                    || (flipEquiv(root1.left, root2.right)
                    && flipEquiv(root1.right, root2.left));
        }
        return false;
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
