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
        List<String> result = new ArrayList<>();

        public List<String> letterCombinations(String digits) {
            backtrace(new StringBuilder(), digits, 0);
            return result;
        }

        public void backtrace(StringBuilder sb, String digits, int index) {
            if (sb.length() == digits.length()) {
                result.add(sb.toString());
                return;
            }
            String curSeq = mapping[digits.charAt(index) - '0'];
            for (int i = 0; i < curSeq.length(); i++) {
                sb.append(curSeq.charAt(i));
                backtrace(sb, digits, index + 1);
                sb.deleteCharAt(index);
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)
}