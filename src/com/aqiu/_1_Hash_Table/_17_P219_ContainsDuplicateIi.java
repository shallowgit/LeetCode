package com.aqiu._1_Hash_Table;

import java.util.HashMap;

public class _17_P219_ContainsDuplicateIi {
    public static void main(String[] args) {
        Solution solution = new _17_P219_ContainsDuplicateIi().new Solution();
    }

    class Solution {
        public boolean containsNearbyDuplicate(int[] nums, int k) {
            HashMap<Integer, Integer> hashMap = new HashMap<>();
            hashMap.put(nums[0], 0);
            for (int i = 1; i < nums.length; i++) {
                if (hashMap.containsKey(nums[i]) && i - hashMap.get(nums[i]) <= k) {
                    return true;
                }
                hashMap.put(nums[i], i);
            }
            return false;
        }
    }
}