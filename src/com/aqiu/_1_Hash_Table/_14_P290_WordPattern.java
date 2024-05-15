package com.aqiu._1_Hash_Table;

import java.util.HashMap;

public class _14_P290_WordPattern {
    public static void main(String[] args) {
        Solution solution = new _14_P290_WordPattern().new Solution();
    }

    //利用哈希表记录每一个字符对应的字符串，以及每一个字符串对应的字符。
    //然后枚举每一对字符与字符串的配对过程，不断更新哈希表，如果发生了冲突，则说明给定的输入不满足双射关系。
    class Solution {
        public boolean wordPattern(String pattern, String s) {
            String[] split = s.split(" ");
            if (pattern.length() != split.length) {
                return false;
            }
            HashMap<Character, String> map1 = new HashMap<>();
            HashMap<String, Character> map2 = new HashMap<>();
            for (int i = 0; i < pattern.length(); i++) {
                char c = pattern.charAt(i);
                if (map1.containsKey(c)) {
                    if (!(map1.get(c).equals(split[i]))) {
                        return false;
                    }
                } else {
                    map1.put(c, split[i]);
                }
                if (map2.containsKey(split[i])) {
                    if (!(map2.get(split[i]).equals(c))) {
                        return false;
                    }
                } else {
                    map2.put(split[i], c);
                }
            }
            return true;
        }
    }
}