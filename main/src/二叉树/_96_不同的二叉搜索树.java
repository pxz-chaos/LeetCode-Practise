package 二叉树;

/**
 * @ClassName _96_不同的二叉搜索树
 * @Description TODO
 * @Author Zhang Peixin
 * @Date 2021/12/13 11:19
 * @Version 1.0
 */
public class _96_不同的二叉搜索树 {
    public int numTrees(int n) {
        int[] G = new int[n + 1];
        G[0] = 1;
        G[1] = 1;

        for (int i = 2; i <= n; ++i) {
            for (int j = 1; j <= i; ++j) {
                G[i] += G[j - 1] * G[i - j];
            }
        }
        return G[n];
    }

   /* 作者：LeetCode-Solution
    链接：https://leetcode-cn.com/problems/unique-binary-search-trees/solution/bu-tong-de-er-cha-sou-suo-shu-by-leetcode-solution/
    来源：力扣（LeetCode）
    著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。*/
}
