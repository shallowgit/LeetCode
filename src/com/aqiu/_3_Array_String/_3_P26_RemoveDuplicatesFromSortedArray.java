package com.aqiu._3_Array_String;

import java.util.Arrays;

public class _3_P26_RemoveDuplicatesFromSortedArray {
    public static void main(String[] args) {
        Solution solution = new _3_P26_RemoveDuplicatesFromSortedArray().new Solution();
    }

    class Solution {
        public int removeDuplicates(int[] nums) {
            int i = 0, j = 1;
            while (j < nums.length) {
                if (nums[i] != nums[j]) {
                    nums[i + 1] = nums[j];
                    i++;
                }
                j++;
            }
            return i + 1;
        }
    }
}
