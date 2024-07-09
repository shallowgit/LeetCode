package com.aqiu._4_dual_pointer;

public class _2_P392_IsSubsequence {
    public static void main(String[] args) {
        Solution solution = new _2_P392_IsSubsequence().new Solution();
    }

    //初始化两个指针 i 和 j，分别指向 s 和 t 的初始位置。
    //匹配成功则 i 和 j 同时右移，匹配 s 的下一个位置，匹配失败则 j 右移，i 不变，尝试用 t 的下一个字符匹配 s。
    //最终如果 i 移动到 s 的末尾，就说明 s 是 t 的子序列
    class Solution {
        public boolean isSubsequence(String s, String t) {
            int i = 0, j = 0;
            int m = s.length(), n = t.length();
            while (i < m && j < n) {
                if (s.charAt(i) == t.charAt(j)) {
                    i++;
                }
                j++;
            }
            return i == m;
        }
    }
}