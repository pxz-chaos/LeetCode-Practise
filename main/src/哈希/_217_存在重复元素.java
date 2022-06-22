package 哈希;

import java.util.*;

public class _217_存在重复元素 {
    public boolean containsDuplicate(int[] nums) {
        TreeSet<Integer> set = new TreeSet<>();

        boolean flag = false;
        for (int i = 0; i < nums.length; i++) {

            if (set.contains(nums[i])) {
                flag = true;
            }
            set.add(nums[i]);
        }
        return flag;
    }
    public boolean containsDuplicate1(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        for (int x:nums
             ) {
            if (!set.add(x)){
                return true;
            }
        }
        return false;
    }

    public boolean containsDuplicate2(int[] nums) {

        TreeSet<Integer> set = new TreeSet<>();

        for (int i = 0; i < nums.length; i++) {
            set.add(nums[i]);
        }

        return set.size() < nums.length ? true : false;
    }

    public boolean containsDuplicate3(int[] nums) {
        Arrays.sort(nums);
        for (int i = 0; i < nums.length-1; i++) {
            if (nums[i]==nums[i+1]) return true;
        }
        return false;
    }
}
