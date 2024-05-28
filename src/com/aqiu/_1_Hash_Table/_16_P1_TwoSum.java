package com.aqiu._1_Hash_Table;

import java.util.HashMap;

public class _16_P1_TwoSum {
    public static void main(String[] args) {
        Solution solution = new _16_P1_TwoSum().new Solution();
    }

    class Solution {
        public int[] twoSum(int[] nums, int target) {
            HashMap<Integer, Integer> hashMap = new HashMap<>();
            for (int i = 0; i < nums.length; i++) {
                if (hashMap.containsKey(target - nums[i])) {
                    return new int[]{i, hashMap.get(target - nums[i])};
                } else {
                    hashMap.put(nums[i], i);
                }
            }
            return null;
        }
    }
}