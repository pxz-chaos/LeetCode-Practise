package TwoSum;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName DemoTwoSum
 * @Description TODO
 * @Author Zhang Peixin
 * @Date 2021/10/19 14:01
 * @Version 1.0
 */
public class DemoTwoSum {
    /*
    给定一个整数数组 nums?和一个整数目标值 target，请你在该数组中找出 和为目标值 target? 的那?两个?整数，并返回它们的数组下标。

你可以假设每种输入只会对应一个答案。但是，数组中同一个元素在答案里不能重复出现。

你可以按任意顺序返回答案。

?

示例 1：

输入：nums = [2,7,11,15], target = 9
输出：[0,1]
解释：因为 nums[0] + nums[1] == 9 ，返回 [0, 1] 。
示例 2：

输入：nums = [3,2,4], target = 6
输出：[1,2]
示例 3：

输入：nums = [3,3], target = 6
输出：[0,1]

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/two-sum
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */
    public static void main(String[] args) {
        //int[] ints = show01(new int[]{1, 2, 5,2,3, 4}, 6);
        int[] ints = twoSum(new int[]{1, 2, 5, 2, 3, 4}, 6);
        System.out.println(Arrays.toString(ints));
    }

    private static int[] show01(int[] nums, int target) {
        int[] ints = new int[2];
        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if ((nums[i] + nums[j]) == target) {
                    ints[0] = i;
                    ints[1] = j;
                }
            }
        }

        return ints;
    }

    public static int[] twoSum(int[] numbers, int target) {
        // write code here
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < numbers.length; i++) {
            if (map.get(target - numbers[i]) != null) {
                return new int[]{map.get(target - numbers[i]) + 1, i + 1};
            }
            map.put(numbers[i], i);

        }
        return null;
    }
}


