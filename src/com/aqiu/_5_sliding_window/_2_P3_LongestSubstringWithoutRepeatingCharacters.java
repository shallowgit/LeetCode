package com.aqiu._5_sliding_window;

import java.util.HashMap;
import java.util.HashSet;

public class _2_P3_LongestSubstringWithoutRepeatingCharacters {
    public static void main(String[] args) {
        Solution solution = new _2_P3_LongestSubstringWithoutRepeatingCharacters().new Solution();
    }

    //滑动窗口
    //在每一步的操作中，将左指针向右移动一格，表示开始枚举下一个字符作为起始位置，然后不断地向右移动右指针，但需要保证这两个指针对应的子串中没有重复的字符。
    //在移动结束后，这个子串就对应着 以左指针开始的，不包含重复字符的最长子串。记录下这个子串的长度
    //在枚举结束后，找到的最长的子串的长度即为答案
    class Solution {
        public int lengthOfLongestSubstring(String s) {
            int length = s.length();
            if (length < 2) {
                return length;
            }
            HashSet<Character> set = new HashSet<>();
            int start = 0, end = 0;
            int ans = 0;
            while (end < length) {
                if (set.contains(s.charAt(end))) {
                    while (start < end && s.charAt(start) != s.charAt(end)) {
                        set.remove(s.charAt(start));
                        start++;
                    }
                    start++;
                }
                set.add(s.charAt(end));
                ans = Math.max(ans, end - start + 1);
                end++;
            }
            return ans;
        }
    }

    //每次左指针右移一位，移除set的一个字符，这一步会导致很多无用的循环。
    //while循环发现的重复字符不一定就是Set最早添加那个，还要好多次循环才能到达，这些都是无效循环，不如直接用map记下每个字符的索引，直接进行跳转
    class Solution2 {
        public int lengthOfLongestSubstring(String s) {
            HashMap<Character, Integer> map = new HashMap<>();
            int start = 0, end = 0, ans = 0, length = s.length();
            while (end < length) {
                if (map.containsKey(s.charAt(end))) {
                    start = Math.max(map.get(s.charAt(end)) + 1, start);
                }
                ans = Math.max(ans, end - start + 1);
                map.put(s.charAt(end), end);
                end++;
            }
            return ans;
        }
    }
}