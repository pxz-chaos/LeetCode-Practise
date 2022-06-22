package ThreeSum;

import java.util.*;

/**
 * @ClassName Demo01ThreeSum
 * @Description TODO
 * @Author Zhang Peixin
 * @Date 2021/11/9 20:47
 * @Version 1.0
 */
/*
给你一个包含 n 个整数的数组?nums，判断?nums?中是否存在三个元素 a，b，c ，使得?a + b + c = 0 ？请你找出所有和为 0 且不重复的三元组。

注意：答案中不可以包含重复的三元组。

?

示例 1：

输入：nums = [-1,0,1,2,-1,-4]
输出：[[-1,-1,2],[-1,0,1]]
示例 2：

输入：nums = []
输出：[]
示例 3：

输入：nums = [0]
输出：[]

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/3sum
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Demo01ThreeSum {
    public static void main(String[] args) {
        int[] nums = {-1, 0, 1, 2, -1, -4};
        List<List<Integer>> list = threeSum(nums);
        List<List<Integer>> list1 = threeSumPLUS2(nums);
        System.out.println(list1);
    }


    public static List<List<Integer>> threeSum(int[] nums) {
        int n = nums.length;
        Arrays.sort(nums);
        List<List<Integer>> ans = new ArrayList<List<Integer>>();
        // 枚举 a
        for (int first = 0; first < n; ++first) {
            // 需要和上一次枚举的数不相同
            if (first > 0 && nums[first] == nums[first - 1]) {
                continue;
            }
            // c 对应的指针初始指向数组的最右端
            int third = n - 1;
            int target = -nums[first];
            // 枚举 b
            for (int second = first + 1; second < n; ++second) {
                // 需要和上一次枚举的数不相同
                if (second > first + 1 && nums[second] == nums[second - 1]) {
                    continue;
                }
                // 需要保证 b 的指针在 c 的指针的左侧
                while (second < third && nums[second] + nums[third] > target) {
                    --third;
                }
                // 如果指针重合，随着 b 后续的增加
                // 就不会有满足 a+b+c=0 并且 b<c 的 c 了，可以退出循环
                if (second == third) {
                    break;
                }
                if (nums[second] + nums[third] == target) {
                    List<Integer> list = new ArrayList<Integer>();
                    list.add(nums[first]);
                    list.add(nums[second]);
                    list.add(nums[third]);
                    ans.add(list);
                }
            }
        }
        return ans;
    }

    public static List<List<Integer>> threeSum1(int[] nums) {
        if (nums == null || nums.length < 3) {
            return new ArrayList<>();
        }
        //  List<List<Integer>> res = new ArrayList<>();

        Set<List<Integer>> res = new HashSet<>();//用于去重


        //o(n^3)时间复杂度
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                for (int k = j + 1; k < nums.length; k++) {
                    if (nums[i] + nums[j] + nums[k] == 0) {
                        // res.add();//[[-1, -1, 2], [-1, 0, 1], [-1, 0, 1]]，有重复的元素
                        //怎么解决呢？
                        //这里采用set集合去重
                        List<Integer> list = Arrays.asList(nums[i], nums[j], nums[k]);//把这个集合记住
                        Collections.sort(list);
                        //res.add(list);//[[-1, -1, 2], [-1, 0, 1], [-1, 0, 1]]
//                        String str = list.toString();
//                        if(!set.contains(str)){
//                            set.add(str);
//                            res.add(list);
//                        }
                        res.add(list);
                    }
                }
            }
        }
        return new ArrayList<>(res);
    }

    public static List<List<Integer>> threeSumPLUS(int[] nums) {
        if (nums == null || nums.length < 3) {
            return new ArrayList<>();
        }
        Arrays.sort(nums);//o(nlogn)
        //  List<List<Integer>> res = new ArrayList<>();

        Set<List<Integer>> set = new HashSet<>();//用于去重

        //不需要三重循环了，先固定一个元素，那么剩下的就是两数之和了
        //nums={-4,-1,-1,0,1,2}事先排好序
        for (int i = 0; i < nums.length; i++) {
            //剩下的两数之和采用双指针
            //搞两个指针，left,right
            //nums={-4,-1,-1,0,1,2}
            //先让i指向-4，left指向-1，right指向2，让left+right之和等于-i，如果小了，left右移
            int target = -nums[i];
            int left = i + 1;
            int right = nums.length - 1;
            while (left < right) {
                int twoSum = nums[left] + nums[right];
                if (twoSum == target) {
                    //找到一对儿了,放入到set集合中，让其自动去重
                    set.add(Arrays.asList(nums[i], nums[left], nums[right]));
                    left++;
                    right--;
                } else if (twoSum < target) {
                    left++;
                } else {
                    right--;
                }

            }
        }

        return new ArrayList<>(set);//o(n)
    }

    //优化去重
    public static List<List<Integer>> threeSumPLUS2(int[] nums) {
        if (nums == null || nums.length < 3) {
            return new ArrayList<>();
        }
        Arrays.sort(nums);//o(nlogn)
        List<List<Integer>> res = new ArrayList<>();

        // Set<List<Integer>> res = new HashSet<>();//用于去重

        //不需要三重循环了，先固定一个元素，那么剩下的就是两数之和了
        //nums={-4,-1,-1,0,1,2}事先排好序
        for (int i = 0; i < nums.length; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) continue;//去重的意思
            //剩下的两数之和采用双指针
            //搞两个指针，left,right
            //nums={-4,-1,-1,0,1,2}
            //先让i指向-4，left指向-1，right指向2，让left+right之和等于-i，如果小了，left右移
            int target = -nums[i];
            int left = i + 1;
            int right = nums.length - 1;
            while (left < right) {
                int twoSum = nums[left] + nums[right];
                if (twoSum == target) {
                    //找到一对儿了,放入到set集合中，让其自动去重
                    res.add(Arrays.asList(nums[i], nums[left], nums[right]));
//                    left++;
//                    right--;
                    //去重,这里的操作只让twoSum之和的两个元素去重了，但是万一nums[i]==nums[i-1]，那岂不是第一个又来了一个重复的
                    //比如nums[i]刚开始等于-1，可以的组合为[-1,-1,2],[-1,0,1]不会再出现[-1,0,1],因为nums[left]，nums[right]已经去重了
                    //所以nums[i]还需要去重
                    while (left < right && nums[left] == nums[++left]) continue;
                    while (left < right && nums[right] == nums[--right]) continue;

                } else if (twoSum < target) {
                    left++;
                } else {
                    right--;
                }

            }
        }

        return res;
    }
}
