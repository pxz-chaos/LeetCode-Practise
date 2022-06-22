package 二分法;

import 二分法.modle.VersionControl;

/*
你是产品经理，目前正在带领一个团队开发新的产品。不幸的是，你的产品的最新版本没有通过质量检测。
由于每个版本都是基于之前的版本开发的，所以错误的版本之后的所有版本都是错的。

假设你有 n 个版本 [1, 2, ..., n]，你想找出导致之后所有版本出错的第一个错误的版本。
你可以通过调用?bool isBadVersion(version)?接口来判断版本号 version 是否在单元测试中出错。实现一个函数来查找第一个错误的版本。你应该尽量减少对调用 API 的次数。

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/first-bad-version
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class _278_第一个错误的版本 extends VersionControl {
    public int firstBadVersion(int n) {

        int left = 0;
        int right = n - 1;

        int res = n;
        while (left <= right) {
            int mid = ((right-left) >> 1)+left;
            //今天学到的，不能用（left+right）/2形式，当left和right都是int，
            // 两个值的初始值都超过int限定大小的一半，
            // 那么left+right就会发生溢出，
            // 所以应该用left+(right-left)/2来防止求中值时候的溢出。
            if (isBadVersion(mid)) {
                res = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return res;
    }
}



