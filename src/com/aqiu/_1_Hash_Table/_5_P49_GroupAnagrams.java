package com.aqiu._1_Hash_Table;

import java.util.*;

/**
 * @author Aqiu
 */
public class _5_P49_GroupAnagrams {
    public static void main(String[] args) {
        Solution solution = new _5_P49_GroupAnagrams().new Solution();
        solution.groupAnagrams(new String[]{"eat", "tea", "tan", "ate", "nat", "bat"});
    }

    class Solution {
        public List<List<String>> groupAnagrams(String[] strs) {
            HashMap<String, ArrayList<String>> hashMap = new HashMap<>();
            for (String str : strs) {
                char[] ch = str.toCharArray();
                Arrays.sort(ch);
                String sortedStr = String.valueOf(ch);
                hashMap.computeIfAbsent(sortedStr, k -> new ArrayList<>()).add(str);
            }
            return new ArrayList<>(hashMap.values());
        }
    }
//leetcode submit region end(Prohibit modification and deletion)
}