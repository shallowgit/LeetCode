package com.aqiu._1_Hash_Table;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;

public class _13_P383_RansomNote {
    public static void main(String[] args) {
        Solution solution = new _13_P383_RansomNote().new Solution();

    }

    //标准哈希表解决的方法，只需要遍历两次哈希表，第一次放入杂志，第二次统计哈希表里是否能组成赎金信
    class Solution {
        public boolean canConstruct(String ransomNote, String magazine) {
            if (ransomNote.length() > magazine.length()) {
                return false;
            }
            HashMap<Character, Integer> map = new HashMap<>();
            char[] resourceChars = magazine.toCharArray();
            for (char resourceChar : resourceChars) {
                map.put(resourceChar, map.getOrDefault(resourceChar, 0) + 1);
            }
            char[] goalChars = ransomNote.toCharArray();
            for (char goalChar : goalChars) {
                if (map.containsKey(goalChar)) {
                    int num = map.get(goalChar) - 1;
                    if (num < 0) {
                        return false;
                    }
                    map.put(goalChar, num);
                } else {
                    return false;
                }
            }
            return true;
        }
    }

    //首先统计 magazine 中每个英文字母 a的次数 cnt[a]，再遍历统计 ransomNote中每个英文字母的次数，
    //如果发现 ransomNote中存在某个英文字母 c的统计次数大于 magazine中该字母统计次数 cnt[c]，则此时直接返回 false
    class Solution2 {
        public boolean canConstruct(String ransomNote, String magazine) {
            if (ransomNote.length() > magazine.length()) {
                return false;
            }
            int[] count = new int[26];
            for (char c : magazine.toCharArray()) {
                count[c - 'a']++;
            }
            for (char c : ransomNote.toCharArray()) {
                if (--count[c - 'a'] < 0) {
                    return false;
                }
            }
            return true;
        }
    }

    /**
     * 总结
     * 时间效率：理论复杂度均为 O(m + n)，但数组版本无哈希计算 / 冲突 / 装箱等额外开销，实际运行速度更快；
     * 空间效率：理论复杂度均为常数级 O(1)，但数组版本占用固定且极小的内存（26 个 int），HashMap 有大量额外结构开销；
     * 场景适配：本题是小写英文字母场景，数组版本是最优选择，HashMap 版本仅胜在通用性（但本题用不上）。
     */
}