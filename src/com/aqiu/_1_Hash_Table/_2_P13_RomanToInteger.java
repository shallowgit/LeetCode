package com.aqiu._1_Hash_Table;

//Symbol       Value
//I             1
//V             5
//X             10
//L             50
//C             100
//D             500
//M             1000

import java.util.HashMap;

/**
 * @author Aqiu
 */
public class _2_P13_RomanToInteger {
    public static void main(String[] args) {
        Solution solution = new _2_P13_RomanToInteger().new Solution();
    }

    class Solution {
        private HashMap<Character, Integer> hashMap = new HashMap<>();

        {
            hashMap.put('I', 1);
            hashMap.put('V', 5);
            hashMap.put('X', 10);
            hashMap.put('L', 50);
            hashMap.put('C', 100);
            hashMap.put('D', 500);
            hashMap.put('M', 1000);
        }

        private int result = 0;

        public int romanToInt(String s) {
            StringBuilder sb = new StringBuilder(s);
            while (sb.length() != 0) {
                if (sb.length() == 1) {
                    result += hashMap.get(sb.charAt(0));
                    return result;
                }
                if (hashMap.get(sb.charAt(0)) < hashMap.get(sb.charAt(1))) {
                    result += hashMap.get(sb.charAt(1)) - hashMap.get(sb.charAt(0));
                    sb.delete(0, 2);
                } else {
                    result += hashMap.get(sb.charAt(0));
                    sb.deleteCharAt(0);
                }
            }
            return result;
        }
    }

    class Solution2 {
        public int romanToInt(String s) {
            s = s.replace("IV", "a");
            s = s.replace("IX", "b");
            s = s.replace("XL", "c");
            s = s.replace("IL", "d");
            s = s.replace("XC", "e");
            s = s.replace("CD", "f");
            s = s.replace("CM", "g");
            int result = 0;
            for (int i = 0; i < s.length(); i++) {
                result += getValue(s.charAt(i));
            }
            return result;
        }

        public int getValue(char c) {
            switch (c) {
                case 'I':
                    return 1;
                case 'V':
                    return 5;
                case 'X':
                    return 10;
                case 'L':
                    return 50;
                case 'C':
                    return 100;
                case 'D':
                    return 500;
                case 'M':
                    return 1000;
                case 'a':
                    return 4;
                case 'b':
                    return 9;
                case 'c':
                    return 40;
                case 'd':
                    return 49;
                case 'e':
                    return 90;
                case 'f':
                    return 400;
                case 'g':
                    return 900;
                default:
                    return 0;
            }
        }
    }

    class Solution3 {
        public int romanToInt(String s) {
            int result = 0;
            int pre = 0;
            for (int i = 0; i < s.length(); i++) {
                int cur = getValue(s.charAt(i));
                if (pre < cur) {
                    result -= 2 * pre;
                }
                result += cur;
                pre = cur;
            }
            return result;
        }

        public int getValue(char c) {
            switch (c) {
                case 'I':
                    return 1;
                case 'V':
                    return 5;
                case 'X':
                    return 10;
                case 'L':
                    return 50;
                case 'C':
                    return 100;
                case 'D':
                    return 500;
                case 'M':
                    return 1000;
            }
            return 0;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)
}