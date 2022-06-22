package 栈;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Stack;

/**
 * @ClassName _155_最小栈
 * @Description TODO
 * @Author Zhang Peixin
 * @Date 2021/12/3 14:35
 * @Version 1.0
 */
/*
设计一个支持 push ，pop ，top 操作，并能在常数时间内检索到最小元素的栈。

push(x) —— 将元素 x 推入栈中。
pop()?—— 删除栈顶的元素。
top()?—— 获取栈顶元素。
getMin() —— 检索栈中的最小元素。
?

示例:

输入：
["MinStack","push","push","push","getMin","pop","top","getMin"]
[[],[-2],[0],[-3],[],[],[],[]]

输出：
[null,null,null,null,-3,null,0,-2]

解释：
MinStack minStack = new MinStack();
minStack.push(-2);
minStack.push(0);
minStack.push(-3);
minStack.getMin();   --> 返回 -3.
minStack.pop();
minStack.top();      --> 返回 0.
minStack.getMin();   --> 返回 -2.

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/min-stack
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class _155_最小栈 {

    Stack<Integer> stack;
    Stack<Integer> stackTmp;

    public _155_最小栈() {
        stack = new Stack<>();
        stackTmp = new Stack<>();
        stackTmp.push(Integer.MAX_VALUE);//先添加一个元素进去
    }

    public void push(int val) {

        stack.push(val);
        stackTmp.push(Math.min(stackTmp.peek(), val));

    }

    public void pop() {
        stack.pop();
        stackTmp.pop();
    }

    public int top() {
        return stack.peek();

    }

    public int getMin() {
        return stackTmp.peek();

    }

    public static void main(String[] args) {
        _155_最小栈 v = new _155_最小栈();
        v.push(-1);
        v.push(-2);
        v.push(15);
        v.push(-4);
        v.push(0);
        while (!v.stack.isEmpty()) {
            System.out.println(v.stack.pop());
            System.out.println(v.stackTmp.pop());
        }

      /*  System.out.println(v.stack.size());
        System.out.println(v.stackTmp.size());*/

    }
}

