package com.aqiu._3_Array_String;

public class _9_P14_LongestCommonPrefix {
    public static void main(String[] args) {
        Solution solution = new _9_P14_LongestCommonPrefix().new Solution();
    }

    //https://leetcode.cn/problems/longest-common-prefix/solutions/8348/hua-jie-suan-fa-14-zui-chang-gong-gong-qian-zhui-b/?envType=study-plan-v2&envId=top-interview-150
    //令最长公共前缀 ans 的值为第一个字符串，进行初始化
    //遍历后面的字符串，依次将其与 ans 进行比较，两两找出公共前缀，最终结果即为最长公共前缀
    //如果查找过程中出现了 ans 为空的情况，则公共前缀不存在直接返回
    class Solution {
        public String longestCommonPrefix(String[] strs) {
            if (strs.length == 0) {
                return "";
            }
            String ans = strs[0];
            for (int i = 1; i < strs.length; i++) {
                int j = 0;
                for (; j < ans.length() && j < strs[i].length(); j++) {
                    if (ans.charAt(j) != strs[i].charAt(j)) {
                        break;
                    }
                }
                ans = ans.substring(0, j);
            }
            return ans;
        }
    }
}