package 栈;

import java.util.Arrays;
import java.util.Stack;

/**
 * @ClassName 腾讯2020校园招聘_后台
 * @Description TODO
 * @Author Zhang Peixin
 * @Date 2021/12/17 19:54
 * @Version 1.0
 */
/*
小Q在周末的时候和他的小伙伴来到大城市逛街，一条步行街上有很多高楼，共有n座高楼排成一行。
小Q从第一栋一直走到了最后一栋，小Q从来都没有见到这么多的楼，所以他想知道他在每栋楼的位置处能看到多少栋楼呢？（当前面的楼的高度大于等于后面的楼时，后面的楼将被挡住）
 当小Q处于位置3时，他可以向前看到位置2,1处的楼，向后看到位置4,6处的楼，加上第3栋楼，共可看到5栋楼。当小Q处于位置4时，他可以向前看到位置3处的楼，向后看到位置5,6处的楼，加上第4栋楼，共可看到4栋楼。
 */
public class 腾讯2020校园招聘_后台 {


    public int[] findBuilding(int[] heights) {
        if (heights == null || heights.length < 0) return null;
        int[] res = new int[heights.length];
        Stack<Integer> stack = new Stack<>();
        // 从前向后遍历，维持一个递减栈
        for (int i = 0; i < heights.length; i++) {
            res[i] = stack.size(); //前面能看到的数量
            while (!stack.isEmpty() && heights[i] >= heights[stack.peek()]) {
                stack.pop();
            }
            stack.push(i);
        }
        stack.clear();
        // 从后向前遍历，同样维持递减栈
        for (int i = heights.length - 1; i >= 0; i--) {
            res[i] = res[i] + 1 + stack.size();
            ;//后面能看到的数量 + 自己
            while (!stack.isEmpty() && heights[i] >= heights[stack.peek()]) {
                stack.pop();
            }
            stack.push(i);
        }
        return res;

    }

    public static void main(String[] args) {
        int[] heights = {5, 3, 8, 3, 2, 5};
        腾讯2020校园招聘_后台 V = new 腾讯2020校园招聘_后台();
        int[] building = V.findBuilding(heights);
        System.out.println(Arrays.toString(building));

    }
}
