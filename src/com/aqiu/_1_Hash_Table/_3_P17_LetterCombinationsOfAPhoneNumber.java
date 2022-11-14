package com.aqiu._1_Hash_Table;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Aqiu
 */
public class _3_P17_LetterCombinationsOfAPhoneNumber {
    public static void main(String[] args) {
        Solution solution = new _3_P17_LetterCombinationsOfAPhoneNumber().new Solution();
        solution.letterCombinations("23");
    }

    class Solution {
        String[] mapping = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        List<String> list = new ArrayList<>();

        public List<String> letterCombinations(String digits) {
            if (digits.length() != 0) {
                func(new StringBuilder(), digits, 0);
            }
            return list;
        }

        public void func(StringBuilder sb, String digits, int index) {
            if (sb.length() == digits.length()) {
                list.add(sb.toString());
                return;
            }
            int no = Integer.parseInt(String.valueOf(digits.charAt(index)));
            for (int i = 0; i < mapping[no].length(); i++) {
                sb.append(mapping[no].charAt(i));
                func(sb, digits, index + 1);
                sb.deleteCharAt(index);
            }
            return;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)
}