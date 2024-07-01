package com.aqiu._3_Array_String;

public class _8_P58_LengthOfLastWord {
    public static void main(String[] args) {
        Solution solution = new _8_P58_LengthOfLastWord().new Solution();
    }

    class Solution {
        public int lengthOfLastWord(String s) {
            int i = s.length() - 1;
            while (s.charAt(i) == ' ') {
                i--;
            }
            int result = 0;
            while (i >= 0 && s.charAt(i) != ' ') {
                i--;
                result++;
            }
            return result;
        }
    }
}
