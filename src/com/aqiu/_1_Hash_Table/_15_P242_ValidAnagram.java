package com.aqiu._1_Hash_Table;

import java.util.HashMap;

public class _15_P242_ValidAnagram {
    public static void main(String[] args) {
        Solution solution = new _15_P242_ValidAnagram().new Solution();

    }

    class Solution {
        public boolean isAnagram(String s, String t) {
            if (s.length() != t.length()) {
                return false;
            }
            int[] ints = new int[26];
            for (int i = 0; i < s.length(); i++) {
                ints[s.charAt(i) - 'a']++;
            }
            for (int i = 0; i < t.length(); i++) {
                ints[t.charAt(i) - 'a']--;
                if (ints[t.charAt(i) - 'a'] < 0) {
                    return false;
                }
            }
            return true;
        }
    }
}