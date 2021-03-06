package 二分法;

/*
给定一个排序数组和一个目标值，在数组中找到目标值，并返回其索引。
如果目标值不存在于数组中，返回它将会被按顺序插入的位置。

请必须使用时间复杂度为 O(log n) 的算法。
nums = [1,3,5,6], target = 5
输出: 2
示例?2:

输入: nums = [1,3,5,6], target = 2
输出: 1
示例 3:

输入: nums = [1,3,5,6], target = 7
输出: 4
示例 4:

输入: nums = [1,3,5,6], target = 0
输出: 0

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/search-insert-position
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class _35搜索插入排序 {
    public int searchInsert(int[] nums, int target) {

        int left = 0, right = nums.length - 1;

        int res = right + 1;//先让指针指向最后的一个空位置
        while (left <= right) {
//            int mid = (right + left) >> 1;//不建议用这个，因为int可能溢出
            int mid = ((right-left) >> 1)+left;
            if (target <= nums[mid]) {
                res = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return res;

    }
}
