package com.aqiu._1_Hash_Table;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

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
                String key = String.valueOf(ch);
                if(!hashMap.containsKey(key)) {
                    hashMap.put(key,new ArrayList<>());
                }
                hashMap.get(key).add(str);
            }
            return new ArrayList<>(hashMap.values());
        }
    }
//leetcode submit region end(Prohibit modification and deletion)
}