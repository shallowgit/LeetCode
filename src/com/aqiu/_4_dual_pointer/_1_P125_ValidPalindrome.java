package com.aqiu._4_dual_pointer;

public class _1_P125_ValidPalindrome {
    public static void main(String[] args) {
        Solution solution2 = new _1_P125_ValidPalindrome().new Solution();
        solution2.isPalindrome("0P");
    }

    //使用双指针。初始时，左右指针分别指向 sgood 的两侧，随后我们不断地将这两个指针相向移动，每次移动一步，并判断这两个指针指向的字符是否相同。
    // 当这两个指针相遇时，就说明 sgood 时回文串
    class Solution {
        public boolean isPalindrome(String s) {
            StringBuilder builder = new StringBuilder();
            for (int i = 0; i < s.length(); i++) {
                char c = s.charAt(i);
                if (Character.isLetterOrDigit(c)) {
                    builder.append(Character.toLowerCase(c));
                }
            }
            int i = 0, j = builder.length() - 1;
            while (i < j) {
                if (builder.charAt(i) != builder.charAt(j)) {
                    return false;
                }
                i++;
                j--;
            }
            return true;
        }
    }

    //直接在原字符串 s 上使用双指针。在移动任意一个指针时，需要不断地向另一指针的方向移动，直到遇到一个字母或数字字符，或者两指针重合为止。
    //也就是说，每次将指针移到下一个字母字符或数字字符，再判断这两个指针指向的字符是否相同
    class Solution2 {
        public boolean isPalindrome(String s) {
            int length = s.length();
            int i = 0, j = length - 1;
            while (i < j && j >= 0) {
                Character x = null, y = null;
                while (i < j) {
                    if (Character.isLetterOrDigit(s.charAt(i))){
                        x = Character.toLowerCase(s.charAt(i));
                        i++;
                        break;
                    }
                }
                while (i < j && j >= 0) {
                    if (Character.isLetterOrDigit(s.charAt(j))) {
                        y = Character.toLowerCase(s.charAt(j));
                        j--;
                        break;
                    }
                }
                if (x != y) {
                    return false;
                }
                i++;
                j--;
            }
            return true;
        }
    }
}