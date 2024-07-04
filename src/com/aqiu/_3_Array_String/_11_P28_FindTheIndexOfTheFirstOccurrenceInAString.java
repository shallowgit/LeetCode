package com.aqiu._3_Array_String;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class _11_P28_FindTheIndexOfTheFirstOccurrenceInAString {
    public static void main(String[] args) {
        Solution solution = new _11_P28_FindTheIndexOfTheFirstOccurrenceInAString().new Solution();
    }

    //让字符串 needle 与字符串 haystack 的所有长度为 m 的子串均匹配一次。
    //为了减少不必要的匹配，我们每次匹配失败即立刻停止当前子串的匹配，对下一个子串继续匹配。
    //如果当前子串匹配成功，我们返回当前子串的开始位置即可。如果所有子串都匹配失败，则返回 −1
    class Solution {
        public int strStr(String haystack, String needle) {
            int m = haystack.length();
            int n = needle.length();
            for (int i = 0; i + n <= m; i++) {
                boolean flag = true;
                for (int j = 0; j < n; j++) {
                    if (haystack.charAt(i + j) != needle.charAt(j)) {
                        flag = false;
                        break;
                    }
                }
                if (flag) {
                    return i;
                }
            }
            return -1;
        }
    }
}