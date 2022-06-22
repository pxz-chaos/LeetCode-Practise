package LongestSubstring;

import javax.xml.stream.events.EndDocument;
import java.util.*;

/**
 * @ClassName Demo01
 * @Description TODO
 * @Author Zhang Peixin
 * @Date 2021/10/19 15:54
 * @Version 1.0
 */
/*
    给定一个字符串 s ，请你找出其中不含有重复字符的 最长子串 的长度。
        示例 1:
        输入: s = "abcabcbb"
        输出: 3
        解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
 */
public class Demo01 {
    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring("sadfhjdhfds"));


    }

    public static int lengthOfLongestSubstring(String s) {

        HashMap<Character, Integer> map = new HashMap<>();
        int max = 0, start = 0;
        for (int end = 0; end < s.length(); end++) {
            char ch = s.charAt(end);
            if (map.containsKey(ch)){
                start = Math.max(map.get(ch)+1,start);
            }
            max = Math.max(max,end - start + 1);
            map.put(ch,end);
        }
        return max;
    }
}

