package Reverse;

import java.util.Arrays;
import java.util.Collections;

/**
 * @ClassName Demo01IntReverse
 * @Description TODO
 * @Author Zhang Peixin
 * @Date 2021/10/19 14:36
 * @Version 1.0
 */
/*
    给你一个 32 位的有符号整数 x ，返回将 x 中的数字部分反转后的结果。
    如果反转后整数超过 32 位的有符号整数的范围 [?2的31次方,  2的31 ? 1] ，就返回 0。
    假设环境不允许存储 64 位整数（有符号或无符号）。

    示例 1：

输入：x = 123
输出：321
示例 2：

输入：x = -123
输出：-321
示例 3：

输入：x = 120
输出：21
示例 4：

输入：x = 0
输出：0

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/reverse-integer
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Demo01IntReverse {
    public static void main(String[] args) {
        int reverse = reverse(777845321);
        System.out.println(reverse);
    }

    public static int reverse(int x) {

        int rev = 0;
        while (x != 0) {
            if (rev < Math.pow(-2, 31) || rev > Math.pow(2, 31)-1) {
                return 0;
            }
            int digit = x % 10; //取出个位数，例如x=126,此时digit=6,第二次循环，digit=2,第三次循环，digit=1
            x /= 10;//此时x=12//1//0
            rev = rev * 10 + digit;//rev=0*10+6//6*10+2=62//62*10+1=621
        }
        return rev;
    }
}
