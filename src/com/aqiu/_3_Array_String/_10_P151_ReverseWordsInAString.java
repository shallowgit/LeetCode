package com.aqiu._3_Array_String;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class _10_P151_ReverseWordsInAString {
    public static void main(String[] args) {
        Solution solution = new _10_P151_ReverseWordsInAString().new Solution();
        solution.reverseWords("a good   example");
    }

    class Solution {
        public String reverseWords(String s) {
            List<String> list = Arrays.asList(s.trim().split("\\s+"));
            Collections.reverse(list);
            return String.join(" ", list);
        }
    }

    //倒着遍历，每次取出其中的单词，从前往后加入result中即可
    class Solution2 {
        public String reverseWords(String s) {
            char[] chars = s.toCharArray();
            StringBuilder result = new StringBuilder();
            // 倒着遍历
            for (int i = s.length() - 1; i >= 0; i--) {
                // 找到单词的结束位置
                while (i >= 0 && chars[i] == ' ') {
                    i--;
                }
                if (i < 0) {
                    break;
                }
                int end = i;
                // 找到单词的起点
                while (i >= 0 && chars[i] != ' ') {
                    i--;
                }
                result.append(s, i + 1, end + 1).append(" ");
            }
            return result.toString().trim();
        }
    }
}