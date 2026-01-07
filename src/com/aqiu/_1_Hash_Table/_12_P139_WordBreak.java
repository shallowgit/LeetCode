package com.aqiu._1_Hash_Table;

import java.util.HashSet;
import java.util.List;

/**
 * Word Break
 *
 * @author Aqiu
 */
public class _12_P139_WordBreak {
    public static void main(String[] args) {
        Solution solution = new _12_P139_WordBreak().new Solution();

    }

    class Solution {
        /**
         * 题解链接：https://leetcode.cn/problems/word-break/solution/dan-ci-chai-fen-by-leetcode-solution/
         */
        //以“空串可拆分”为起点，用动态规划数组记录字符串前i个字符的拆分合法性，通过两层循环枚举拆分点，借助哈希集合快速验证子串是否在字典中，用子问题的合法结果推导整个字符串能否拆分。
        public boolean wordBreak(String s, List<String> wordDict) {
            HashSet<String> hashSet = new HashSet<>(wordDict);
            boolean[] flag = new boolean[s.length() + 1];
            flag[0] = true;
            for (int i = 1; i <= s.length(); i++) {
                for (int j = 0; j < i; j++) {
                    if (flag[j] && hashSet.contains(s.substring(j, i))) {
                        flag[i] = true;
                        break;
                    }
                }
            }
            return flag[s.length()];
        }

        /**
         * 采取剪枝，j从后往前遍历
         * 解释下这里j为什么要从后往前遍历。
         * 实际上来讲， for (int j=0; j<i; j++) 和 for (int j=i; j>=0; j--) 这两种写法都是正确答案；
         * 但是我们想优化下，在判断 set.contains(s.substring(j, i))，如果 j-i 比 set 中的最长串都大，那么 contains 肯定是 false；
         * 所以优化有两种写法：（maxLen 为字典中最长的字符串长度）
         * for (int j=0; j<i && (i-j)<=maxLen; j++)
         * for (int j=i; j>=0 && (i-j)<=maxLen; j--)
         * 为什么前一种是错的呢？ 回到题目，我们的状态转移方程： dp[i] = dp[j] && check(s[j...i-1])
         * 我们的 check 重点是在 s[j...i-1]，即从 i 往前倒数，如果倒数的个数超过了 maxLen，那么就没有意义了，check 肯定为 false；
         * 所以这里检查长度是否超过 maxLen 时，必须用倒数遍历方式；
         */
        /**
         * 剪枝的核心逻辑是：子串s[j..i)的长度i-j如果超过字典最长单词长度maxLen，这个子串肯定不在字典里，无需检查。因此我们只需检查满足i-j <= maxLen的j（即j >= i - maxLen）
         * 从前往后的写法会导致循环提前终止，漏掉合法的拆分点j，最终错误判断flag[i]；而从后往前遍历能精准覆盖所有需要检查的j，不会漏检
         */
        public boolean wordBreak2(String s, List<String> wordDict) {
            boolean[] flag = new boolean[s.length() + 1];
            flag[0] = true;
            HashSet<String> hashSet = new HashSet<>();
            int maxLength = 0;
            for (String s1 : wordDict) {
                hashSet.add(s1);
                maxLength = Math.max(maxLength, s1.length());
            }
            for (int i = 1; i <= s.length(); i++) {
                for (int j = i; j >= i - maxLength; j--) {
                    if (flag[j] && hashSet.contains(s.substring(j, i))) {
                        flag[i] = true;
                    }
                }
            }
            return flag[s.length()];
        }
    }
}