package 二叉树;

/**
 * @ClassName _108_将有序数组转换为二叉搜索树
 * @Description TODO
 * @Author Zhang Peixin
 * @Date 2021/12/6 20:50
 * @Version 1.0
 */
/*
给你一个整数数组 nums ，其中元素已经按 升序 排列，请你将其转换为一棵 高度平衡 二叉搜索树。

高度平衡 二叉树是一棵满足「每个节点的左右两个子树的高度差的绝对值不超过 1 」的二叉树。

?

示例 1：


输入：nums = [-10,-3,0,5,9]
输出：[0,-3,9,-10,null,5]
解释：[0,-10,5,null,-3,null,9] 也将被视为正确答案：

示例 2：


输入：nums = [1,3]
输出：[3,1]
解释：[1,3] 和 [3,1] 都是高度平衡二叉搜索树。
?

提示：

1 <= nums.length <= 104
-104 <= nums[i] <= 104
nums 按 严格递增 顺序排列

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/convert-sorted-array-to-binary-search-tree
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class _108_将有序数组转换为二叉搜索树 {
    public final static int[] NUMS = {-10, -3, 6, 5, 9};

    private TreeNode root;
    private int size;

    public TreeNode sortedArrayToBST(int[] nums) {

        return add(nums, 0, nums.length - 1);
    }

    public TreeNode add(int[] nums, int minIndex, int maxIndex) {
        if (minIndex > maxIndex) {
            return null;
        }
        int mid = (minIndex + maxIndex) / 2;
        TreeNode node = new TreeNode(nums[mid]);
        node.left = add(nums, minIndex, mid - 1);
        node.right = add(nums, mid + 1, maxIndex);

        return node;
    }

    public void pre() {
        root = sortedArrayToBST(NUMS);
        pre(root);
    }

    private void pre(TreeNode node) {
        if (node == null) return;
        System.out.println(node.val);
        pre(node.left);
        pre(node.right);


    }

    public void inOrder() {
        root = sortedArrayToBST(NUMS);
        inOrder(root);
    }

    private void inOrder(TreeNode node) {
        if (node == null) return;

        inOrder(node.left);
        System.out.println(node.val);
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

    public static void main(String[] args) {
        _108_将有序数组转换为二叉搜索树 v = new _108_将有序数组转换为二叉搜索树();

        v.pre();//前序遍历
        System.out.println("======");
        v.inOrder();//中序遍历
    }
}
