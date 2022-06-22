package 栈;

import java.awt.event.KeyAdapter;
import java.util.HashMap;
import java.util.Stack;

/**
 * @ClassName _20_有效的括号
 * @Description TODO
 * @Author Zhang Peixin
 * @Date 2021/11/23 20:14
 * @Version 1.0
 */
/*
给定一个只包括 '('，')'，'{'，'}'，'['，']'?的字符串 s ，判断字符串是否有效。

有效字符串需满足：

左括号必须用相同类型的右括号闭合。
左括号必须以正确的顺序闭合。
?

示例 1：

输入：s = "()"
输出：true
示例?2：

输入：s = "()[]{}"
输出：true
示例?3：

输入：s = "(]"
输出：false
示例?4：

输入：s = "([)]"
输出：false
示例?5：

输入：s = "{[]}"
输出：true

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/valid-parentheses
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class _20_有效的括号 {
    public static boolean isValid(String s) {
        while (s.contains("{}") || s.contains("()") || s.contains("[]")) {
            s = s.replace("{}", "");
            s = s.replace("()", "");
            s = s.replace("[]", "");
        }
        return s.isEmpty();
    }

    public static boolean isValid2(String s) {
        int len = s.length();
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < len; i++) {
            char c = s.charAt(i);
            if (c == '(' || c == '{' || c == '[') {//如果是左字符，入栈
                stack.push(c);
            } else {//右括号
                if (stack.isEmpty()) return false;
                char left = stack.pop();
                if (left == '(' && c != ')') return false;

                if (left == '{' && c != '}') return false;
                if (left == '[' && c != ']') return false;
            }
        }
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        isValid3("(){}[]");


    }

    private static boolean isValid3(String s) {
        int len = s.length();
        if (len % 2 != 0) return false;
        char[] chars = new char[len];
        int count = 0;
        for (int i = 0; i < len; i++) {
            char c = s.charAt(i);
            if (c == '(' || c == '[' || c == '{') chars[count++] = c;
            else if (c == ')' && count > 0 && chars[count - 1] == '(') count--;
            else if (c == ']' && count > 0 && chars[count - 1] == '[') count--;
            else if (c == '}' && count > 0 && chars[count - 1] == '{') count--;
            else return false;
        }
        return count == 0 ? true : false;
    }

    private HashMap<Character, Character> map = new HashMap<>();

    //初始化map集合
    public _20_有效的括号() {
        map.put('(', ')');
        map.put('{', '}');
        map.put('[', ']');
    }

    private boolean isValid4(String s) {
        int len = s.length();
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < len; i++) {
            char c = s.charAt(i);
            if (map.containsKey(c)) {//左括号
                stack.push(c);

            } else {//右括号
                if (stack.isEmpty()) return false;
                char left = stack.pop();
                char value = map.get(left);
                if (c != value) return false;
            }
        }
        return stack.isEmpty();
    }

}
