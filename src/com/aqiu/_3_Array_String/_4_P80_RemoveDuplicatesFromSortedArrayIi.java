package com.aqiu._3_Array_String;

public class _4_P80_RemoveDuplicatesFromSortedArrayIi {
    public static void main(String[] args) {
        Solution solution = new _4_P80_RemoveDuplicatesFromSortedArrayIi().new Solution();

    }

    class Solution {
        public int removeDuplicates(int[] nums) {
            if (nums.length < 3) {
                return nums.length;
            }
            int slow = 2, fast = 2;
            while (fast < nums.length) {
                if (nums[slow - 2] != nums[fast]) {
                    nums[slow] = nums[fast];
                    slow++;
                }
                fast++;
            }
            return slow;
        }
    }
}
