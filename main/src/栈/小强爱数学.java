package 栈;

/*
小强发现当已知以及时,能很轻易的算出的值.但小强想请你在已知 和的情况下,计算出的值.因为这个结果可能很大,所以所有的运算都在模1e9+7下进行.

输入描述:
第一行输入一个正整数.表示有组数据
接下来行,每行输入三个整数,和.
输出行,每一行表示每组数据的结果.

输入例子1:
3
4 4 3
2 3 4
5 2 6

输出例子1:
16
999999993
9009


 */

import java.util.*;

/**
 * 阿里2 已知 x+y=A xy = B 求x^n+y^n
 * 递推式 xn = Axn-1 - Bxn-2
 */

public class 小强爱数学 {
    static long mod = (long) Math.pow(10, 9) + 7;

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int m = in.nextInt();
        for (int i = 0; i < m; i++) {
            long a = in.nextInt();
            long b = in.nextInt();
            int n = in.nextInt();
            a %= mod;
            b %= mod;
            System.out.println(solve(a, b, n));
        }
    }

    public static long solve(long a, long b, int n) {
        long[] nums = new long[n + 1];
        nums[1] = a;
        if (n == 1) return nums[1]; //1次方直接等于A
        nums[2] = (a * a % mod - 2 * b % mod + mod) % mod;
        if (n == 2) return nums[2];
        for (int i = 3; i <= n; i++)
            nums[i] = ((a * nums[i - 1] % mod) - (b * nums[i - 2] % mod) + mod) % mod;
        return nums[n];
    }

}

