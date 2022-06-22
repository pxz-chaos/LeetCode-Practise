package Reverse;

/**
 * @ClassName StringReverse
 * @Description TODO
 * @Author Zhang Peixin
 * @Date 2021/10/20 8:49
 * @Version 1.0
 */
/*
    描述
写出一个程序，接受一个字符串，然后输出该字符串反转后的字符串。（字符串长度不超过1000）

数据范围： 0 \le n \le 10000≤n≤1000
要求：空间复杂度 O(n)O(n)，时间复杂度 O(n)O(n)
    示例1
    输入：
    "abcd"
    返回值：
    "dcba"

 */
public class StringReverse {
    public static void main(String[] args) {
        char [] s={'s','b'};
        for (int min = 0,max=s.length-1; min < max; min++,max--) {
            char temp=s[min];
            s[min]=s[max];
            s[max]=temp;
        }
        System.out.println(s);

        String str="abcn";
        StringBuffer sb = new StringBuffer(str);
        StringBuffer reverse = sb.reverse();
        System.out.println(reverse);
    }

}
