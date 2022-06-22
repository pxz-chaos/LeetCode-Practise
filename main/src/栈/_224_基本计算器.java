package 栈;

import java.util.Stack;

/**
 * @ClassName _224_基本计算器
 * @Description TODO
 * @Author Zhang Peixin
 * @Date 2021/11/25 11:30
 * @Version 1.0
 */
/*
给你一个字符串表达式 s ，请你实现一个基本计算器来计算并返回它的值。

?

示例 1：

输入：s = "1 + 1"
输出：2
示例 2：

输入：s = " 2-1 + 2 "
输出：3
示例 3：

输入：s = "(1+(4+5+2)-3)+(6+8)"
输出：23
?

提示：

1 <= s.length <= 3?* 105
s 由数字、'+'、'-'、'('、')'、和 ' ' 组成
s 表示一个有效的表达式

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/basic-calculator
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class _224_基本计算器 {
    public int calculate(String s) {
        int len = s.length();
        for (int i = 0; i < len; i++) {
            if (s.charAt(i) == '(') s += s.replace('(', ' ').replace(')', ' ');
        }
        return 0;
    }

    private static boolean isNumber(String str) {
        return ("+".equals(str) || "-".equals(str) || "(".equals(str) || ")".equals(str)) ? false : true;
    }

    public static void main(String[] args) {
        String s = "(1+(4+5+2)-3)+(6+8)";
        char[] chars = s.toCharArray();
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < chars.length; i++) {
            String str = String.valueOf(chars[i]);
            /*if(isNumber(str)){//是数字
               stack.push(Integer.parseInt(str));
            }
            else {
                if(str.equals("("))
            }*/
            System.out.println(str);
        }
    }
}
