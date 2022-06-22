package MinMoves;



import java.util.Arrays;
import java.util.Collections;

/**
 * @ClassName Demo01MinMoves
 * @Description TODO
 * @Author Zhang Peixin
 * @Date 2021/10/21 10:32
 * @Version 1.0
 */
/*
    453. 最小操作次数使数组元素相等
    给你一个长度为 n 的整数数组，每次操作将会使 n - 1 个元素增加 1 。
    返回让数组所有元素相等的最小操作次数。

    题目只有唯一的操作：使 n - 1 个元素增加 1，这个操作实际上可以等价于使1个元素减少1。
    而只要保证数组中最小的元素不要再减小，对其他的元素使用这个操作，最终所有元素都减至最小值就可以结束了。
    我们只需要进行两次遍历，第一次遍历找出最小值，第二次遍历求每个元素与最小值的差值，也就是操作次数，
    最后对操作次数求和就是我们的答案了。

作者：BNDSllx
链接：https://leetcode-cn.com/problems/minimum-moves-to-equal-array-elements/solution/suan-fa-xiao-ai-ni-men-du-bian-da-liao-b-2crt/
来源：力扣（LeetCode）
著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。

 */
public class Demo01MinMoves {
    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 5};
        System.out.println(minMan(nums));


    }


    public static int minMoves(int[] nums) {

        /* Arrays.sort(nums);
        int ans = 0;
       int  min=num[0];
        for (int num : nums) {
            ans += num - min;
        }
        return ans;

         */
        /*
        如果我们只是希望让所有元素相等；只看相对差距的话，那选出n-1个增加1和剩下那个减少1有什么区别？没有区别！
         */
        int minNum = Arrays.stream(nums).min().getAsInt();

        int res = 0;
        for (int num : nums) {
            res += num - minNum;
        }
        return res;
    }

    public static int minMan(int[] arr) {
        int res = 0;
      /*  int min = 0;
        for (int i = 0; i < arr.length; i++) {
            min = arr[0];
            if (min >arr[i]) {
                min = arr[i];
            }
        }*/
        int min = Arrays.stream(arr).min().getAsInt();
        for (int i = 0; i < arr.length; i++) {
            res += (arr[i] - min);
        }
        return res;
    }
}
