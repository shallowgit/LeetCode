package com.aqiu;

//Symbol       Value
//I             1
//V             5
//X             10
//L             50
//C             100
//D             500
//M             1000

import java.util.HashMap;

public class P13_RomanToInteger {
    public static void main(String[] args) {
        Solution solution = new P13_RomanToInteger().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
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
            }
            return 0;
        }
    }

    class Solution3 {
        private int result = 0;

        public int romanToInt(String s) {
            int length = s.length();
            int[] num = new int[length];
            for (int i = 0; i < length; i++) {
                switch (s.charAt(i)) {
                    case 'I':
                        num[i] = 1;
                        break;
                    case 'V':
                        num[i] = 5;
                        break;
                    case 'X':
                        num[i] = 10;
                        break;
                    case 'L':
                        num[i] = 50;
                        break;
                    case 'C':
                        num[i] = 100;
                        break;
                    case 'D':
                        num[i] = 500;
                        break;
                    case 'M':
                        num[i] = 1000;
                        break;
                }
            }
            for (int i = 0; i < length; i++) {
                if (i < length - 1 && num[i - 1] < num[i])
                    num[i] = -num[i];
                result += num[i];
            }
            return result;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)
}