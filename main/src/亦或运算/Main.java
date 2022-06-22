package 亦或运算;

/**
 * 题目1：给定一个数组，数组中的一种数出现了奇数次，其他数只出现了偶数次
 * 求这个出现了奇数次的数
 * <p>
 * * 题目2：给定一个数组，数组中的两种数出现了奇数次，其他数只出现了偶数次
 * * 求这个出现了奇数次的数的这两个数
 */
public class Main {
    public static void main(String[] args) {
        int[] arr = {1, 2, 2, 1, 3, 3, 3, 3, 2, 4, 4, 4};
        System.out.println(twoOdd(arr));
    }

    /**
     * 题目1：给定一个数组，数组中的一种数出现了奇数次，其他数只出现了偶数次
     *
     * @param arr 给定一个数组
     * @return 出现了奇数次的这个数
     */
    public static int oneOdd(int[] arr) {
        /*
        思路：用0去亦或任何数都等于这个数本身，
        那么0去亦或偶数个数，会全部变为0，奇数个数将会被保留下来
         */
        int eor = 0;
        for (int num : arr) {
            eor = eor ^ num;
        }
        return eor;
    }

    /**
     * 题目2：给定一个数组，数组中的两种数出现了奇数次，其他数只出现了偶数次
     *
     * @param arr 给定一个数组
     * @return 出现奇数次的两个数
     */
    public static int twoOdd(int[] arr) {
        /*
        思路：用0去亦或任何数都等于这个数本身，
        那么0去亦或偶数个数，会全部变为0，奇数个数将会被保留下来

        最后eor一定是这两个数的亦或
        设这两个数分别为a,b
        eor=a^b

         */
        int eor = 0;
        for (int num : arr) {
            eor ^= num;
        }
        //eor=a^b;
        //eor!=0;
        //eor必然有一个位置是1
        //"~"是取反的意思
        //一个数与 上自己取反加1，就把自己最右的那个1搞出来了

        int rightOne = eor & (~eor + 1);//提取出eor最右边的1

        int onlyOne = 0;//eor'
        for (int cur : arr) {
            if ((cur & rightOne) == 0) {
                onlyOne ^= cur;
            }

            //onlyOne的结果是a或者b
        }
        return eor ^ onlyOne;
    }
}
