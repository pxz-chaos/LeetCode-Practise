package JianZhiOffer;

/**
 * @ClassName demo01
 * @Description TODO
 * @Author Zhang Peixin
 * @Date 2021/11/12 16:24
 * @Version 1.0
 */
/*
    请实现一个函数，把字符串 s 中的每个空格替换成"%20"。

?

示例 1：

输入：s = "We are happy."
输出："We%20are%20happy."

作者：Krahets
链接：https://leetcode-cn.com/leetbook/read/illustration-of-algorithm/50ywkd/
来源：力扣（LeetCode）
著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
 */
public class demo01 {
    public static void main(String[] args) {
        String s = "We are happy.";
        System.out.println(replaceSpace(s));
    }

    public static String replaceSpace(String s) {

        String str = s.replace(" ", "%20");
        return str;
    }
}
