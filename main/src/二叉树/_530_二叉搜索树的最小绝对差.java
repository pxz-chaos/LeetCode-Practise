package 二叉树;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @ClassName _530_二叉搜索树的最小绝对差
 * @Description TODO
 * @Author Zhang Peixin
 * @Date 2021/12/13 17:34
 * @Version 1.0
 */
/*
给你一个二叉搜索树的根节点 root ，返回 树中任意两不同节点值之间的最小差值 。

差值是一个正数，其数值等于两值之差的绝对值。

?

示例 1：


输入：root = [4,2,6,1,3]
输出：1
示例 2：


输入：root = [1,0,48,null,null,12,49]
输出：1
?

提示：

树中节点的数目范围是 [2, 104]
0 <= Node.val <= 105
?

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/minimum-absolute-difference-in-bst
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class _530_二叉搜索树的最小绝对差 {
    List<Integer> list = new ArrayList<>();
    int pre;
    int ans;

    public int getMinimumDifference(TreeNode root) {
       /* if (root == null) return 0;
        inOrder(root);

        int min = list.get(1) - list.get(0);
        for (int i = 0; i < list.size() - 1; i++) {
            int result = list.get(i + 1) - list.get(i);
            if (min > result) {
                min = result;
            }
        }*/
        ans = Integer.MAX_VALUE;
        pre = -1;
        inOrder1(root);
        return ans;
    }

    private void inOrder(TreeNode node) {
        if (node == null) return;
        inOrder(node.left);
        list.add(node.val);
        inOrder(node.right);
    }

    private void inOrder1(TreeNode node) {
        if (node == null) return;
        inOrder1(node.left);
        if (pre == -1) {
            pre = node.val;
        } else {
            ans = Math.min(ans, node.val - pre);
            pre = node.val;
        }
        inOrder1(node.right);
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
